package auction.config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/vulnerable.js")
public class VulnerableScriptServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain"); // Set the Content-Type header to text/plain
        PrintWriter out = response.getWriter();
        out.println("alert('This is a vulnerable script!');");
        out.close();
    }
}
