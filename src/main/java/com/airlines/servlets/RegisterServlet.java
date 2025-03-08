package com.airlines.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airlines.beans.User;
import com.airlines.dao.UserDAO;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = userName.substring(0, 4) + "@123"; // Auto-generated password
        String role = "Customer"; // Default role
        String customerCategory = ""; // Default empty
        
        long phone = Long.parseLong(request.getParameter("phone")); // Use long instead of int
        String emailId = request.getParameter("emailId");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        long zipCode = Long.parseLong(request.getParameter("zipCode")); // Use long for ZipCode
        String dob = request.getParameter("dob");

        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(password);
        user.setRole(role);
        user.setCustomerCategory(customerCategory);
        user.setPhone(phone);
        user.setEmailId(emailId);
        user.setAddress(address);
        user.setCity(city);
        user.setState(state);
        user.setCountry(country);
        user.setZipCode(zipCode);
        user.setDob(dob);

        UserDAO userDAO = new UserDAO();
        boolean success = userDAO.registerUser(user);

        if (success) {
            response.sendRedirect("login.jsp"); // Redirect to login page
        } else {
            response.sendRedirect("register.jsp?error=Registration Failed");
        }
    }
}
