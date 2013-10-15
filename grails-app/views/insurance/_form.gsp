<%@ page import="smarty2.Insurance" %>



<div class="fieldcontain ${hasErrors(bean: insuranceInstance, field: 'company', 'error')} required">
	<label for="company">
		<g:message code="insurance.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="company" name="company.id" from="${smarty2.InsuranceCompany.list()}" optionKey="id" required="" value="${insuranceInstance?.company?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: insuranceInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="insurance.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${insuranceInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: insuranceInstance, field: 'details', 'error')} ">
	<label for="details">
		<g:message code="insurance.details.label" default="Details" />
		
	</label>
	<g:textField name="details" value="${insuranceInstance?.details}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: insuranceInstance, field: 'insuranceType', 'error')} required">
	<label for="insuranceType">
		<g:message code="insurance.insuranceType.label" default="Insurance Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="insuranceType" from="${CarInsurance.InsuranceType?.values()}" keys="${CarInsurance.InsuranceType.values()*.name()}" required="" value="${insuranceInstance?.insuranceType?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: insuranceInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="insurance.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" type="number" value="${insuranceInstance.price}" required=""/>
</div>

