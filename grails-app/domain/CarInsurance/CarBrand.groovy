package CarInsurance

@grails.rest.Resource(formats=['json', 'xml'])
class CarBrand {

	String name
	
	static hasMany= [models: CarModel]
	
    static constraints = {
    }
	
	public String toString(){
		return name
	}
}
