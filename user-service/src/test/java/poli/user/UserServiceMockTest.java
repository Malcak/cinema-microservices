package poli.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import poli.user.entities.User;
import poli.user.repositories.UserRepository;
import poli.user.services.UserService;
import poli.user.services.Service;

import java.util.Optional;

@SpringBootTest
public class UserServiceMockTest {
    @Mock
    private UserRepository userRepository;
    private Service service;

    @BeforeEach
    public void begin(){
        MockitoAnnotations.initMocks(this);
        service = new UserService(userRepository);

        User user = new User(6L,"Test","of the Test");
        Mockito.when(userRepository.findById(6L)).thenReturn(Optional.of(user));
    }
    @Test
    public void when_getById_return_user(){
        User user = (User) service.findById(6L);
        Assertions.assertThat(user.getName()).isEqualTo("Test");
    }
}
