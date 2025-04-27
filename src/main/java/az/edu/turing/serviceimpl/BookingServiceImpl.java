package az.edu.turing.serviceimpl;

import az.edu.turing.dao.BookingDAO;
import az.edu.turing.entity.Booking;
import az.edu.turing.entity.Passenger;
import az.edu.turing.service.BookingService;
import az.edu.turing.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    private final BookingDAO bookingDao;
    private final FlightService flightService;

    public BookingServiceImpl(BookingDAO bookingDao, FlightService flightService) {
        this.bookingDao = bookingDao;
        this.flightService = flightService;
    }

    @Override
    public Booking createBooking(String flightId, String passengerName, List<Passenger> passengers) {
        if (!flightService.decreaseAvailableSeats(flightId, passengers.size())) {
            return null;
        }

        Booking booking = new Booking(
                generateBookingId(),
                passengerName,
                flightId,
                passengers
        );

        if (bookingDao.saveBooking(booking)) {
            return booking;
        } else {
            flightService.decreaseAvailableSeats(flightId, -passengers.size());
            return null;
        }
    }

    @Override
    public boolean cancelBooking(String bookingId) {
        Booking booking = bookingDao.getBookingById(bookingId);
        if (booking == null) {
            return false;
        }

        if (bookingDao.deleteBooking(bookingId)) {
            return flightService.decreaseAvailableSeats(
                    booking.getFlightId(),
                    -booking.getPassengers().size()
            );
        }
        return false;
    }

    @Override
    public List<Booking> getBookingsByPassengerName(String passengerName) {
        return bookingDao.getAllBookings().stream()
                .filter(b -> b.getPassengerName().equalsIgnoreCase(passengerName))
                .collect(Collectors.toList());
    }

    private String generateBookingId() {
        return "BKG-" + System.currentTimeMillis();
    }
}