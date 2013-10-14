package smarty2

class AnswerForInsurances {

	List<InsuranceCompany> companyName
	static hasMany = [insurances: Insurance]
	
	
	static mapping = {
		insurances lazy: false
	}
		
    static constraints = {
    }
}
