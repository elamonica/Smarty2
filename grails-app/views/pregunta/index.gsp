
<%@ page import="CarInsurance.Pregunta" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pregunta.label', default: 'Pregunta')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pregunta" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pregunta" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="code" title="${message(code: 'pregunta.code.label', default: 'Code')}" />
					
						<g:sortableColumn property="position" title="${message(code: 'pregunta.position.label', default: 'Position')}" />
					
						<g:sortableColumn property="question" title="${message(code: 'pregunta.question.label', default: 'Question')}" />
					
						<g:sortableColumn property="typeWeight" title="${message(code: 'pregunta.typeWeight.label', default: 'Type Weight')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${preguntaInstanceList}" status="i" var="preguntaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${preguntaInstance.id}">${fieldValue(bean: preguntaInstance, field: "code")}</g:link></td>
					
						<td>${fieldValue(bean: preguntaInstance, field: "position")}</td>
					
						<td>${fieldValue(bean: preguntaInstance, field: "question")}</td>
					
						<td>${fieldValue(bean: preguntaInstance, field: "typeWeight")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${preguntaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
