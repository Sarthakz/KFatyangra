<%--
  Created by IntelliJ IDEA.
  User: anijor
  Date: 9/1/2016
  Time: 11:45 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

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
        .scroll{
            max-height:200px; /*example*/
            overflow: auto;
        }
        .table{
            border-collapse: collapse;
            border: 1px solid black;
        }

    </style>


</head>
<body>
<div class="jumbotron head">
    <h1 class="text-center" >KiraFatyangra</h1>

</div>

<div class="container">
    <div class="col-md-1"></div>
    <div class="col-md-4">

    %{--<g:select name="Dropdown" from="${['Text1', 'Test2', 'Test3']}"></g:select>--}%
    <div class="dropdown">
        <button class="btn btn-success dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li><a href="#">HTML</a></li>
            <li><a href="#">CSS</a></li>
            <li><a href="#">JavaScript</a></li>
        </ul>
    </div>

        </div>
    <div class="col-md-2">
        <button>TEST </button>
    </div>
    <div class="col-md-4 scroll" >
        <table border="2px" width="300px" class= "table table-hover">

            <g:each in="${['Cat', 'Dog','asd','asdf','asdf','asd','asd','asd','wr']}">
                <tr  class="success">
                <td>Animal: ${it} </td>
                <tr>
            </g:each>

        </table>
    </div>

    <div class="col-md-1"></div></div>



</body>
</html>