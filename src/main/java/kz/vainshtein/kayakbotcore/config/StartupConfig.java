package kz.vainshtein.kayakbotcore.config;

import kz.vainshtein.kayakbotcore.entity.security.Role;
import kz.vainshtein.kayakbotcore.entity.security.User;
import kz.vainshtein.kayakbotcore.repository.UserRepository;
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
