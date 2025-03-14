

package com.airlines.servlets;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.airlines.dao.UserDAO;
import com.airlines.beans.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
    	String userName = request.getParameter("userName").trim();
        String password = request.getParameter("password").trim();
        String emailId = request.getParameter("emailId").trim();
        String dob = request.getParameter("dob").trim();
        String role = request.getParameter("role");
        String customerCategory = role.equals("Customer") ? "" : null; // Only customers have categories
        long phone = Long.parseLong(request.getParameter("phone"));
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        long zipCode = Long.parseLong(request.getParameter("zipCode"));
       
     // Validation Patterns
        Pattern usernamePattern = Pattern.compile("^[A-Za-z ]+$"); // Only alphabets & spaces
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"); // Email format
        Pattern passwordPattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])[^\\s]{8,}$"); // At least 1 uppercase, 1 lowercase, 1 special char, no spaces, min 8 chars

        // Validate Username (Only alphabets)
        if (!usernamePattern.matcher(userName).matches()) {
            request.setAttribute("errorMessage", "Username should contain only alphabets.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Validate Password
        if (!passwordPattern.matcher(password).matches()) {
            request.setAttribute("errorMessage", "Password must have at least 8 characters, one uppercase, one lowercase, one special character, and no spaces.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Validate Email Format
        if (!emailPattern.matcher(emailId).matches()) {
            request.setAttribute("errorMessage", "Invalid email format.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // Validate Date of Birth (Must be after 1924-01-01)
        if (dob.compareTo("1924-01-01") <= 0) {
            request.setAttribute("errorMessage", "Date of Birth must be after 1924-01-01.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        
        
        // Create User object
        User user = new User();
        user.setUserName(userName);
        user.setRole(role); // Store the selected role
        user.setUserPassword(password);
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


