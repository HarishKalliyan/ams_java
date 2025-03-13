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
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String userName = request.getParameter("userName");
        String role = request.getParameter("role"); // Capture role from form
        String customerCategory = role.equals("Customer") ? "" : null; // Only customers have categories
        
        long phone = Long.parseLong(request.getParameter("phone"));
        String emailId = request.getParameter("emailId");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        long zipCode = Long.parseLong(request.getParameter("zipCode"));
        String dob = request.getParameter("dob");

        // Create User object
        User user = new User();
        user.setUserName(userName);
        user.setRole(role); // Store the selected role
        user.setCustomerCategory(customerCategory);
        user.setPhone(phone);
        user.setEmailId(emailId);
        user.setAddress(address);
        user.setCity(city);
        user.setState(state);
        user.setCountry(country);
        user.setZipCode(zipCode);
        user.setDob(dob);

        // Register user and get UserID and Password
        UserDAO userDAO = new UserDAO();
        String result = userDAO.registerUser(user); 

        if (result.startsWith("User Registered Successfully")) {
            request.setAttribute("message", result);
            request.setAttribute("messageType", "success");
        } else {
            request.setAttribute("message", "Registration Failed!");
            request.setAttribute("messageType", "error");
        }
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }    
}
