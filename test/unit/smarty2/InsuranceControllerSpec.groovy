package smarty2



import grails.test.mixin.*
import spock.lang.*

@TestFor(InsuranceController)
@Mock(Insurance)
class InsuranceControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.insuranceInstanceList
            model.insuranceInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.insuranceInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            def insurance = new Insurance()
            insurance.validate()
            controller.save(insurance)

        then:"The create view is rendered again with the correct model"
            model.insuranceInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            insurance = new Insurance(params)

            controller.save(insurance)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/insurance/show/1'
            controller.flash.message != null
            Insurance.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def insurance = new Insurance(params)
            controller.show(insurance)

        then:"A model is populated containing the domain instance"
            model.insuranceInstance == insurance
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def insurance = new Insurance(params)
            controller.edit(insurance)

        then:"A model is populated containing the domain instance"
            model.insuranceInstance == insurance
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            controller.update(null)

        then:"A 404 error is returned"
            status == 404

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def insurance = new Insurance()
            insurance.validate()
            controller.update(insurance)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.insuranceInstance == insurance

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            insurance = new Insurance(params).save(flush: true)
            controller.update(insurance)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/insurance/show/$insurance.id"
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
            def insurance = new Insurance(params).save(flush: true)

        then:"It exists"
            Insurance.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(insurance)

        then:"The instance is deleted"
            Insurance.count() == 0
            response.redirectedUrl == '/insurance/index'
            flash.message != null
    }
}
