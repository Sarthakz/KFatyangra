
<html>
<head>

    <link rel="stylesheet" type="text/css" href="${resource(dir: 'css', file: 'login.css')}">
    %{--<link rel="stylesheet" type="text/css" href="${resource(dir: 'media/css', file: 'jquery.dataTables.css')}">--}%

    %{--javascript files--}%
    %{--<script type="text/javascript" src="${resource(dir: 'js',file: 'jquery-1.12.0.min.js')}"></script>--}%
    %{--<script src="${resource(dir: 'js',file: 'bootstrap.min.js')}" type="text/javascript"></script>--}%
    %{--<script--}%
</head>
<body>

<div class="login-page">
    <div class="form">
        <g:form class="login-form" controller="login" action="login">
            <input type="text" name="username" placeholder="username"/>
            <input type="password" name="password" placeholder="password"/>
            <button>login</button>

        </g:form>
        <g:link controller="member" action="create"><button>Create</button></g:link>
    </div>
</div>
</body>
</html>
