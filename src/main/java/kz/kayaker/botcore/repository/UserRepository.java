package kz.kayaker.botcore.repository;

import kz.kayaker.botcore.entity.security.Role;
import kz.kayaker.botcore.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByRole(Role role);
}
