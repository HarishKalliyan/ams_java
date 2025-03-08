<%@ include file="user_header.jsp" %>
<%@ include file="menu.jsp" %>
<html>
<head>
    <title>User Home</title>
    <style>
        .container {
            text-align: center;
            margin-top: 50px;
        }

        button {
            background: dodgerblue;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
            margin: 10px;
        }

        button:hover {
            background: darkblue;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Welcome to the Airline Management System</h2>
        <p>Please choose an option below:</p>

        <a href="User_FlightServlet"><button>View Flight Details</button></a>
        <a href="booking.jsp"><button>Book a Ticket</button></a>
    </div>
</body>
<%@ include file="user_footer.jsp" %>
</html>
