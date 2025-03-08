package com.airlines.dao;

import com.airlines.beans.Flight;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    public static List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String sql = "SELECT * FROM Flights";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                flights.add(new Flight(rs.getInt("FlightID"), rs.getInt("CarrierID"), rs.getString("Origin"),
                        rs.getString("Destination"), rs.getInt("AirFare"), rs.getInt("EconomySeats"),
                        rs.getInt("BusinessSeats"), rs.getInt("ExecutiveSeats")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
