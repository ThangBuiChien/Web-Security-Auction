package auction.config;

import java.security.SecureRandom;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CsrfTokenManager {
    public static final String CSRF_TOKEN_SESSION_ATTR_NAME = "csrfToken";

    public static String generateCsrfToken() {
        SecureRandom random = new SecureRandom();
        byte[] token = new byte[16];
        random.nextBytes(token);
        return new String(token);
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
