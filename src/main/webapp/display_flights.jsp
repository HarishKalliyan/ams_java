<%@ page import="java.util.List, com.airlines.beans.Flight" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Flight Details</title>
    <link rel="stylesheet" type="text/css" href="home.css">
    <style>
        /* Table Styling */
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background: white;
            color: black;
            box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.2);
            border-radius: 8px;
            overflow: hidden;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: teal;
            color: white;
            font-weight: bold;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        /* No Data Message */
        .no-data {
            text-align: center;
            font-size: 18px;
            font-weight: bold;
            color: red;
        }
    </style>
</head>
<body>
    <h2>Flight Details</h2>

    <%
        Object obj = request.getAttribute("flightList");
        List<Flight> flights = null;
        if (obj instanceof List<?>) {
            flights = (List<Flight>) obj;
        }

        if (flights != null && !flights.isEmpty()) {
    %>

    <table>
        <tr>
            <th>Flight ID</th>
            <th>Carrier ID</th>
            <th>Origin</th>
            <th>Destination</th>
            <th>Air Fare ($)</th>
            <th>Economy Seats</th>
            <th>Business Seats</th>
            <th>Executive Seats</th>
        </tr>
        <%
            for (Flight flight : flights) {
        %>
        <tr>
            <td><%= flight.getFlightID() %></td>
            <td><%= flight.getCarrierID() %></td>
            <td><%= flight.getOrigin() %></td>
            <td><%= flight.getDestination() %></td>
            <td><%= flight.getAirFare() %></td>
            <td><%= flight.getEconomySeats() %></td>
            <td><%= flight.getBusinessSeats() %></td>
            <td><%= flight.getExecutiveSeats() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <% } else { %>
        <p class="no-data">No flight details available.</p>
    <% } %>

</body>
<%@ include file="footer.jsp" %>
</html>
