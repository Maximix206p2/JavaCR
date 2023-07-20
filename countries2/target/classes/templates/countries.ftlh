<!DOCTYPE html>
<html>
<head>
    <title>Countries</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>List of countries</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Iso3</th>
    </tr>

    <#list countries as country>
    <tr>
        <td>${country.id}</td>
        <td>${country.name}</td>
        <td>${country.iso3}</td>
    </tr>
</#list>
</table>

</body>
</html>