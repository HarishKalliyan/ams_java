<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="register.css">
    <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setHeader("Expires", "0");
%>
    
    <link rel="stylesheet" type="text/css" href="login.css">
    <script>
    window.onload = function () {
        document.forms[0].reset(); // Clears the form fields
    };
	</script>
</head>
<body>
    <div class="register-container">
        <h2>Customer Registration</h2>
        <% 
            String errorMessage = request.getParameter("error");
            if (errorMessage != null) { 
        %>
            <p id="error-message" style="color: red;"><%= errorMessage %></p>
        <% } %>

        <form action="RegisterServlet" method="post">
            <label for="userName">User Name:</label>
            <input type="text" id="userName" name="userName" required>
            <br>

            <label for="phone">Phone:</label>
            <input type="number" id="phone" name="phone" required>
            <br>

            <label for="emailId">Email:</label>
            <input type="email" id="emailId" name="emailId" required>
            <br>

            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            <br>
            <label for="city">City:</label>
            <br>
            <input type="text" id="city" name="city" required>
            <br>

            <label for="state">State:</label>
            <input type="text" id="state" name="state" required>
            <br>

            <label for="country">Country:</label>
            <input type="text" id="country" name="country" required>
            <br>

            <label for="zipCode">Zip Code:</label>
            <input type="number" id="zipCode" name="zipCode" required>
            <br>

            <label for="dob">Date of Birth:</label>
            <input type="date" id="dob" name="dob" required>
            <br>

            <button type="submit" class="register-btn">Register</button>
            <button type="reset" class="reset-btn">Reset</button>
        </form>

        <p>Already have an account? <a href="login.jsp">Login Here</a></p>
    </div>
</body>
</html>
