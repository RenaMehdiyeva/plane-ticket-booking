package az.edu.turing;

import az.edu.turing.controller.BookingController;
import az.edu.turing.controller.FlightController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FlightController flightController = new FlightController();
    private static final BookingController bookingController = new BookingController();

    public static void main(String[] args) {
        displayWelcomeMessage();

        boolean isRunning = true;
        while (isRunning) {
            displayMainMenu();
            int option = getUserInput("Select an option: ");
            isRunning = handleUserSelection(option);
        }

        scanner.close();
    }

    private static void displayWelcomeMessage() {
        System.out.println("--- Welcome to the Plane Ticket Booking System ---\n");
    }

    private static void displayMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Show Available Flights");
        System.out.println("2. Show Flight Details");
        System.out.println("3. Search and Book Flight");
        System.out.println("4. Cancel Booking");
        System.out.println("5. My Bookings");
        System.out.println("0. Exit");
    }

    private static int getUserInput(String prompt) {
        int input = -1;
        while (input == -1) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        return input;
    }

    private static boolean handleUserSelection(int option) {
        switch (option) {
            case 1:
                flightController.displayAvailableFlights();
                break;
            case 2:
                showFlightDetails();
                break;
            case 3:
                searchAndBookFlight();
                break;
            case 4:
                cancelBooking();
                break;
            case 5:
                viewMyBookings();
                break;
            case 0:
                System.out.println("Exiting the application...");
                return false;
            default:
                System.out.println("Invalid option, please try again.");
        }
        return true;
    }

    private static void showFlightDetails() {
        String flightId = getUserInputString("Enter flight ID: ");
        flightController.showFlightDetails(flightId);
    }

    private static void searchAndBookFlight() {
        String destination = getUserInputString("Enter destination: ");
        String date = getUserInputString("Enter date (YYYY-MM-DD): ");
        int numPassengers = getUserInput("Enter number of passengers: ");

        bookingController.searchAndBookFlight(destination, date, numPassengers);
    }

    private static void cancelBooking() {
        String bookingId = getUserInputString("Enter booking ID to cancel: ");
        bookingController.cancelBooking(bookingId);
    }

    private static void viewMyBookings() {
        String passengerName = getUserInputString("Enter your name: ");
        bookingController.viewMyBookings(passengerName);
    }

    private static String getUserInputString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}