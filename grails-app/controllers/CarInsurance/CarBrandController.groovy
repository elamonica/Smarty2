package CarInsurance



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CarBrandController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CarBrand.list(params), model:[carBrandInstanceCount: CarBrand.count()]
    }

    def show(CarBrand carBrandInstance) {
        respond carBrandInstance
    }

    def create() {
        respond new CarBrand(params)
    }

    @Transactional
    def save(CarBrand carBrandInstance) {
        if (carBrandInstance == null) {
            notFound()
            return
        }

        if (carBrandInstance.hasErrors()) {
            respond carBrandInstance.errors, view:'create'
            return
        }

        carBrandInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'carBrandInstance.label', default: 'CarBrand'), carBrandInstance.id])
                redirect carBrandInstance
            }
            '*' { respond carBrandInstance, [status: CREATED] }
        }
    }

    def edit(CarBrand carBrandInstance) {
        respond carBrandInstance
    }

    @Transactional
    def update(CarBrand carBrandInstance) {
        if (carBrandInstance == null) {
            notFound()
            return
        }

        if (carBrandInstance.hasErrors()) {
            respond carBrandInstance.errors, view:'edit'
            return
        }

        carBrandInstance.save flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CarBrand.label', default: 'CarBrand'), carBrandInstance.id])
                redirect carBrandInstance
            }
            '*'{ respond carBrandInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CarBrand carBrandInstance) {

        if (carBrandInstance == null) {
            notFound()
            return
        }

        carBrandInstance.delete flush:true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CarBrand.label', default: 'CarBrand'), carBrandInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'carBrandInstance.label', default: 'CarBrand'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
