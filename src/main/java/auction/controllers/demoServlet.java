package auction.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/demo")
public class demoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url = "/index.html";

        if (action == null) {
            action = "demo_X_content"; // default action
        }

        if(action.equals("demo_X_content")){
            response.setContentType("text/text");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('This is a malicious script!');</script>");
            url = "/0.demo_X.html";


        }

        getServletContext().getRequestDispatcher(url).forward(request, response);



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
