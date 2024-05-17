package auction.config;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.XMLConstants;

public class XSLTServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String xmlInput = "<root><element>Example</element></root>";
        String xsltInput = "<?xml version=\"1.0\"?>" +
                "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">" +
                "<xsl:template match=\"/\">" +
                "<html><body><h2>Transformed</h2></body></html>" +
                "</xsl:template></xsl:stylesheet>";

        try {
            TransformerFactory factory = TransformerFactory.newInstance();

            // Enable secure processing
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // Disable access to external resources
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

            Transformer transformer = factory.newTransformer(new StreamSource(new StringReader(xsltInput)));

            StringWriter writer = new StringWriter();
            transformer.transform(new StreamSource(new StringReader(xmlInput)), new StreamResult(writer));

            response.setContentType("text/html");
            response.getWriter().write(writer.toString());

        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing XSLT");
            e.printStackTrace();
        }
    }
}
