package kz.vainshtein.kayakbotcore.model.authentication;

public record AuthRequest(
        String username,
        String password
) {
}
