
<%@ page import="CarInsurance.Pregunta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pregunta.label', default: 'Pregunta')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-pregunta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-pregunta" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list pregunta">
			
				<g:if test="${preguntaInstance?.code}">
				<li class="fieldcontain">
					<span id="code-label" class="property-label"><g:message code="pregunta.code.label" default="Code" /></span>
					
						<span class="property-value" aria-labelledby="code-label"><g:fieldValue bean="${preguntaInstance}" field="code"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${preguntaInstance?.position}">
				<li class="fieldcontain">
					<span id="position-label" class="property-label"><g:message code="pregunta.position.label" default="Position" /></span>
					
						<span class="property-value" aria-labelledby="position-label"><g:fieldValue bean="${preguntaInstance}" field="position"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${preguntaInstance?.question}">
				<li class="fieldcontain">
					<span id="question-label" class="property-label"><g:message code="pregunta.question.label" default="Question" /></span>
					
						<span class="property-value" aria-labelledby="question-label"><g:fieldValue bean="${preguntaInstance}" field="question"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${preguntaInstance?.typeWeight}">
				<li class="fieldcontain">
					<span id="typeWeight-label" class="property-label"><g:message code="pregunta.typeWeight.label" default="Type Weight" /></span>
					
						<span class="property-value" aria-labelledby="typeWeight-label"><g:fieldValue bean="${preguntaInstance}" field="typeWeight"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:preguntaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${preguntaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
