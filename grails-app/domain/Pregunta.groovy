;
import javax.annotation.Resource;

import grails.rest.*;

@grails.rest.Resource(uri='/preguntas', formats=['json', 'xml'])
class Pregunta {
	
	String code
	
	String question
	
	int position
	
	public String toString() { return question }
} 
