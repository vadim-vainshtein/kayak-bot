package kz.vainshtein.kayakbotcore.repository;

import kz.vainshtein.kayakbotcore.entity.security.Role;
import kz.vainshtein.kayakbotcore.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByRole(Role role);
}
