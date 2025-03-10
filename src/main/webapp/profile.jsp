<%@ page import="com.airlines.beans.User" %>
<%@ include file="header.jsp" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <div class="profile-container">
        <h2> Profile</h2>

        <form action="EditProfileServlet" method="post">
            <div class="input-group">
                <label for="userID">User ID:</label>
                <input type="text" id="userID" name="userID" value="<%= user.getUserID() %>" readonly>
            </div>

            <div class="input-group">
                <label for="userName">User Name:</label>
                <input type="text" id="userName" name="userName" value="<%= user.getUserName() %>" required>
            </div>

            <div class="input-group">
                <label for="emailId">Email:</label>
                <input type="email" id="emailId" name="emailId" value="<%= user.getEmailId() %>" required>
            </div>

            <div class="input-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" value="<%= user.getPhone() %>" required>
            </div>

            <button type="submit">Save Changes</button>
        </form>
    </div>
</body>
</html>
