<!DOCTYPE html>
<html>
<head>
    <title>Countries</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>List of cities of state</h2>
<#assign count = cities?size>
<h3>${state}</h3>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
    </tr>

    <#list cities as city>
    <tr>
        <td>${city.id}</td>
        <td>${city.name}</td>
    </tr>
</#list>
</table>

</body>
</html>