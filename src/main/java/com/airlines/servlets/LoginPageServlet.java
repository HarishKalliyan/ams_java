package com.airlines.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.airlines.dao.UserDAO;

@WebServlet("/LoginPageServlet")
public class LoginPageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userID = Integer.parseInt(request.getParameter("userID"));
        String password = request.getParameter("password");

        UserDAO userDAO = new UserDAO();
        String userName = userDAO.getUserName(userID, password);
        String role = userDAO.validateUser(userID, password);

        if (role != null) {
            HttpSession session = request.getSession();
            session.setAttribute("userID", userID);
            session.setAttribute("userName", userName);
            session.setAttribute("role", role);

            if (role.equals("Admin")) {
                response.sendRedirect("admin_home.jsp");
            } else {
                response.sendRedirect("user_home.jsp");
            }
        } else {
            response.sendRedirect("register.jsp");
        }
    }
}
