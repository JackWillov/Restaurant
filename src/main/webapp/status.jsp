<%@ page import="com.epam.restaurant.dao.BillDao" %>
<%@ page import="com.epam.restaurant.dao.entity.Bill" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Status</title>
</head>
<body>

<%
    BillDao dao = new BillDao();

    Bill bill = dao.getBillByUserId((Long) request.getSession().getAttribute("userId"));
%>
<p><a href="status.jsp">Update Page</a></p>
<p><a href="logout"> logout</a></p>
<h2>Status of your order : <%=bill.getStatus().getName()%>
</h2>
</body>
</html>
