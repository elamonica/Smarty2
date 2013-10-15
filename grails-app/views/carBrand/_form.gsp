<%@ page import="CarInsurance.CarBrand" %>



<div class="fieldcontain ${hasErrors(bean: carBrandInstance, field: 'models', 'error')} ">
	<label for="models">
		<g:message code="carBrand.models.label" default="Models" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${carBrandInstance?.models?}" var="m">
    <li><g:link controller="carModel" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="carModel" action="create" params="['carBrand.id': carBrandInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'carModel.label', default: 'CarModel')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: carBrandInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="carBrand.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${carBrandInstance?.name}"/>
</div>

