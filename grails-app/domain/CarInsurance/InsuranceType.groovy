package CarInsurance

public enum InsuranceType {

    todoRiesgo("TR","Todo Riesgo"), 
	responsabilidadCivil("RC","Responsabilidad Civil"),
	tercerosCompleto("TC","Terceros Completo"),
	tercerosCompletosFull("TCF","Terceros Completo Full"),
	tercerosCompletosFullGranizo("TCFG","Terceros Completo Full + Granizo")

	InsuranceType(String code, String description) { 
		this.description = description
		this.code = code
		}
    
	private final String description
	private final String code
    
	public String description() { return description }
	public String code() { return code }
	
	public String toString(){
		return this.description()
	}
}
