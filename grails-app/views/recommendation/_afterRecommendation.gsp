<table>
    <g:each in="${list}" var="insecticide">
        <tr>
            ><g:link controller="insecticide" action="show" id="${insecticide.id}"><button>${insecticide?.name}</button></g:link>
        </tr>
    </g:each>
</table>