package hu.indicium.dev.partners.infrastructure.auth;

public class AuthException extends RuntimeException {
    public AuthException(String name, Exception e) {
        super("Could not create user for " + name + ". Reason: " + e.getMessage());
    }
}
