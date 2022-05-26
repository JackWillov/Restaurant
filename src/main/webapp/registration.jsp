<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
</head>
<body>

<center>
    <form action="registration" method="post">
        <table style="
    with: 50%">
            <tr>
                <th>Login</th>
                <th><input type="text" name="login"/></th>
            </tr>
            <tr>
                <th>Password</th>
                <th><input type="password" name="password"/></th>
            </tr>
            <tr>
                <th>Confirm password</th>
                <th><input type="password" name="conf_password"/></th>
            </tr>
        </table>
        <input type="submit" value="Create account "/></form>
</center>
</body>
</html>