package poli.booking.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import poli.booking.models.User;

@FeignClient(name = "user-service", fallback = UserClientFallBackHystrix.class)
public interface UserClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
