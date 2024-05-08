package auction.config;

import java.security.SecureRandom;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CsrfTokenManager {
    public static final String CSRF_TOKEN_SESSION_ATTR_NAME = "csrfToken";

    public static String generateCsrfToken() {
        String csrfToken = UUID.randomUUID().toString();
        return new String(csrfToken);
    }

    public static void setCsrfToken(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute(CSRF_TOKEN_SESSION_ATTR_NAME, generateCsrfToken());
    }

    public static String getCsrfToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            return (String) session.getAttribute(CSRF_TOKEN_SESSION_ATTR_NAME);
        }
        return null;
    }
}
