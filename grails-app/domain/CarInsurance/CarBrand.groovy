package CarInsurance

@grails.rest.Resource(uri='/carBrands', formats=['json', 'xml'])
class CarBrand {

	String name
	
	static hasMany= [models: CarModel]
	
    static constraints = {
    }
	
	public String toString(){
		return name
	}
}
