package poli.booking.clients;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import poli.booking.models.User;

@Component
@NoArgsConstructor
public class UserClientFallBackHystrix implements UserClient {
    @Override
    public User findById(Long id) {
        return null;
    }
}
