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
<table>

</table>
<table border="2px" width="300px" class= "table table-hover">

    <g:if test="${list}">
        <g:each in="${list}" var="insecticide">
            <tr class="success">
                <td><g:link controller="insecticide" action="show" id="${insecticide.id}"><button>${insecticide?.name}</button></g:link></td>
            </tr>
        </g:each>
    </g:if>
    <g:else>
        <tr class="success">
            <td><b>No List Sorry!!!</b></td>
        </tr>
    </g:else>

</table>