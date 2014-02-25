package CarInsurance

@grails.rest.Resource(formats=['json', 'xml'])
class CarModel {
	
	String name
	String code
	
	static belongsTo = [carBrand: CarBrand]
	
    static constraints = {
    }
	
	public String toString(){
		return name
	}
}
