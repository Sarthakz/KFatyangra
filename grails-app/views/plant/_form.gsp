<%@ page import="kfatyangra.Plant" %>



<div class="fieldcontain ${hasErrors(bean: plantInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="plant.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${plantInstance?.name}"/>
</div>

