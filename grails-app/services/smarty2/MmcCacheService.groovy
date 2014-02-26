package smarty2;

import grails.transaction.Transactional
import CarInsurance.MMC
import CarInsurance.CarBrand
import CarInsurance.CarModel

class MmcCacheService {

	def brands = []
	def models = []
    def modelsByBrandId = [:]
	
	def initialize() {
		def pi = 0
		for(int i = 500; pi < MMC.count/2; i += 500){
			MMC.list(max:i, ofset: pi).eachWithIndex { obj, index ->
				def bandPreexistente = brands.find { it.name == obj.marca}
				if (bandPreexistente == null){
					def ma = new CarBrand(name: obj.marca)
					ma.id = index + pi
					bandPreexistente = ma
					
					brands.add(ma)
					modelsByBrandId["a" + ma.id.toString()] = []
				}
				
				
				def mo = new CarModel(name: obj.modelo, carBrand: bandPreexistente, code: obj.cod)
				mo.id = index + pi
				models.add(mo)
				modelsByBrandId["a" + bandPreexistente.id.toString()].add(mo)
			}
			pi = i
		}
	}
	
	def carBrandsById(idBrand) {
		//def r = []
		//models.each {
		//	if (it.carBrand.id.toString() == idBrand.toString())
			//	r.add(it)
		//}
		
		//return r
		
		return modelsByBrandId["a" + idBrand.toString()]
	}
	
	
}
