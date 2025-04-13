package az.edu.turing.dto;

import java.util.List;

public class BookingRequestDTO {
    private String flightId;
    private List<String> passengerFullNames;

    public BookingRequestDTO(String flightId, List<String> passengerFullNames) {
        this.flightId = flightId;
        this.passengerFullNames = passengerFullNames;
    }

    public String getFlightId() {
        return flightId;
    }

    public List<String> getPassengerFullNames() {
        return passengerFullNames;
    }
}

