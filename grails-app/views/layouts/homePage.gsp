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
    <link rel='stylesheet' href='css/test.css' type='text/css' />
    <script>
        function calculateSimilarities(){
            var plantId = $('#plants').val();
            var data = {
                plantId : plantId
            }
            $.ajax({
                url : '${createLink(controller: 'recommendation', action: 'recommend')}',
                type : 'POST',
                data : data,
                success:
            })
        }
    </script>

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
            <label>Plants</label>
            <g:select name="plants" from="${plantList}" optionKey="id" optionValue="name"/>
        </div>
    </div>
    <div class="col-md-2">
        <button>TEST </button>
    </div>
    <div class="col-md-4"></div>
    <input type="text">
    <div class="col-md-1"></div>
</div>



</body>
</html>