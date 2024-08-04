package kz.kayaker.botcore.repository;

import kz.kayaker.botcore.entity.security.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTokenRepository extends JpaRepository<UserToken, Long> {

    Optional<UserToken> findUserTokenByToken(String token);
}
