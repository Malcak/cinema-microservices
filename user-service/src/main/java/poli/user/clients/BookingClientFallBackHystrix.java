package poli.user.clients;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import poli.user.models.Booking;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class BookingClientFallBackHystrix implements BookingClient{

    @Override
    public List<Booking> findAllByUserId(Long userid) {
        List<Booking> bookings = new ArrayList<Booking>();
        Booking newBooking = new Booking();
        newBooking.setUserId(userid);
        bookings.add(newBooking);
        return bookings;
    }
}
