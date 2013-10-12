package smarty2

import CarInsurance.InsuranceType;

class Insurance {

	InsuranceType insuranceType
	Integer price	// el precio conviene sacarlo de la poliza y relacionarlo a traves de la empresa o un Tarifador -eze
	String description
	String details
	
	static belongsTo= [company: InsuranceCompany]
	
    static constraints = {
    }
}
