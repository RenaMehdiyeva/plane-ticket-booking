package az.edu.turing.dto;

import java.time.LocalDate;

public class FlightSearchDTO {
    private String destination;
    private LocalDate date;
    private int numberOfTickets;

    public FlightSearchDTO(String destination, LocalDate date, int numberOfTickets) {
        this.destination = destination;
        this.date = date;
        this.numberOfTickets = numberOfTickets;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public String toString() {
        return "Searching flights to " + destination +
                " on " + date +
                " for " + numberOfTickets + " person(s)";
    }
}
