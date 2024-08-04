package kz.kayaker.botcore.controller;

import kz.kayaker.botcore.model.authentication.AuthRequest;
import kz.kayaker.botcore.model.authentication.AuthResponse;
import kz.kayaker.botcore.service.authentication.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/login", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponse> login(
            @RequestBody AuthRequest authRequest) {

        var jwt = authService.authenticate(authRequest.username(), authRequest.password());
        return ResponseEntity.ok(new AuthResponse(authRequest.username(), jwt));
    }
}
