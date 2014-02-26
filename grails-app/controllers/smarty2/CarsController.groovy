package smarty2

import CarInsurance.CarBrand;
import grails.converters.JSON

class CarsController {	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def mmcCacheService
	
    def index() { }
	
	def brands(){
		
		//render CarBrand.all as JSON
		render mmcCacheService.brands as JSON
	}
	
	def models(){
		//render CarBrand.findById(params.id).models as JSON
		render mmcCacheService.carBrandsById(params.id) as JSON
	}
	
}
