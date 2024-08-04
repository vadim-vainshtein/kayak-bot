package kz.kayaker.botcore.model.authentication;

public record AuthRequest(
        String username,
        String password
) {
}
