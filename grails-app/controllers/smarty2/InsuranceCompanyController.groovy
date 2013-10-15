package smarty2



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class InsuranceCompanyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond InsuranceCompany.list(params), model:[insuranceCompanyInstanceCount: InsuranceCompany.count()]
    }

    def show(InsuranceCompany insuranceCompanyInstance) {
        respond insuranceCompanyInstance
    }

    def create() {
        respond new InsuranceCompany(params)
    }

    @Transactional
    def save(InsuranceCompany insuranceCompanyInstance) {
        if (insuranceCompanyInstance == null) {
            notFound()
            return
        }

        if (insuranceCompanyInstance.hasErrors()) {
            respond insuranceCompanyInstance.errors, view:'create'
            return
        }

        insuranceCompanyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'insuranceCompanyInstance.label', default: 'InsuranceCompany'), insuranceCompanyInstance.id])
                redirect insuranceCompanyInstance
            }
            '*' { respond insuranceCompanyInstance, [status: CREATED] }
        }
    }

    def edit(InsuranceCompany insuranceCompanyInstance) {
        respond insuranceCompanyInstance
    }

    @Transactional
    def update(InsuranceCompany insuranceCompanyInstance) {
        if (insuranceCompanyInstance == null) {
            notFound()
            return
        }

        if (insuranceCompanyInstance.hasErrors()) {
            respond insuranceCompanyInstance.errors, view:'edit'
            return
        }

        insuranceCompanyInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'InsuranceCompany.label', default: 'InsuranceCompany'), insuranceCompanyInstance.id])
                redirect insuranceCompanyInstance
            }
            '*'{ respond insuranceCompanyInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(InsuranceCompany insuranceCompanyInstance) {

        if (insuranceCompanyInstance == null) {
            notFound()
            return
        }

        insuranceCompanyInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'InsuranceCompany.label', default: 'InsuranceCompany'), insuranceCompanyInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'insuranceCompanyInstance.label', default: 'InsuranceCompany'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
