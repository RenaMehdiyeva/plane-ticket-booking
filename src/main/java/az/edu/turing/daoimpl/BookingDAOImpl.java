package az.edu.turing.daoimpl;

import az.edu.turing.dao.BookingDAO;
import az.edu.turing.entity.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAOImpl implements BookingDAO {
    private static final String BOOKING_DATA_FILE = "bookings.dat";

    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BOOKING_DATA_FILE))) {
            bookings = (List<Booking>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public Booking getBookingById(String bookingId) {
        List<Booking> bookings = getAllBookings();
        for (Booking booking : bookings) {
            if (booking.getId().equals(bookingId)) {
                return booking;
            }
        }
        return null;
    }

    @Override
    public void saveBookings(List<Booking> bookings) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(BOOKING_DATA_FILE))) {
            oos.writeObject(bookings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
