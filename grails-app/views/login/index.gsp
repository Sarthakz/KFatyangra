
<html>
<head>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="${resource(dir: 'js', file: 'jquery.js')}"> </script>
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
            <g:select name="plants" from="${kfatyangra.Plant.list()}" optionKey="id" optionValue="name" noSelection="['':' --Select Plant here-- ']" />
        </div>
    </div>
    <div class="col-md-2">
        <button onclick="calculateSimilarities();">Recommend </button>
    </div>
    <div class="col-md-4"></div>
    <div id="example">
        <input type="text">
    </div>
    <div class="col-md-1"></div>
</div>



</body>
</html>