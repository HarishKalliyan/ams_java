<%@ include file="header.jsp" %>
<%@ page import="com.airlines.beans.User" %>
<%@ page session="true" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="profile.css">
</head>
<body>
    <div class="profile-container">
        <h2>Admin Profile</h2>
        
        <% User user = (User) session.getAttribute("user"); %>

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
        
        <% String message = request.getParameter("message"); 
           if (message != null) { %>
           <p style="color: green;"><%= message %></p>
        <% } %>
    </div>

</body>
<%@ include file="footer.jsp" %>
</html>
