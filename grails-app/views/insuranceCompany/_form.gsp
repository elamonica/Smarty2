<%@ page import="smarty2.InsuranceCompany" %>



<div class="fieldcontain ${hasErrors(bean: insuranceCompanyInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="insuranceCompany.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${insuranceCompanyInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: insuranceCompanyInstance, field: 'polizas', 'error')} ">
	<label for="polizas">
		<g:message code="insuranceCompany.polizas.label" default="Polizas" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${insuranceCompanyInstance?.polizas?}" var="p">
    <li><g:link controller="insurance" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="insurance" action="create" params="['insuranceCompany.id': insuranceCompanyInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'insurance.label', default: 'Insurance')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: insuranceCompanyInstance, field: 'website', 'error')} ">
	<label for="website">
		<g:message code="insuranceCompany.website.label" default="Website" />
		
	</label>
	<g:textField name="website" value="${insuranceCompanyInstance?.website}"/>
</div>

