<%@ page import="CarInsurance.CarModel" %>



<div class="fieldcontain ${hasErrors(bean: carModelInstance, field: 'carBrand', 'error')} required">
	<label for="carBrand">
		<g:message code="carModel.carBrand.label" default="Car Brand" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="carBrand" name="carBrand.id" from="${CarInsurance.CarBrand.list()}" optionKey="id" required="" value="${carModelInstance?.carBrand?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: carModelInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="carModel.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${carModelInstance?.name}"/>
</div>

