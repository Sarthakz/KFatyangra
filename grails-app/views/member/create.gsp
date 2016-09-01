<html>
<head>

	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .head{
    background-color:#4CAF50! important;
    color: #f6f1ed! important;
    font-family: "Gill Sans", "Gill Sans MT", Calibri, sans-serif;

}
.container{
width:560px;
}
</style>

	<title>Form</title>
</head>
<body>
<div class="jumbotron head">
    <h1 class="text-center" >KiraFatyangra</h1>

</div>
<div class="container">
<legend>Add New Member</legend>
<form >
  <div class="form-group">
    <label >Full Name</label>
    <input type="text" class="form-control" name="fullname">
  </div>
  <div class="form-group">
    <label >User Name</label>
    <input type="text" class="form-control" name="username">
  </div>
  <div class="form-group">
    <label>Password</label>
    <input type="password" class="form-control" id="password">
  </div>
  <div class="form-group">
    <label >Role</label>
<g:select id="role" name="role.id" from="${kfatyangra.Role.list()}" optionKey="id" required="" value="${memberInstance?.role?.id}" class="many-to-one"/>
  </div>

  <button type="submit" class="btn btn-default">Submit</button>
</form>


			%{--<div class="formManage">--}%
					%{--<g:form controller="member" action="save">--}%
						%{--<div class="row">--}%
							%{--<div class="col-md-3">--}%
								%{--<div class="form-group">--}%
									%{--<label>Full Name</label>--}%
									%{--<g:textField name="name" id="name" class="form-control" required="required"/><br>--}%
								%{--</div>--}%
							%{--</div>--}%
						%{--<div class="col-md-3">--}%
							%{--<div class="form-group">--}%
								%{--<label>User Name</label>--}%
								%{--<g:textField name="name" id="name" class="form-control" required="required"/><br>--}%
							%{--</div>--}%
						%{--</div>--}%
						%{--<div class="col-md-3">--}%
							%{--<div class="form-group">--}%
								%{--<label>Password</label>--}%
								%{--<g:passwordField name="name" id="name" class="form-control" required="required"/><br>--}%
							%{--</div>--}%
						%{--</div>--}%



						%{--<div class="col-md-2">--}%
								%{--<div class="form-group">--}%
									%{--<label>Role</label>--}%
									%{--<g:select class="form-control" name="roleId" id="role" optionKey="id" from="${kfatyangra.Role.list()}"/><br>--}%
								%{--</div>--}%
							%{--</div>--}%
						%{--</div>--}%


						%{--<div class="row">--}%
							%{--<div class="col-md-6">--}%

							%{--</div>--}%

							%{--<div class="col-sm-6" style="padding-top: 20px;">--}%
								%{--<g:submitButton name="submit" class="btn btn-primary pull-right" value="Save"/>--}%
							%{--</div>--}%

						%{--</div>--}%

					%{--</g:form>--}%
				%{--</div>--}%
</div>
</body>
</html>