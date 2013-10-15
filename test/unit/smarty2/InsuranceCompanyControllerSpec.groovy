package smarty2



import grails.test.mixin.*
import spock.lang.*

@TestFor(InsuranceCompanyController)
@Mock(InsuranceCompany)
class InsuranceCompanyControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.insuranceCompanyInstanceList
            model.insuranceCompanyInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.insuranceCompanyInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def insuranceCompany = new InsuranceCompany()
            insuranceCompany.validate()
            controller.save(insuranceCompany)

        then:"The create view is rendered again with the correct model"
            model.insuranceCompanyInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            insuranceCompany = new InsuranceCompany(params)

            controller.save(insuranceCompany)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/insuranceCompany/show/1'
            controller.flash.message != null
            InsuranceCompany.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def insuranceCompany = new InsuranceCompany(params)
            controller.show(insuranceCompany)

        then:"A model is populated containing the domain instance"
            model.insuranceCompanyInstance == insuranceCompany
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def insuranceCompany = new InsuranceCompany(params)
            controller.edit(insuranceCompany)

        then:"A model is populated containing the domain instance"
            model.insuranceCompanyInstance == insuranceCompany
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            status == 404

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def insuranceCompany = new InsuranceCompany()
            insuranceCompany.validate()
            controller.update(insuranceCompany)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.insuranceCompanyInstance == insuranceCompany

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            insuranceCompany = new InsuranceCompany(params).save(flush: true)
            controller.update(insuranceCompany)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/insuranceCompany/show/$insuranceCompany.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            controller.delete(null)

        then:"A 404 is returned"
            status == 404

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def insuranceCompany = new InsuranceCompany(params).save(flush: true)

        then:"It exists"
            InsuranceCompany.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(insuranceCompany)

        then:"The instance is deleted"
            InsuranceCompany.count() == 0
            response.redirectedUrl == '/insuranceCompany/index'
            flash.message != null
    }
}
