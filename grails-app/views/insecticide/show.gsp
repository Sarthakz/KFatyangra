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
	<script>
		function checkRating(){
			var rating = $("#rating").val();
			if(rating){
				return true
			}
			else{
				alert("Please enter rating!!!");
				return false;
			}
		}
	</script>
</head>

<body>
<div class="jumbotron head">
	<h1 class="text-center" >KiraFatyangra</h1>
	<g:link controller="recommendation" action="index"><button type="button" class="btn btn-default back">Back</button></g:link>
</div>

<div class="container">



		<div class="form-group">
			<label >Name:</label>
			<g:textArea class="form-control" rows="1" id="name" value="${insecticideInstance?.name}" name="name"></g:textArea>
		</div>
		<div class="form-group">
			<label >Description:</label>
			<g:textArea name="description" class="form-control" rows="5" id="description" value="${itemInstance?.description}"></g:textArea>
		</div>
		<div class="form-group">
			<label>Usage:</label>
			<g:textArea class="form-control" rows="5" id="comment" value="${itemInstance?.usages}" name="usages"></g:textArea>
		</div>
		<g:form controller="item" action="rating">
			<label>Rating:</label>
			<g:hiddenField name="itemId" id="itemId" value="${itemInstance?.id}"/>
			<g:select name="rating" from="[1,2,3,4,5]" id="rating"/>
			<g:submitButton name="submit" onclick="return checkRating();">Submit</g:submitButton>
		</g:form>




</div>
</body>
</html>