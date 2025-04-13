package az.edu.turing.console;

import az.edu.turing.controller.BookingController;
import az.edu.turing.controller.FlightController;
import az.edu.turing.controllerimpl.BookingControllerImpl;
import az.edu.turing.controllerimpl.FlightControllerImpl;
import az.edu.turing.exception.InvalidMenuOptionException;

import java.util.Scanner;

public class ConsoleApp {
    private static final Scanner scanner = new Scanner(System.in);

    private static final FlightController flightController = new FlightControllerImpl();
    private static final BookingController bookingController = new BookingControllerImpl();

    public static void main(String[] args) {
        ConsoleApp app = new ConsoleApp();
        app.run();
    }

    private void run() {
        boolean running = true;

        while (running) {
            showMainMenu();
            int choice = getUserMenuChoice();
            running = handleUserChoice(choice);
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Show online board (Flights from Kiev in the next 24 hours)");
        System.out.println("2. Show flight details");
        System.out.println("3. Search and book a flight");
        System.out.println("4. Cancel a booking");
        System.out.println("5. View my bookings");
        System.out.println("6. Exit");
        System.out.print("Please choose an option: ");
    }

    private int getUserMenuChoice() {
        return Integer.parseInt(scanner.nextLine());
    }

    private boolean handleUserChoice(int choice) {
        try {
            switch (choice) {
                case 1: displayFlights(); break;
                case 2: showFlightDetails(); break;
                case 3: searchAndBookFlight(); break;
                case 4: cancelBooking(); break;
                case 5: viewMyFlights(); break;
                case 6: return false;
                default: throw new InvalidMenuOptionException("Invalid menu option! Please choose between 1 and 6.");
            }
        } catch (InvalidMenuOptionException e) {
            handleInvalidMenuOptionException(e);
        }
        return true;
    }

    private void handleInvalidMenuOptionException(InvalidMenuOptionException e) {
        System.out.println("⚠️ " + e.getMessage());
    }

    private void displayFlights() {
        System.out.println("\n=== Flights from Kiev (Next 24 hours) ===");
        flightController.displayAvailableFlights();
    }

    private void showFlightDetails() {
        System.out.print("Enter flight ID: ");
        String flightId = scanner.nextLine();
        flightController.showFlightDetails(flightId);
    }

    private void searchAndBookFlight() {
        String destination = getDestination();
        String date = getDate();
        int numPassengers = getNumberOfPassengers();
        bookingController.searchAndBookFlight(destination, date, numPassengers);
    }

    private String getDestination() {
        System.out.print("Enter destination: ");
        return scanner.nextLine();
    }

    private String getDate() {
        System.out.print("Enter date (yyyy-mm-dd): ");
        return scanner.nextLine();
    }

    private int getNumberOfPassengers() {
        System.out.print("Enter number of passengers: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private void cancelBooking() {
        System.out.print("Enter booking ID to cancel: ");
        String bookingId = scanner.nextLine();
        bookingController.cancelBooking(bookingId);
    }

    private void viewMyFlights() {
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();
        bookingController.viewMyBookings(fullName);
    }
}