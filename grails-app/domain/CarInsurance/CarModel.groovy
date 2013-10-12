package CarInsurance

@grails.rest.Resource()
class CarModel {
	
	String name
	
	static belongsTo = [carBrand: CarBrand]
	
    static constraints = {
    }
	
	public String toString(){
		return name
	}
}
