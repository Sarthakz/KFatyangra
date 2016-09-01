<%@ page import="kfatyangra.Member" %>



<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'fullName', 'error')} ">
	<label for="fullName">
		<g:message code="member.fullName.label" default="Full Name" />
		
	</label>
	<g:textField name="fullName" value="${memberInstance?.fullName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="member.password.label" default="Password" />
		
	</label>
	<g:textField name="password" value="${memberInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'role', 'error')} required">
	<label for="role">
		<g:message code="member.role.label" default="Role" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="role" name="role.id" from="${kfatyangra.Role.list()}" optionKey="id" required="" value="${memberInstance?.role?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: memberInstance, field: 'username', 'error')} ">
	<label for="username">
		<g:message code="member.username.label" default="Username" />
		
	</label>
	<g:textField name="username" value="${memberInstance?.username}"/>
</div>

