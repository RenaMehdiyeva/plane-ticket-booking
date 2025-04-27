package az.edu.turing.daoimpl;

import az.edu.turing.dao.BookingDAO;
import az.edu.turing.entity.Booking;
import az.edu.turing.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingDAOImpl implements BookingDAO {
    private static final String BOOKINGS_FILE = "bookings.dat";
    private List<Booking> bookings;

    public BookingDAOImpl() {
        this.bookings = FileUtil.readFromFile(BOOKINGS_FILE);
        if (this.bookings == null) {
            this.bookings = new ArrayList<>();
        }
    }

    @Override
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    @Override
    public Booking getBookingById(String bookingId) {
        return bookings.stream()
                .filter(b -> b.getBookingId().equals(bookingId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean saveBooking(Booking booking) {
        bookings.add(booking);
        FileUtil.writeToFile(BOOKINGS_FILE, bookings);
        return true;
    }

    @Override
    public boolean deleteBooking(String bookingId) {
        Optional<Booking> bookingToRemove = bookings.stream()
                .filter(b -> b.getBookingId().equals(bookingId))
                .findFirst();

        if (bookingToRemove.isPresent()) {
            bookings.remove(bookingToRemove.get());
            FileUtil.writeToFile(BOOKINGS_FILE, bookings);
            return true;
        }
        return false;
    }
}