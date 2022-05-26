<%@ page import="com.epam.restaurant.dao.entity.Dish" %>
<%@ page import="java.util.List" %>
<%@ page import="com.epam.restaurant.dao.entity.CountedDish" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Make your bill</title>
</head>
<body>
<form action="bill" method="post">
    <div class="container">

        <h2>Here you can see your meal </h2>
        <p><a href="logout"> logout</a></p>

        <table>
            <tr>
                <td>No</td>
                <td>Name</td>
                <td>Description</td>
                <td>Price</td>
                <td>Count</td>
            </tr>
            <%
                List<CountedDish> list = (List<CountedDish>) session.getAttribute("orderList");
                double totalPrice = 0;
                for (int i = 0; i < list.size(); i++) {
                    int j = i + 1;
                    totalPrice += list.get(i).getDish().getPrice() * list.get(i).getCount();
            %>
            <tr>
                <td><%=j%>
                </td>
                <td><%=list.get(i).getDish().getName()%>
                </td>
                <td><%=list.get(i).getDish().getDescription()%>
                </td>
                <td><%=list.get(i).getDish().getPrice()%>
                </td>
                <td><%=list.get(i).getCount()%>
                </td>
                <td>
                    <button name="action" value="delete<%=i%>">delete</button>
                </td>
            </tr>

            <% } %>
        </table>
        <b>Total price : </b><strong><%=totalPrice%>
    </strong>
        <%request.getSession().setAttribute("totalPrice", totalPrice);%>
        <p><a href="order.jsp">One or few more dish?</a></p>
        <button name="action" value="status">Create an order</button>

    </div>


</body>
</html>