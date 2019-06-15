<!-- chart.jsp-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script type="text/javascript">
        window.onload = function () {

            var dps = [[]];
            var chart = new CanvasJS.Chart("chartContainer", {
                backgroundColor: "#ffe4c4",
                exportEnabled: true,
                animationEnabled: true,
                theme: "light2", // "light1", "dark1", "dark2"
                title: {
                    text: "All Expenses"
                },
                subtitles: [{
                    text: "Divided in categories, costs in PLN"
                }],
                data: [{
                    type: "pie",
                    yValueFormatString: "#,##0\"PLN\"",
                    indexLabel: "{label} - {y}",
                    dataPoints: dps[0]
                }]
            });

            var yValue;
            var label;

            <c:forEach items="${statistics}" var="dataPoints" varStatus="loop">
            <c:forEach items="${dataPoints}" var="dataPoint">
            yValue = parseFloat("${dataPoint.y}");
            label = "${dataPoint.label}";
            dps[parseInt("${loop.index}")].push({
                label: label,
                y: yValue,
            });
            </c:forEach>
            </c:forEach>

            chart.render();

        }
    </script>
</head>
<link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet">
<body style="background: bisque">
<div id="chartContainer" style="height: 370px; width: 100%"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

<button onclick="window.location.href='/finance_manager_war_exploded/'" style="alignment: center">
    Home
</button>

</body>
</html>