
<%@ page import="smarty2.Insurance" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'insurance.label', default: 'Insurance')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-insurance" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-insurance" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="insurance.company.label" default="Company" /></th>
					
						<g:sortableColumn property="description" title="${message(code: 'insurance.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="details" title="${message(code: 'insurance.details.label', default: 'Details')}" />
					
						<g:sortableColumn property="insuranceType" title="${message(code: 'insurance.insuranceType.label', default: 'Insurance Type')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'insurance.price.label', default: 'Price')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${insuranceInstanceList}" status="i" var="insuranceInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${insuranceInstance.id}">${fieldValue(bean: insuranceInstance, field: "company")}</g:link></td>
					
						<td>${fieldValue(bean: insuranceInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: insuranceInstance, field: "details")}</td>
					
						<td>${fieldValue(bean: insuranceInstance, field: "insuranceType")}</td>
					
						<td>${fieldValue(bean: insuranceInstance, field: "price")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${insuranceInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
