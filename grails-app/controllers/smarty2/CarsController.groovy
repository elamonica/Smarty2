package smarty2

import CarInsurance.CarBrand;
import grails.converters.JSON

class CarsController {

	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
    def index() { }
	
	def brands(){
		
		render CarBrand.all as JSON
	}
	
	def models(){
		render CarBrand.findById(params.id).models as JSON
	}
	
}
