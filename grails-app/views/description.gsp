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
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
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
    <button type="button" class="btn btn-default back">Logout</button>
</div>

<div class="container">

    <form >

            <div class="form-group">
                <label >Name:</label>
                <textarea class="form-control" rows="1" id="comment"></textarea>
            </div>
            <div class="form-group">
                <label >Description:</label>
                <textarea class="form-control" rows="5" id="comment"></textarea>
            </div>
            <div class="form-group">
                <label>Usage:</label>
                <textarea class="form-control" rows="5" id="comment"></textarea>
            </div>


    </form>

</div>
</body>
</html>