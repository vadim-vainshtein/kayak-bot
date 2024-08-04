package kz.vainshtein.kayakbotcore.repository;

import kz.vainshtein.kayakbotcore.entity.security.Role;
import kz.vainshtein.kayakbotcore.entity.security.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void saveAndLoad() {
        var user = User.builder()
                       .username("user")
                       .password("password")
                       .role(Role.USER)
                       .build();
        userRepository.save(user);
        var loaded = userRepository.findByUsername("user");
        
        assertThat(loaded).isNotEmpty();
        assertThat(loaded.get()
                         .getId()).isNotZero();
    }
}