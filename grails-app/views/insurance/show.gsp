
<%@ page import="smarty2.Insurance" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'insurance.label', default: 'Insurance')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-insurance" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-insurance" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list insurance">
			
				<g:if test="${insuranceInstance?.company}">
				<li class="fieldcontain">
					<span id="company-label" class="property-label"><g:message code="insurance.company.label" default="Company" /></span>
					
						<span class="property-value" aria-labelledby="company-label"><g:link controller="insuranceCompany" action="show" id="${insuranceInstance?.company?.id}">${insuranceInstance?.company?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${insuranceInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="insurance.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${insuranceInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${insuranceInstance?.details}">
				<li class="fieldcontain">
					<span id="details-label" class="property-label"><g:message code="insurance.details.label" default="Details" /></span>
					
						<span class="property-value" aria-labelledby="details-label"><g:fieldValue bean="${insuranceInstance}" field="details"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${insuranceInstance?.insuranceType}">
				<li class="fieldcontain">
					<span id="insuranceType-label" class="property-label"><g:message code="insurance.insuranceType.label" default="Insurance Type" /></span>
					
						<span class="property-value" aria-labelledby="insuranceType-label"><g:fieldValue bean="${insuranceInstance}" field="insuranceType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${insuranceInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="property-label"><g:message code="insurance.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${insuranceInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:insuranceInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${insuranceInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
