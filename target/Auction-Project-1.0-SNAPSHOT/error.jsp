<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/8/2024
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.security.SecureRandom" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>

<%
    // Generate nonce
    byte[] nonceBytes = new byte[16];
    try {
        SecureRandom.getInstanceStrong().nextBytes(nonceBytes);
    } catch (NoSuchAlgorithmException e) {
        throw new RuntimeException(e);
    }
    String nonce = Base64.getEncoder().encodeToString(nonceBytes);

    // Define CSP with nonce and allowlist for CDNs
    String cspString = "default-src 'self'; " +
            "script-src 'self' 'nonce-" + nonce + "' https://code.jquery.com https://cdn.jsdelivr.net; " +
            "style-src 'self' 'nonce-" + nonce + "' https://cdn.jsdelivr.net; " +
            "img-src 'self'; " +
            "frame-ancestors 'self'; " +
            "form-action 'self';";
    response.setHeader("Content-Security-Policy", cspString);
    response.setHeader("X-Frame-Options", "SAMEORIGIN");
%>

<style nonce="<%= nonce %>">
</style>

<script nonce="<%= nonce %>">
</script>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error page</h1>
    <p>There is an error while using the website</p>
    <p>Please return back to the main page</p>
</body>
</html>
