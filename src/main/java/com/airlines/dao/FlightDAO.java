package com.airlines.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.airlines.beans.Flight;

public class FlightDAO {

    // Get all flights
    public static List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Flights";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                flights.add(new Flight(
                    rs.getInt("FlightID"),
                    rs.getInt("CarrierID"),
                    rs.getString("Origin"),
                    rs.getString("Destination"),
                    rs.getInt("AirFare"),
                    rs.getInt("EconomySeats"),
                    rs.getInt("BusinessSeats"),
                    rs.getInt("ExecutiveSeats")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flights;
    }

    // Insert a new flight
    public static boolean addFlight(Flight flight) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Flights (CarrierID, Origin, Destination, AirFare, EconomySeats, BusinessSeats, ExecutiveSeats) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, flight.getCarrierID());
            ps.setString(2, flight.getOrigin());
            ps.setString(3, flight.getDestination());
            ps.setInt(4, flight.getAirFare());
            ps.setInt(5, flight.getEconomySeats());
            ps.setInt(6, flight.getBusinessSeats());
            ps.setInt(7, flight.getExecutiveSeats());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update flight
    public static boolean updateFlight(Flight flight) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "UPDATE Flights SET CarrierID=?, Origin=?, Destination=?, AirFare=?, EconomySeats=?, BusinessSeats=?, ExecutiveSeats=? WHERE FlightID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, flight.getCarrierID());
            ps.setString(2, flight.getOrigin());
            ps.setString(3, flight.getDestination());
            ps.setInt(4, flight.getAirFare());
            ps.setInt(5, flight.getEconomySeats());
            ps.setInt(6, flight.getBusinessSeats());
            ps.setInt(7, flight.getExecutiveSeats());
            ps.setInt(8, flight.getFlightID());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete flight
    public static boolean deleteFlight(int flightID) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Flights WHERE FlightID=?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, flightID);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
