package az.edu.turing;

import az.edu.turing.console.ConsoleApp;
import az.edu.turing.controller.BookingController;
import az.edu.turing.controller.FlightController;
import az.edu.turing.dao.BookingDAO;
import az.edu.turing.dao.FlightDAO;
import az.edu.turing.daoimpl.BookingDAOImpl;
import az.edu.turing.daoimpl.FlightDAOImpl;
import az.edu.turing.service.BookingService;
import az.edu.turing.service.FlightService;
import az.edu.turing.serviceimpl.BookingServiceImpl;
import az.edu.turing.serviceimpl.FlightServiceImpl;


public class Main {
    public static void main(String[] args) {
        FlightDAO flightDao = new FlightDAOImpl();
        BookingDAO bookingDao = new BookingDAOImpl();

        FlightService flightService = new FlightServiceImpl(flightDao);
        BookingService bookingService = new BookingServiceImpl(bookingDao, flightService);

        FlightController flightController = new FlightController(flightService);
        BookingController bookingController = new BookingController(bookingService);

        ConsoleApp app = new ConsoleApp(flightController, bookingController);
        app.run();
    }
}