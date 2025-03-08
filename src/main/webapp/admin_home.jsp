<%@ include file="header.jsp" %>
<html>
<head>
    <title>Admin Home</title>
    <link rel="stylesheet" type="text/css" href="home.css">
</head>
<body>
    <h2>Welcome, Admin</h2>
    <div id="search-section">
        <form action="FlightServlet" method="get">
            <button type="submit">Get Flight Details</button>
        </form>
    </div>
</body>
<%@ include file="footer.jsp" %>
</html>
