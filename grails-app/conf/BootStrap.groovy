import CarInsurance.*

class BootStrap {

    def init = { servletContext ->
		
		def preg1 = new Pregunta(code:"1", question: "¿Cobertura contra terceros?", position: 1)
		preg1.save(flush:true)
		def preg2 = new Pregunta(code:"2", question: "¿Robo total?", position: 2)
		preg2.save(flush:true)
		def preg3 = new Pregunta(code:"3", question: "¿Incendio total?", position: 3)
		preg3.save(flush:true)
		def preg4 = new Pregunta(code:"4", question: "¿Destrucción total?", position: 4)
		preg4.save(flush:true)
		def preg5 = new Pregunta(code:"5", question: "¿Sin límites de cobertura?", position: 5)
		preg5.save(flush:true)
		def preg6 = new Pregunta(code:"6", question: "¿Cobertura contra granizo?", position: 6)
		preg6.save(flush:true)
		def preg7 = new Pregunta(code:"7", question: "¿Es para vos importante la solvencia de la compañia?", position: 7)
		preg7.save(flush:true)
		def preg8 = new Pregunta(code:"8", question: "¿Buscás que la compañia te preste un auto hasta que el tuyo sea reparado?", position: 8)
		preg8.save(flush:true)
		def preg9 = new Pregunta(code:"9", question: "¿Buscás que el seguro tenga cobertura en países limítrofes?", position: 9)
		preg9.save(flush:true)
		def preg10 = new Pregunta(code:"10", question: "¿Buscás que cubra urgencias mecánicas y el servicio de grúa?", position: 10)
		preg10.save(flush:true)
		def preg11 = new Pregunta(code:"11", question: "¿Querés evitar tener que presentar presupuestos y aportar fotos del sinietro?", position: 11)
		preg11.save(flush:true)
		def preg12 = new Pregunta(code:"12", question: "¿Qué prioridad tiene el tiempo de pago de los siniestros?", position: 12)
		preg12.save(flush:true)
		def preg13 = new Pregunta(code:"13", question: "¿Buscás que tu seguro incluya cobertura adicional en gastos médicos por accidentes?", position: 13)
		preg13.save(flush:true)
		
		def porshe = new CarBrand()
		porshe.name = "Porshe"
		porshe.models = new HashSet()
		porshe.save(flush:true)
		def bmw = new CarBrand()
		bmw.name = "BMW"
		bmw.models = new HashSet()
		bmw.save(flush:true)
		def ferrari = new CarBrand()
		ferrari.name = "Ferrari"
		ferrari.models = new HashSet()
		ferrari.save(flush:true)
		
		def carrera = new CarModel()
		carrera.name = "Carrera"
		carrera.carBrand = porshe
		carrera.save(flush: true)
		
		def testaRossa = new CarModel()
		testaRossa.name = "Testa Rossa"
		testaRossa.carBrand = ferrari
		testaRossa.save(flush: true)
    }
    def destroy = {
    }
}
