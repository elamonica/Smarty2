package smarty2

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
				typeWeightResult[it.code()] = typeWeightResult[it.code()] + aQuestion.typeWeight[it.code().toLowerCase()]
			}
		}
		
		def winnerType = InsuranceType.responsabilidadCivil.code()
		def winnerValue = typeWeightResult[InsuranceType.responsabilidadCivil.code()]
		
		typeWeightResult.each { key, value ->
			if (typeWeightResult[key] > winnerValue){
				winnerType = key
				winnerValue = typeWeightResult[key] 
			}	
		}
		 
		
		def insurances = List
		InsuranceCompany.all.each {  
			def winnerPoliza = it.polizas.find { it.insuranceType.code() == winnerType }
			insurances.add(winnerPoliza)
		}
		
		render insurances as JSON
		
	}
}
