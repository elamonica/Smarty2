
<%@ page import="smarty2.InsuranceCompany" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'insuranceCompany.label', default: 'InsuranceCompany')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-insuranceCompany" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-insuranceCompany" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list insuranceCompany">
			
				<g:if test="${insuranceCompanyInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="insuranceCompany.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${insuranceCompanyInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${insuranceCompanyInstance?.polizas}">
				<li class="fieldcontain">
					<span id="polizas-label" class="property-label"><g:message code="insuranceCompany.polizas.label" default="Polizas" /></span>
					
						<g:each in="${insuranceCompanyInstance.polizas}" var="p">
						<span class="property-value" aria-labelledby="polizas-label"><g:link controller="insurance" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${insuranceCompanyInstance?.website}">
				<li class="fieldcontain">
					<span id="website-label" class="property-label"><g:message code="insuranceCompany.website.label" default="Website" /></span>
					
						<span class="property-value" aria-labelledby="website-label"><g:fieldValue bean="${insuranceCompanyInstance}" field="website"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:insuranceCompanyInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${insuranceCompanyInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
