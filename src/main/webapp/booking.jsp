<%@ page import="java.util.List, com.airlines.beans.Flight, com.airlines.dao.FlightDAO" %>
<%@ include file="user_header.jsp" %>
<%@ include file="menu.jsp" %>
<html>
<head>
    <title>Book a Ticket</title>
    <style>
        .container {
            text-align: center;
            margin-top: 50px;
        }

        select, input {
            padding: 10px;
            margin: 10px;
            width: 200px;
        }

        button {
            background: dodgerblue;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            font-size: 18px;
            cursor: pointer;
        }

        button:hover {
            background: darkblue;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Book Your Flight</h2>
        <form action="BookingServlet" method="post">
            <label for="flightID">Select Flight:</label>
            <select name="flightID" required>
                <option value="">-- Select Flight --</option>
                <%
                    List<Flight> flights = FlightDAO.getAllFlights();
                    for (Flight flight : flights) {
                %>
                <option value="<%= flight.getFlightID() %>">
                    <%= flight.getOrigin() %> to <%= flight.getDestination() %> - $<%= flight.getAirFare() %>
                </option>
                <% } %>
            </select>
            <br>

            <label for="noOfSeats">Number of Seats:</label>
            <input type="number" name="noOfSeats" min="1" required>
            <br>

            <label for="seatCategory">Seat Category:</label>
            <select name="seatCategory" required>
                <option value="Economy">Economy</option>
                <option value="Executive">Executive</option>
                <option value="Business">Business</option>
            </select>
            <br>

            <label for="dateOfTravel">Date of Travel:</label>
            <input type="date" name="dateOfTravel" required>
            <br>

            <button type="submit">Book Ticket</button>
        </form>
    </div>
</body>
<%@ include file="user_footer.jsp" %>
</html>
