package CarInsurance;

import javax.annotation.Resource;

import grails.rest.*;

@grails.rest.Resource(uri='/preguntas', formats=['json', 'xml'])
class Pregunta {
	
	String code
	
	String question
	
	int position
	
	Map<String,Integer> typeWeight
	
	public String toString() { return question }
} 
