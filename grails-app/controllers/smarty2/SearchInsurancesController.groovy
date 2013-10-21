package smarty2

import javax.naming.directory.SearchResult;

import CarInsurance.InsuranceType;
import CarInsurance.Pregunta;

import com.google.gson.JsonObject;

import grails.converters.JSON

class SearchInsurancesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def search = {
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
			
			def companyInsuranceResult = ['empresa': it, 'alternativas': insurances]
			searchResult.add(companyInsuranceResult)
		}
		
		searchResult = searchResult.sort { a, b -> a.alternativas.first().price <= b.alternativas.first().price?-1:1 }
		
		def winnerInsuranceType = InsuranceType.values().find { it.code().equalsIgnoreCase(winnerType) }
		
		def result = ['tiposPoliza': winnerInsuranceType, 'results': searchResult]
		
		render result as JSON
	}
}
