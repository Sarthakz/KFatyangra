<%--
  Created by IntelliJ IDEA.
  User: Sushant
  Date: 9/2/2016
  Time: 1:06 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'bootstrap.min.css')}">
    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'test.css')}">
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

    %{--javascript files--}%

    <script src="${resource(dir: 'js',file: 'bootstrap.min.js')}" type="text/javascript"></script>
    <script src="${resource(dir: 'js',file: 'jquery.js')}" type="text/javascript"></script>
    <script>
        function calculateSimilarities(){
            var foodId = $('#foods').val();
            var restaurantId = $('#restaurants').val();
            var data = {
                foodId : foodId,
                restaurantId : restaurantId
            }
            $.ajax({
                url : '${createLink(controller: 'recommendation', action: 'recommend')}',
                type : 'POST',
                data : data,
                success: function(resp){
                    $('#example').html(resp);
                }
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
            <g:select name="restaurants" from="${kfatyangra.Restaurant.list()}" optionKey="id" optionValue="name" noSelection="['':' --Select Restaurant here-- ']" />
        </div>
        <div class="dropdown">
            <g:select name="foods" from="${kfatyangra.Food.list()}" optionKey="id2" optionValue="name" noSelection="['':' --Select Plant here-- ']" />
        </div>
    </div>
    <div class="col-md-2">
        <button onclick="calculateSimilarities();">Recommend </button>
    </div>
    <div class="col-md-4 scroll" id="example">
        <input type="text" value="List will be shown here">
    </div>
</div>



</body>
</html>