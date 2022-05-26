<%@ page import="com.epam.restaurant.dao.entity.Bill" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Manager page</title>
</head>
<body>
<form action="manager" method="post">
    <div class="container">


        <table>
            <tr>
                <td>No</td>
                <td>User id</td>
                <td>Order status</td>
                <td>Total</td>
            </tr>
            <%
                List<Bill> list = (List<Bill>) session.getAttribute("bills");
                if (list == null) {
                }

                for (int i = 0; i < list.size(); i++) {
                    int j = i + 1;
            %>
            <tr>
                <td><%=j%>
                </td>
                <td><%=list.get(i).getUserId()%>
                </td>
                <td><%=list.get(i).getStatus().getName()%>
                </td>
                <td><%=list.get(i).getTotal()%>
                </td>
                <td>
                    <button name="action" value="upgrade<%=i%>">Upgrage status</button>
                <td>
                    <button name="action" value="delete<%=i%>">delete</button>
                </td>
            </tr>

            <% } %>
        </table>
    </div>

    <%-- --%>
</body>
</html>


