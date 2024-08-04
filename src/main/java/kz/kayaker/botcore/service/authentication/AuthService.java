package kz.kayaker.botcore.service.authentication;

import kz.kayaker.botcore.entity.security.UserToken;
import kz.kayaker.botcore.repository.UserRepository;
import kz.kayaker.botcore.repository.UserTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;
    private final UserRepository userRepository;
    private final UserTokenRepository userTokenRepository;

    public String authenticate(final String username, final String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        var user = userRepository.findByUsername(username)
                                 .orElseThrow(() -> new UsernameNotFoundException(username));
        var token = jwtService.generateToken(user);
        userTokenRepository.save(new UserToken(user, token));
        return token;
    }
}
