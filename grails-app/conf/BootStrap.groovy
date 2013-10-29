import grails.converters.JSON;

import org.junit.Before;

import smarty2.InsuranceCompany
import smarty2.Insurance
import CarInsurance.*

class BootStrap {

    def init = { servletContext ->
		
		String tr = InsuranceType.todoRiesgo.code()
		String rc = InsuranceType.responsabilidadCivil.code()
		String tc = InsuranceType.tercerosCompleto.code()
		String tcf = InsuranceType.tercerosCompletosFull.code()
		String tcfg = InsuranceType.tercerosCompletosFullGranizo.code()
		
		
		JSON.registerObjectMarshaller(InsuranceType) {
			def result = [:]
			def props = ['code', 'description']
			props.each { prop ->
				result[prop] = it."$prop"
			}
			result
		}
		
		
		if (!Pregunta.findByCode("1")){
			def preg1 = new Pregunta(code:"1", question: "¿Cobertura contra terceros?", position: 1)
			preg1.typeWeight = [tr:'0', rc: '1', tc:'4', tcf: '3', tcfg: '2']
			preg1.save(flush:true)
		}
		else
		{
			// no cargo nada porque asumo que la pregunta 1 si esta cargada, esta cargado todo el resto
			return
		}
		
		if (!Pregunta.findByCode("2")){
			def preg2 = new Pregunta(code:"2", question: "¿Robo total?", position: 2)
			preg2.typeWeight = [tr:'2', rc: '2', tc:'2', tcf: '1', tcfg: '0']
			preg2.save(flush:true)
		}
		if (!Pregunta.findByCode("3")){
			def preg3 = new Pregunta(code:"3", question: "¿Incendio total?", position: 3)
			preg3.typeWeight = [tr:'2', rc: '1', tc:'1', tcf: '2', tcfg: '1']
			preg3.save(flush:true)
		}
		if (!Pregunta.findByCode("4")){
			def preg4 = new Pregunta(code:"4", question: "¿Destrucción total?", position: 4)
			preg4.typeWeight = [tr:'3', rc: '1', tc:'1', tcf: '2', tcfg: '1']
			preg4.save(flush:true)
		}
		if (!Pregunta.findByCode("5")){
			def preg5 = new Pregunta(code:"5", question: "¿Sin límites de cobertura?", position: 5)
			preg5.typeWeight = [tr:'4', rc: '0', tc:'0', tcf: '3', tcfg: '5']
			preg5.save(flush:true)
		}
		if (!Pregunta.findByCode("6")){
			def preg6 = new Pregunta(code:"6", question: "¿Cobertura contra granizo?", position: 6)
			preg6.typeWeight = [tr:'0', rc: '0', tc:'0', tcf: '0', tcfg: '5']
			preg6.save(flush:true)
		}
		if (!Pregunta.findByCode("7")){
			def preg7 = new Pregunta(code:"7", question: "¿Es para vos importante la solvencia de la compañia?", position: 7)
			preg7.typeWeight = [tr:'1', rc: '1', tc:'1', tcf: '1', tcfg: '1']
			preg7.save(flush:true)		
		}
		if (!Pregunta.findByCode("8")){
			def preg8 = new Pregunta(code:"8", question: "¿Buscás que la compañia te preste un auto hasta que el tuyo sea reparado?", position: 8)
			preg8.typeWeight = [tr:'4', rc: '1', tc:'1', tcf: '1', tcfg: '4']
			preg8.save(flush:true)
		}
		if (!Pregunta.findByCode("9")){
			def preg9 = new Pregunta(code:"9", question: "¿Buscás que el seguro tenga cobertura en países limítrofes?", position: 9)
			preg9.typeWeight = [tr:'1', rc: '1', tc:'1', tcf: '1', tcfg: '1']
			preg9.save(flush:true)
		}
		if (!Pregunta.findByCode("10")){
			def preg10 = new Pregunta(code:"10", question: "¿Buscás que cubra urgencias mecánicas y el servicio de grúa?", position: 10)
			preg10.typeWeight = [tr:'1', rc: '3', tc:'3', tcf: '1', tcfg: '0']
			preg10.save(flush:true)
		}
		if (!Pregunta.findByCode("11")){
			def preg11 = new Pregunta(code:"11", question: "¿Querés evitar tener que presentar presupuestos y aportar fotos del sinietro?", position: 11)
			preg11.typeWeight = [tr:'1', rc: '1', tc:'1', tcf: '1', tcfg: '1']
			preg11.save(flush:true)
		}
		if (!Pregunta.findByCode("12")){
			def preg12 = new Pregunta(code:"12", question: "¿Qué prioridad tiene el tiempo de pago de los siniestros?", position: 12)
			preg12.typeWeight = [tr:'1', rc: '1', tc:'1', tcf: '1', tcfg: '1']
			preg12.save(flush:true)
		}
		if (!Pregunta.findByCode("13")){
			def preg13 = new Pregunta(code:"13", question: "¿Buscás que tu seguro incluya cobertura adicional en gastos médicos por accidentes?", position: 13)
			preg13.typeWeight = [tr:'1', rc: '1', tc:'1', tcf: '1', tcfg: '1']
			preg13.save(flush:true)
		}
		
		
		if (!CarBrand.findByName("BMW")){
			def bmw = new CarBrand()
			bmw.name = "BMW"
			bmw.models = new HashSet()
			bmw.save(flush:true)
		}
			def porshe = new CarBrand()
			porshe.name = "Porsche"
			porshe.models = new HashSet()
		if (!CarBrand.findByName("Porsche")){
			porshe.save(flush:true)
		}
			def ferrari = new CarBrand()
			ferrari.name = "Ferrari"
			ferrari.models = new HashSet()
		
		if (!CarBrand.findByName("Ferrari")){
			ferrari.save(flush:true)
		}
		
		if (!CarModel.findByName("Carrera")){
			def carrera = new CarModel()
			carrera.name = "Carrera"
			carrera.carBrand = porshe
			carrera.save(flush: true)
		}
		if (!CarBrand.findByName("Testa Rossa")){
			def testaRossa = new CarModel()
			testaRossa.name = "Testa Rossa"
			testaRossa.carBrand = ferrari
			testaRossa.save(flush: true)
		}
		
		
		
		def laCaja = new InsuranceCompany(name: 'LaCaja', website: 'http://www.lacaja.com.ar')
		laCaja.polizas = new HashSet()
		laCaja.save(flush:true)
		
		def zurich = new InsuranceCompany(name: 'Zurich', website: 'http://www.zurich.com.ar')
		zurich.polizas = new HashSet()
		zurich.save(flush:true)
		
		def mapfre = new InsuranceCompany(name: 'Mapfre', website: 'http://www.mapfre.com.ar')
		mapfre.polizas = new HashSet()
		mapfre.save(flush:true)
		
		def polTR = new Insurance(insuranceType: InsuranceType.todoRiesgo, price: 500, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.todoRiesgo.description())
		polTR.company = laCaja
		polTR.save(flush:true)
		def polTC = new Insurance(insuranceType: InsuranceType.tercerosCompleto, price: 450, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.tercerosCompleto.description())
		polTC.company = laCaja
		polTC.save(flush:true)
		def polTCF = new Insurance(insuranceType: InsuranceType.tercerosCompletosFull, price: 470, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.tercerosCompletosFull.description())
		polTCF.company = laCaja
		polTCF.save(flush:true)
		def polTCFG = new Insurance(insuranceType: InsuranceType.tercerosCompletosFullGranizo, price: 550, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.tercerosCompletosFullGranizo.description())
		polTCFG.company = laCaja
		polTCFG.save(flush:true)
		def polR = new Insurance(insuranceType: InsuranceType.responsabilidadCivil, price: 350, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.responsabilidadCivil.description())
		polR.company = laCaja
		polR.save(flush:true)
		
		
		def polTR2 = new Insurance(insuranceType: InsuranceType.todoRiesgo, price: 600, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.todoRiesgo.description())
		polTR2.company = zurich
		polTR2.save(flush:true)
		def polTC2 = new Insurance(insuranceType: InsuranceType.tercerosCompleto, price: 350, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.tercerosCompleto.description())
		polTC2.company = zurich
		polTC2.save(flush:true)
		def polTCF2 = new Insurance(insuranceType: InsuranceType.tercerosCompletosFull, price: 370, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.tercerosCompletosFull.description())
		polTCF2.company = zurich
		polTCF2.save(flush:true)
		def polTCFG2 = new Insurance(insuranceType: InsuranceType.tercerosCompletosFullGranizo, price: 350, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.tercerosCompletosFullGranizo.description())
		polTCFG2.company = zurich
		polTCFG2.save(flush:true)
		def polR2 = new Insurance(insuranceType: InsuranceType.responsabilidadCivil, price: 250, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.responsabilidadCivil.description())
		polR2.company = zurich
		polR2.save(flush:true)	
		
		
		def polTR3 = new Insurance(insuranceType: InsuranceType.todoRiesgo, price: 550, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.todoRiesgo.description())
		polTR3.company = mapfre
		polTR3.save(flush:true)
		def polTC3 = new Insurance(insuranceType: InsuranceType.tercerosCompleto, price: 400, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.tercerosCompleto.description())
		polTC3.company = mapfre
		polTC3.save(flush:true)
		def polTCF3 = new Insurance(insuranceType: InsuranceType.tercerosCompletosFull, price: 390, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.tercerosCompletosFull.description())
		polTCF3.company = mapfre
		polTCF3.save(flush:true)
		def polTCFG3 = new Insurance(insuranceType: InsuranceType.tercerosCompletosFullGranizo, price: 360, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.tercerosCompletosFullGranizo.description())
		polTCFG3.company = mapfre
		polTCFG3.save(flush:true)
		def polR3 = new Insurance(insuranceType: InsuranceType.responsabilidadCivil, price: 150, details: 'Se puede pagar en 12 cuotas sin interés', description: InsuranceType.responsabilidadCivil.description())
		polR3.company = mapfre
		polR3.save(flush:true)
		
    }
    def destroy = {
    }
}
