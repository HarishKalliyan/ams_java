package com.airlines.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlines.dao.FlightDAO;

/**
 * Servlet implementation class DeleteFlightServlet
 */
@WebServlet("/DeleteFlightServlet")
public class DeleteFlightServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int flightID = Integer.parseInt(request.getParameter("flightID"));
        boolean success = FlightDAO.deleteFlight(flightID);

        if (success) {
            request.setAttribute("message", "Flight Deleted Successfully!");
            request.setAttribute("messageType", "success");
        } else {
            request.setAttribute("message", "Failed to Delete Flight!");
            request.setAttribute("messageType", "error");
        }
        request.getRequestDispatcher("admin_flights.jsp").forward(request, response);
    }
}
