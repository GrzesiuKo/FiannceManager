<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Finance Manager</title>
</head>
<body>
<table>
    <tr>
        <td><button onclick="window.location.href='/finance_manager_war_exploded/addExpense'">Go to expense adding!!</button></td>
    </tr>
    <tr>
        <td><button onclick="window.location.href='/finance_manager_war_exploded/delete'">Delete Them ALL!!</button></td>
    </tr>
    <tr>
        <td><button onclick="window.location.href='/finance_manager_war_exploded/expenses'">View Them All</button></td>
    </tr>
</table>


</body>
</html>