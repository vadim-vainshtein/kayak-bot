package kz.kayaker.botcore.config;

import kz.kayaker.botcore.repository.UserRepository;
import kz.kayaker.botcore.entity.security.Role;
import kz.kayaker.botcore.entity.security.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StartupConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.username}")
    private String adminUsername;

    @Value("${admin.password}")
    private String adminPassword;

    @Override
    public void run(String... args) {

        if (!userRepository.existsByRole(Role.ADMIN)) {
            userRepository.save(
                    User.builder()
                        .username(adminUsername)
                        .password(passwordEncoder.encode(adminPassword))
                        .role(Role.ADMIN)
                        .build());
        }
    }
}
