package com.airlines.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.airlines.beans.Booking;

public class BookingDAO {

    public static int calculateBookingAmount(int flightID, String seatCategory, int noOfSeats) {
        int basePrice = 0;
        String sql = "SELECT AirFare FROM Flights WHERE FlightID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, flightID);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                basePrice = rs.getInt("AirFare");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int multiplier = switch (seatCategory) {
            case "Executive" -> 5;  // 5x Economy Price
            case "Business" -> 2;   // 2x Economy Price
            default -> 1;           // Economy Price
        };

        return basePrice * multiplier * noOfSeats;
    }

    public static boolean insertBooking(int flightID, int userID, int noOfSeats, String seatCategory, String dateOfTravel, int bookingAmount) {
        String sql = "INSERT INTO Booking (FlightID, UserID, NoOfSeats, SeatCategory, DateOfTravel, BookingStatus, BookingAmount) " +
                     "VALUES (?, ?, ?, ?, ?, 'Booked', ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, flightID);
            pstmt.setInt(2, userID);
            pstmt.setInt(3, noOfSeats);
            pstmt.setString(4, seatCategory);
            pstmt.setString(5, dateOfTravel);
            pstmt.setInt(6, bookingAmount);

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Booking> getBookingsByUser(int userID) {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Booking WHERE UserID = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("BookingID"),
                        rs.getInt("FlightID"),
                        rs.getInt("UserID"),
                        rs.getInt("NoOfSeats"),
                        rs.getString("SeatCategory"),
                        rs.getString("DateOfTravel"),
                        rs.getString("BookingStatus"),
                        rs.getInt("BookingAmount")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
