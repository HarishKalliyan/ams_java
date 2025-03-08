<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
    <div class="login-container">
        <h2>Login Page</h2>
        <% 
            String errorMessage = request.getParameter("error");
            if (errorMessage != null) { 
        %>
            <p id="error-message" style="color: red;"><%= errorMessage %></p>
        <% } %>

        <form action="LoginPageServlet" method="post">
            <label for="userID">User ID:</label>
            <input type="text" id="userID" name="userID" required>
            <br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <br>

            <button type="submit">Login</button>
        </form>

        <p>Don't have an account? <a href="register.jsp">Register Here</a></p>
    </div>
</body>
</html>
