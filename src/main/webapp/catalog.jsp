<%@ page import="com.epam.restaurant.dao.entity.Dish" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Catalog</title>
</head>
<body>
<form action="catalog" method="post">
    <div class="container">

        <h2>Welcome in our restaurant</h2>
        <p><a href="logout"> logout</a></p>
        <p><a href="status.jsp"> If u have order check status</a></p>

        <table>
            <tr>
                <td>No</td>
                <td>Name</td>
                <td>Description</td>
                <td>Price</td>
            </tr>
            <%
                List<Dish> list = (List<Dish>) session.getAttribute("dishList");
                for (int i = 0; i < list.size(); i++) {
                    int j = i + 1;
            %>
            <tr>
                <td><%=j%>
                </td>
                <td><%=list.get(i).getName()%>
                </td>
                <td><%=list.get(i).getDescription()%>
                </td>
                <td><%=list.get(i).getPrice()%>
                </td>
            </tr>

            <% } %>
        </table>
        <p><a href="order.jsp"> Make order</a></p>
    </div>
    <%--    --%>
</body>
</html>


