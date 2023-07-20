<!DOCTYPE html>
<html>
<head>
    <title>Countries</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>List of states of country</h2>
<#assign count = states?size>
<h3>${country}</h3>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>

    <#list states as state>
    <tr>
        <td>${state.id}</td>
        <td>${state.name}</td>
    </tr>
</#list>
</table>

</body>
</html>