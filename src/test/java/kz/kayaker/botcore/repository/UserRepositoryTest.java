package kz.kayaker.botcore.repository;

import kz.kayaker.botcore.TestData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void saveAndLoad() {
        var user = TestData.user()
                           .build();
        userRepository.save(user);
        var loaded = userRepository.findByUsername(user.getUsername());

        assertThat(loaded).isNotEmpty();
        assertThat(loaded.get()
                         .getId()).isNotZero();
    }
}