<%@ page import="java.util.List, com.airlines.beans.Booking"%>
<%@ include file="user_header.jsp"%>
<%@ include file="user_menu.jsp"%>
<html>
<head>
<title>My Bookings</title>
<style>
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

.no-data {
	text-align: center;
	font-size: 18px;
	font-weight: bold;
	color: red;
}

#backButton {
	position: fixed;
	bottom: 60px;
	right: 20px;
	background-color: crimson;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

#backButton:hover {
	background-color: darkred;
}
</style>
</head>
<body>
	<h2>My Booked Tickets</h2>

	<%
        Object obj = request.getAttribute("bookingList");
        List<Booking> bookings = null;
        if (obj instanceof List<?>) {
            bookings = (List<Booking>) obj;
        }

        if (bookings != null && !bookings.isEmpty()) {
    %>

	<table>
		<tr>
			<th>Booking ID</th>
			<th>Flight ID</th>
			<th>No. of Seats</th>
			<th>Seat Category</th>
			<th>Date of Travel</th>
			<th>Booking Status</th>
			<th>Amount ($)</th>
		</tr>
		<%
            for (Booking booking : bookings) {
        %>
		<tr>
			<td><%= booking.getBookingID() %></td>
			<td><%= booking.getFlightID() %></td>
			<td><%= booking.getNoOfSeats() %></td>
			<td><%= booking.getSeatCategory() %></td>
			<td><%= booking.getDateOfTravel() %></td>
			<td><%= booking.getBookingStatus() %></td>
			<td>$<%= booking.getBookingAmount() %></td>
		</tr>
		<%
            }
        %>
	</table>

	<% } else { %>
	<p class="no-data">No bookings found.</p>
	<% } %>
	<button id="backButton" onclick="history.back()" 	>Back</button>
	
</body>
<%@ include file="user_footer.jsp"%>
</html>
