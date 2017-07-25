<%@ page import="kfatyangra.Insecticide" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'insecticide.label', default: 'Insecticide')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-insecticide" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-insecticide" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="description" title="${message(code: 'insecticide.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'insecticide.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="usage" title="${message(code: 'insecticide.usage.label', default: 'Usage')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${insecticideInstanceList}" status="i" var="insecticideInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${insecticideInstance.id}">${fieldValue(bean: insecticideInstance, field: "description")}</g:link></td>
					
						<td>${fieldValue(bean: insecticideInstance, field: "name")}</td>
					
						<td>${fieldValue(bean: insecticideInstance, field: "usage")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${insecticideInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
