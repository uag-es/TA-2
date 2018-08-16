
<%@ page import="ta.Report" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'report.label', default: 'Report')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-report" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-report" class="content scaffold-list" role="main">
			<g:link controller="Report" action="saveTXT">-> Salvar em TXT</g:link>
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'report.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="tipo" title="${message(code: 'report.tipo.label', default: 'Tipo')}" />
					
						<g:sortableColumn property="avaliacao" title="${message(code: 'report.avaliacao.label', default: 'Avaliacao')}" />
					
						<g:sortableColumn property="valor" title="${message(code: 'report.valor.label', default: 'Valor')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reportInstanceList}" status="i" var="reportInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link name="${reportInstance.name}" action="show" id="${reportInstance.id}">${fieldValue(bean: reportInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: reportInstance, field: "tipo")}</td>
					
						<td>${fieldValue(bean: reportInstance, field: "avaliacao")}</td>
					
						<td>${fieldValue(bean: reportInstance, field: "valor")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reportInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
