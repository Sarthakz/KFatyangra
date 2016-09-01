<%--
  Created by IntelliJ IDEA.
  User: Sushant
  Date: 8/31/2016
  Time: 7:25 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
    <g:createLink controller="member" action="create"/>
    <div id="login">
        <g:form controller="login" action="login">
            <g:textField name="username" id="username"/>
            <g:passwordField name="password" id="password"/>
            <g:submitButton name="submit" value="Submit"/>
        </g:form>
    </div>
</body>
</html>