package smarty2



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class InsuranceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Insurance.list(params), model:[insuranceInstanceCount: Insurance.count()]
    }

    def show(Insurance insuranceInstance) {
        respond insuranceInstance
    }

    def create() {
        respond new Insurance(params)
    }

    @Transactional
    def save(Insurance insuranceInstance) {
        if (insuranceInstance == null) {
            notFound()
            return
        }

        if (insuranceInstance.hasErrors()) {
            respond insuranceInstance.errors, view:'create'
            return
        }

        insuranceInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'insuranceInstance.label', default: 'Insurance'), insuranceInstance.id])
                redirect insuranceInstance
            }
            '*' { respond insuranceInstance, [status: CREATED] }
        }
    }

    def edit(Insurance insuranceInstance) {
        respond insuranceInstance
    }

    @Transactional
    def update(Insurance insuranceInstance) {
        if (insuranceInstance == null) {
            notFound()
            return
        }

        if (insuranceInstance.hasErrors()) {
            respond insuranceInstance.errors, view:'edit'
            return
        }

        insuranceInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Insurance.label', default: 'Insurance'), insuranceInstance.id])
                redirect insuranceInstance
            }
            '*'{ respond insuranceInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Insurance insuranceInstance) {

        if (insuranceInstance == null) {
            notFound()
            return
        }

        insuranceInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Insurance.label', default: 'Insurance'), insuranceInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'insuranceInstance.label', default: 'Insurance'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
