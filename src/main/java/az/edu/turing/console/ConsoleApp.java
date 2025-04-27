package az.edu.turing.console;

import az.edu.turing.controller.BookingController;
import az.edu.turing.controller.FlightController;
import az.edu.turing.entity.Passenger;
import az.edu.turing.exception.InvalidMenuOptionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private final FlightController flightController;
    private final BookingController bookingController;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleApp(FlightController flightController, BookingController bookingController) {
        this.flightController = flightController;
        this.bookingController = bookingController;
    }

    public void run() {
        boolean running = true;
        while (running) {
            showMainMenu();
            int choice = getUserMenuChoice();
            running = handleUserChoice(choice);
        }
    }

    private void showMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Online board (flights from Kiev in the next 24 hours)");
        System.out.println("2. Show flight information");
        System.out.println("3. Search and book flights");
        System.out.println("4. Cancel reservation");
        System.out.println("5. My flights");
        System.out.println("6. Exit");
        System.out.print("Choose: ");
    }

    private int getUserMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private boolean handleUserChoice(int choice) {
        try {
            switch (choice) {
                case 1: flightController.displayAvailableFlights(); break;
                case 2: showFlightDetails(); break;
                case 3: searchAndBookFlight(); break;
                case 4: cancelBooking(); break;
                case 5: viewMyFlights(); break;
                case 6: return false;
                default: throw new InvalidMenuOptionException("Invalid menu selection! Enter a number between 1-6.");
            }
        } catch (InvalidMenuOptionException e) {
            System.out.println("⚠️ " + e.getMessage());
        }
        return true;
    }

    private void showFlightDetails() {
        System.out.print("Enter flight ID: ");
        String flightId = scanner.nextLine();
        flightController.showFlightDetails(flightId);
    }

    private void searchAndBookFlight() {
        System.out.print("Destination city: ");
        String destination = scanner.nextLine();

        System.out.print("Date (yyyy-mm-dd): ");
        String date = scanner.nextLine();

        System.out.print("Number of passengers: ");
        int numPassengers = Integer.parseInt(scanner.nextLine());

        List<Passenger> passengers = new ArrayList<>();
        for (int i = 0; i < numPassengers; i++) {
            System.out.println("Passenger " + (i + 1) + " info:");
            System.out.print("Full name: ");
            String fullName = scanner.nextLine();
            passengers.add(new Passenger(fullName));
        }

        bookingController.bookFlight(destination, date, passengers);
    }


    private void cancelBooking() {
        System.out.print("Enter your booking ID: ");
        String bookingId = scanner.nextLine();
        bookingController.cancelBooking(bookingId);
    }

    private void viewMyFlights() {
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();
        bookingController.viewBookings(fullName);
    }
}