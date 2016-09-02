<%--
  Created by IntelliJ IDEA.
  User: anijor
  Date: 9/2/2016
  Time: 11:19 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Description</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap.min.css')}">
	<script src="${resource(dir: 'js',file: 'bootstrap.min.js')}" type="text/javascript"></script>
	<script src="${resource(dir: 'js',file: 'jquery.js')}" type="text/javascript"></script>
	<style>
	.head{
		background-color:#4CAF50! important;
		color: #f6f1ed! important;
		font-family: "Gill Sans", "Gill Sans MT", Calibri, sans-serif;

	}
	.back {
		margin-left: 1265px;
	}

	</style>
</head>

<body>
<div class="jumbotron head">
	<h1 class="text-center" >KiraFatyangra</h1>
	<g:link controller="recommendation" action="index"><button type="button" class="btn btn-default back">Back</button></g:link>
</div>

<div class="container">

	<form >

		<div class="form-group">
			<label >Name:</label>
			<g:textArea class="form-control" rows="1" id="name" value="${insecticideInstance?.name}" name="name"></g:textArea>
		</div>
		<div class="form-group">
			<label >Description:</label>
			<g:textArea name="description" class="form-control" rows="5" id="description" value="${insecticideInstance?.description}"></g:textArea>
		</div>
		<div class="form-group">
			<label>Usage:</label>
			<g:textArea class="form-control" rows="5" id="comment" value="${insecticideInstance?.usages}" name="usages"></g:textArea>
		</div>


	</form>

</div>
</body>
</html>