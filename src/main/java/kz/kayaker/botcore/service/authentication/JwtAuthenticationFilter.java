package kz.kayaker.botcore.service.authentication;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.kayaker.botcore.repository.UserRepository;
import kz.kayaker.botcore.repository.UserTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UserRepository userRepository;
    private final UserTokenRepository userTokenRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        var jwt = authHeader.replace("Bearer ", "");
        var userToken = userTokenRepository.findUserTokenByToken(jwt);
        if (userToken.isEmpty()) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Token doesn't exist");
            return;
        }

        var user = userToken.get()
                            .getUser();
        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext()
                             .setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }
}
