package CarInsurance

@grails.rest.Resource(formats=['json', 'xml'])
class CarModel {
	
	String name
	
	static belongsTo = [carBrand: CarBrand]
	
    static constraints = {
    }
	
	public String toString(){
		return name
	}
}
