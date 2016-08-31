<%--
  Created by IntelliJ IDEA.
  User: Sushant
  Date: 8/31/2016
  Time: 7:25 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Kira Fatyangra</title>
    <meta name="layout" content="main"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel='stylesheet' href='../css/homepage.css' type='text/css' />
    <script>
        function calculateSimilarities(){
            var plantId = $('#plants').val();
            $.ajax({
                url : '${createLink(controller: )}'
            })
        }
    </script>
</head>

<body>
    <div id="main">
        <label>Plants</label>
        <g:select name="plants" from="${plantList}" optionKey="id" optionValue="name"/>


    </div>
    <div id="mid">
        <input type="button" name="Send" value="Recommend" onclick="calculateSimilarities();">
    </div>
    <div id="recomendation">
        <label>Recommendation</label>
        <div id="afterCalRecomendation">

        </div>
    </div>


</body>
</html>