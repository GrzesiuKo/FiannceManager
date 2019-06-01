<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">

<head>
    <title>Finance Manager</title>
</head>

<body style="background: bisque">
<h1 align="center" style="font-size:70px;">Welcome to the Finance Manager</h1>
<table align="center">
    <tr>
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/addExpense'">ADD Expense
            </button>
        </td>
    </tr>
    <tr>
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/delete'">DELETE Expense
            </button>
        </td>
    </tr>
    <tr>
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/expenses'">SHOW History
            </button>
        </td>
    </tr>
    <tr>
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/statistics'">SHOW Statistics
            </button>
        </td>
    </tr>
    <tr>
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/addCategory'">ADD Category
            </button>
        </td>
    </tr>
    <tr>
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/deleteCategory'">DELETE Category
            </button>
        </td>
    </tr>
    <tr>
        <td>
            <button onclick="window.location.href='/finance_manager_war_exploded/categories'">SHOW Categories
            </button>
        </td>
    </tr>
</table>
</body>
</html>