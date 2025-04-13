package az.edu.turing.dto;

public class BookingResponseDTO {
    private String bookingId;
    private String message;

    public BookingResponseDTO(String bookingId, String message) {
        this.bookingId = bookingId;
        this.message = message;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getMessage() {
        return message;
    }
    @Override
    public String toString() {
        return "Booking Successful!" +
                "\nBooking ID: " + bookingId +
                "\nMessage: " + message;
    }

}
