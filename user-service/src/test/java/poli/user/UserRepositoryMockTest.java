package poli.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import poli.user.entities.User;
import poli.user.repositories.UserRepository;

import java.util.List;

@DataJpaTest
public class UserRepositoryMockTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void when_findAll_return_ListUsers(){
        User user = new User(1L,"Jason","Momoa");
        userRepository.save(user);

        List<User> users = userRepository.findAll();
        Assertions.assertThat(users.size()).isEqualTo(1);
    }
}