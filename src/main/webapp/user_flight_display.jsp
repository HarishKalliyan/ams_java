<%@ page import="java.util.List, com.airlines.beans.Flight" %>
<%@ include file="user_header.jsp" %>
<%@ include file="menu.jsp" %>
<html>
<head>
    <title>Flight Details</title>
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

    <table border="1">
        <tr>
            <th>Flight ID</th>
            <th>Carrier ID</th>
            <th>Origin</th>
            <th>Destination</th>
            <th>Air Fare</th>
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
        <p style="color: red; text-align: center;">No flight details available.</p>
    <% } %>

</body>
<%@ include file="user_footer.jsp" %>
</html>
