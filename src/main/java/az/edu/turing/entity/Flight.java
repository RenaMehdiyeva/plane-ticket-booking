package az.edu.turing.entity;

public class Flight {
    private String flightId;
    private String destination;
    private String date;
    private String time;
    private int availableSeats;

    public Flight(String flightId, String destination, String date, String time, int availableSeats) {
        this.flightId = flightId;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getId() {
        return flightId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture() {
        return date + " " + time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String toString() {
        return String.format("Flight %s: %s | Date: %s %s | Vacancy: %d",
                flightId, destination, date, time, availableSeats);
    }
}