package com.airlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.airlines.beans.User;

public class UserDAO {
    public String validateUser(int userID, String password) {
        String role = null;
        String sql = "SELECT Role FROM users WHERE UserID = ? AND UserPassword = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            pstmt.setString(2, password);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    role = rs.getString("Role");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    public boolean registerUser(User user) {
        String sql = "INSERT INTO users (UserPassword, UserName, Role, CustomerCategory, Phone, EmailId, Address, City, State, Country, ZipCode, DOB) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user.getUserPassword());
            pstmt.setString(2, user.getUserName());
            pstmt.setString(3, user.getRole());
            pstmt.setString(4, user.getCustomerCategory());
            pstmt.setLong(5, user.getPhone());
            pstmt.setString(6, user.getEmailId());
            pstmt.setString(7, user.getAddress());
            pstmt.setString(8, user.getCity());
            pstmt.setString(9, user.getState());
            pstmt.setString(10, user.getCountry());
            pstmt.setLong(11, user.getZipCode());
            pstmt.setString(12, user.getDob());

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateProfile(User user) {
        String sql = "UPDATE users SET UserName = ?, EmailId = ?, Phone = ? WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getEmailId());
            pstmt.setLong(3, user.getPhone());
            pstmt.setInt(4, user.getUserID());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getUserName(int userID, String password) {
        String userName = null;
        String sql = "SELECT UserName FROM users WHERE UserID = ? AND UserPassword = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                userName = rs.getString("UserName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userName;
    }

}
