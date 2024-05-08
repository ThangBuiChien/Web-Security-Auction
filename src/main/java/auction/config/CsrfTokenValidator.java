package auction.config;
import javax.servlet.http.HttpServletRequest;


public class CsrfTokenValidator {
    public static boolean isValidCsrfToken(HttpServletRequest request) {
        String csrfToken = request.getParameter("csrfToken");
        String sessionToken = CsrfTokenManager.getCsrfToken(request);
        return csrfToken != null && csrfToken.equals(sessionToken);
    }
}
