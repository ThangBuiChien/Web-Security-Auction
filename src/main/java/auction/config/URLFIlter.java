
package auction.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "URLFilter", urlPatterns = {"/*"})

public class URLFIlter implements Filter {
    private static final Pattern SQL_INJECTION_PATTERN = Pattern.compile(".*(\\bunion\\b|\\bselect\\b|\\binsert\\b|\\bdelete\\b|\\bupdate\\b).*", Pattern.CASE_INSENSITIVE);
    private static final Pattern BANNED_CHARACTERS_PATTERN = Pattern.compile("[&<>'\";\\s\\x00-\\x1F]");
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Check if the request URI or parameters contain suspicious SQL keywords
        if (isSQLInjectionAttempt(request) || hasBannedCharacters(request)) {
            // Block the request and return an error response or redirect to a safe page
            //response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
            return;
             // Stop further processing
        }filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isSQLInjectionAttempt(HttpServletRequest request) {
        // Check request URI
        if (SQL_INJECTION_PATTERN.matcher(request.getRequestURI()).matches()) {
            return true;
        }

        // Check request parameters
        for (String parameterName : request.getParameterMap().keySet()) {
            String parameterValue = request.getParameter(parameterName);
            if (SQL_INJECTION_PATTERN.matcher(parameterValue).matches()) {
                return true;
            }
        }

        return false;
    }
    private boolean hasBannedCharacters(HttpServletRequest request) {
        // Check if the request URI or parameters contain banned characters
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        return BANNED_CHARACTERS_PATTERN.matcher(uri).find() || (queryString != null && BANNED_CHARACTERS_PATTERN.matcher(queryString).find());
    }


    @Override
    public void destroy() {
        // Cleanup code
    }
}

