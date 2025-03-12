package com.airlines.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.airlines.dao.BookingDAO;

@WebServlet("/EditBookingServlet")
public class EditBookingServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookingID = Integer.parseInt(request.getParameter("bookingID"));
        int noOfSeats = Integer.parseInt(request.getParameter("noOfSeats"));
        String seatCategory = request.getParameter("seatCategory");
        String dateOfTravel = request.getParameter("dateOfTravel");

        boolean success = BookingDAO.updateBooking(bookingID, noOfSeats, seatCategory, dateOfTravel);

        if (success) {
            response.sendRedirect("user_home.jsp?message=Booking Updated Successfully");
        } else {
            response.sendRedirect("edit_booking.jsp?bookingID=" + bookingID + "&error=Update Failed");
        }
    }
}
