<%@ page import="com.epam.restaurant.dao.entity.Dish" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make order</title>
</head>
<body>
<center>
    <form method="post" action="order">
        <select name="sell">
            <%
                List<Dish> list = (List<Dish>) session.getAttribute("dishList");
                for (int i = 0; i < list.size(); i++) {

            %>
            <option value="<%=list.get(i).getId()%>"><%=list.get(i).getName()%>
            </option>
            <% }
            %>

        </select>
        <br>
        <label for="dishCount">Number of tentacles (1-20):</label>
        <input type="number" id="dishCount" name="dishCount"
               min="1" max="20">
        <br>
        <input type="Submit" value="Make order">
    </form>


</center>
</body>
</html>

