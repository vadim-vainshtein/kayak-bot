package kz.vainshtein.kayakbotcore.service.authentication;

import kz.vainshtein.kayakbotcore.model.authentication.AuthRequest;
import kz.vainshtein.kayakbotcore.repository.UserRepository;
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

    public String authenticate(final String username, final String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        var user = userRepository.findByUsername(username)
                                 .orElseThrow(() -> new UsernameNotFoundException(username));
        return jwtService.generateToken(user);
    }
}
