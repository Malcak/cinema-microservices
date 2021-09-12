package poli.booking.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import poli.booking.models.User;

@FeignClient(name = "user-service")
@RequestMapping("/users")
public interface UserClient {
    @GetMapping("/{id}")
    User findById(@PathVariable("id") Long id);
}
