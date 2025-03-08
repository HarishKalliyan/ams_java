package com.airlines.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlines.beans.User;
import com.airlines.dao.UserDAO;

@WebServlet("/EditProfileServlet")
public class EditProfileServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String userName = request.getParameter("userName");
        String emailId = request.getParameter("emailId");
        long phone = Long.parseLong(request.getParameter("phone"));

        User user = new User();
        user.setUserID(userID);
        user.setUserName(userName);
        user.setEmailId(emailId);
        user.setPhone(phone);

        boolean updated = UserDAO.updateProfile(user);

        HttpSession session = request.getSession();
        if (updated) {
            session.setAttribute("user", user);
            response.sendRedirect("profile.jsp?message=Profile Updated Successfully");
        } else {
            response.sendRedirect("profile.jsp?message=Update Failed");
        }
    }
}
