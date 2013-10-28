package smarty2

import java.net.Authenticator.RequestorType;

import javax.naming.directory.SearchResult;

import CarInsurance.InsuranceType;
import CarInsurance.Pregunta;

import com.google.gson.JsonObject;

import grails.converters.JSON

import static grails.async.Promises.*

class SearchInsurancesController {
	
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def search = {
    	def mode = params.mode  // 'e' para todas las empresas y 'p' para todas las polizas

		task {
			if (mode != 'p'){		
				sendMail {
						to params.email
						subject "Gracias por utilizar Servicios Comparados"
						html '<b>Servicios Comparados</b> te mantiene informado.\n Puedes volver a consultarnos por <a href="http://www.servicioscomparados.com">aqui</a> '
				  }
			}
    	}
		def carBrand = params.carBrandId
		def carModel = params.carModelId
		def questionsParam = params.questions
		def questions = questionsParam.split(',')
		def email = params.email
		
		def typeWeightResult= [:]
		
		InsuranceType.values().each {  
			typeWeightResult.put(it.code().toLowerCase(), 0)
		}
		
		questions.each {  aQuestionId ->   
			def aQuestion = Pregunta.findById(aQuestionId)
			
			InsuranceType.values().each {
				typeWeightResult[it.code().toLowerCase()] = typeWeightResult[it.code().toLowerCase()] + aQuestion.typeWeight[it.code().toLowerCase()]
			}
		}
		
		def winnerType = InsuranceType.responsabilidadCivil.code().toLowerCase()
		def winnerValue = typeWeightResult[InsuranceType.responsabilidadCivil.code().toLowerCase()]
		
		typeWeightResult.each { key, value ->
			if (typeWeightResult[key] > winnerValue){
				winnerType = key
				winnerValue = typeWeightResult[key] 
			}	
		}
		 
		def searchResult = []
		InsuranceCompany.all.each {  
			def insurances = new ArrayList<Insurance>()
			def winnerPoliza = it.polizas.find { it.insuranceType.code().toLowerCase() == winnerType }
			insurances.add(winnerPoliza)
			
			if (mode == 'p')
			{
				it.polizas.each { it != winnerPoliza ? insurances.add(it) : null }	
			}
			
			def companyInsuranceResult = ['empresa': it, 'alternativas': insurances]
			searchResult.add(companyInsuranceResult)
		}
		
		searchResult = searchResult.sort { a, b -> a.alternativas.first().price <= b.alternativas.first().price?-1:1 }
		
		def winnerInsuranceTypes = []
		def winnerInsuranceType = InsuranceType.values().find { it.code().equalsIgnoreCase(winnerType) }
		winnerInsuranceTypes.add(winnerInsuranceType)
		
		if (mode == 'p' )
		{
			InsuranceType.values().each { it != winnerInsuranceType ? winnerInsuranceTypes.add(it) : null }
		}
		
		def result = ['tiposPoliza': winnerInsuranceTypes, 'results': searchResult]
		
		render result as JSON
	}
}
