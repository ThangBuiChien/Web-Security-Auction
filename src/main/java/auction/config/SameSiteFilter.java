package auction.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SameSiteFilter", urlPatterns = "/*")
public class SameSiteFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Cast ServletRequest to HttpServletRequest to access session-related methods
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        // Retrieve session ID
        String sessionId = httpRequest.getSession().getId();

        // Manually construct the Set-Cookie header with necessary attributes
        String cookieValue = "JSESSIONID=" + sessionId + ";";
        cookieValue += "Path=/Auction_Project_war;";
        cookieValue += "HttpOnly;";
        cookieValue += "SameSite=Lax;";
        cookieValue += "Secure;"; // Make sure your application is served over HTTPS
        httpResponse.setHeader("Set-Cookie", cookieValue);

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}
