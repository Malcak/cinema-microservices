package poli.user.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poli.user.entities.User;
import poli.user.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements poli.user.services.Service<User, Long> {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User delete(Long id) {
        Optional<User> deletedUser = userRepository.findById(id);
        if (deletedUser.isPresent()) {
            userRepository.deleteById(id);
            return deletedUser.get();
        }
        return null;
    }
}
