package poli.user.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import poli.user.models.Booking;

import java.util.List;

@FeignClient(name = "booking-service", fallback = BookingClientFallBackHystrix.class)
public interface BookingClient {
    @GetMapping("/bookings/user/{userid}")
    List<Booking> findAllByUserId(@PathVariable("userid") Long userid);
}
