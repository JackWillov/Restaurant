<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<center>
    <form action="login" method="post">
        <table>
            <tr>
                <th>Login:</th>
                <th><input type="text" name="login"/></th>
            </tr>
            <tr>
                <th>Password:</th>
                <th><input type="password" name="password"/></th>
            </tr>
            <tr>
                <th></th>
                <th><input type="submit" value="logIn"/></th>
            </tr>
        </table>

        <th>New User?</th>
        <button name="action" value="registration">Registration</button>
    </form>

</center>
</body>
</html>
