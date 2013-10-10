package smarty2
import grails.rest.*

@Resource(uri='/books')
class Book {

	String title

	static constraints = {
		title blank:false
	}
}