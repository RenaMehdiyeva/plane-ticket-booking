package az.edu.turing.entity;

import java.time.LocalDateTime;

public class Flight {
    private String id;
    private String from;
    private String to;
    private String dateTime;
    private int availableSeats;

    public Flight(String id, String from, String to, String dateTime, int availableSeats) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.dateTime = dateTime;
        this.availableSeats = availableSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", availableSeats=" + availableSeats +
                '}';
    }
}