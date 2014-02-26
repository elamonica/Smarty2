package smarty2;

import grails.transaction.Transactional
import CarInsurance.MMC
import CarInsurance.CarBrand
import CarInsurance.CarModel

class MmcCacheService {

	def brands = []
	def models = []
    
	def initialize() {
		def pi = 0
		for(int i = 500; pi < MMC.count; i += 500){
			MMC.list(max:i, ofset: pi).eachWithIndex { obj, index ->
				def ma = new CarBrand(name: obj.marca)
				ma.id = index + pi
				brands.add(ma)
				def mo = new CarModel(name: obj.modelo, carBrand: ma, code: obj.cod)
				mo.id = index + pi
				models.add(mo)
			}
			pi = i
		}
		brands = brands.unique()
	}
	
	def carBrandsById(idBrand) {
		def r = []
		models.each {
			if (it.carBrand.id.toString() == idBrand.toString())
				r.add(it)
		}
		
		return r
	}
	
	
}
