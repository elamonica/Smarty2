package smarty2

class InsuranceCompany {
	
	String name
	String website

	static hasMany= [polizas: Insurance]

    static constraints = {
    }
}
