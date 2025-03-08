<%@ page session="true" %>
<html>
<head>
    <title>Header</title>
</head>
<body>
    <div style="background: teal; color: white; padding: 10px;">
        <h2>Welcome, <%= (session.getAttribute("userName") != null) ? session.getAttribute("userName") : "Guest" %>!</h2>
        
    </div>
    <hr>
</body>
</html>
