<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.javawebinar.topjava.model.MealWithExceed" %>
<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page import="static java.awt.Color.red" %>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="css/mealstyle.css">
    <title>Meals</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meals list</h2>
<section>
    <table cols="4">
        <c:forEach items="${mealsList}" var="meal">
            <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.MealWithExceed"/>


            <tr style="color: <%if(meal.isExceed()) {%>red<%} else {%>green<%}%>">
                <td>${meal.description1}</td>
                <td><%=TimeUtil.dtToString(meal.getDateTime())%></td>
                <td>${meal.calories}</td>
                <td><%if(meal.isExceed()) {%>да<%} else {%>нет<%}%></td>
            </tr>
        </c:forEach>

    </table>
</section>


</body>
</html>
