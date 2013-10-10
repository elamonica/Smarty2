;
import javax.annotation.Resource;

import grails.rest.*;

@grails.rest.Resource(uri='/preguntas', formats=['json', 'xml'])
class Pregunta {
	
	String code
	
	String question
	
	int position 
	
	//static hasMany = [possibleAnswers: RespuestaPosible]
	
	public String toString() { return question }
} 
