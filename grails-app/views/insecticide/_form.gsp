<%@ page import="kfatyangra.Insecticide" %>



<div class="fieldcontain ${hasErrors(bean: insecticideInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="insecticide.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${insecticideInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: insecticideInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="insecticide.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${insecticideInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: insecticideInstance, field: 'usage', 'error')} ">
	<label for="usage">
		<g:message code="insecticide.usage.label" default="Usage" />
		
	</label>
	<g:textField name="usage" value="${insecticideInstance?.usage}"/>
</div>

