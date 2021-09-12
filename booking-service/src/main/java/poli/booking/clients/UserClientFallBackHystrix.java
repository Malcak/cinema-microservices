package poli.booking.clients;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poli.booking.models.User;

@Component
@RequiredArgsConstructor
public class UserClientFallBackHystrix implements UserClient {
    @Override
    public User findById(Long id) {
        return null;
    }
}
