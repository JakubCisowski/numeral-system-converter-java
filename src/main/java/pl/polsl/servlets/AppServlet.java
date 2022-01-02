package pl.polsl.servlets;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import pl.polsl.models.Converter;
import pl.polsl.models.InvalidParameterException;
import pl.polsl.models.Registry;

/**
 * Main class of the servlet that demonstrates parameter download given during
 * servlet initialization
 *
 * @author Gall Anonim
 * @version 1.0
 */
@WebServlet("/Form")
public class AppServlet extends HttpServlet {

    /**
     * Collection of statistics
     */
   private final Registry registry;

    /**
     * Constructor initiating statistics collection
     */
    public AppServlet() {
        registry = new Registry();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();

        // Get parameter values - firstName i lastName
        //String firstName = request.getParameter("firstname");
        //String lastName = request.getParameter("lastname");
        
        String numberValueInput = request.getParameter("numberValue");
        String originalSystemInput = request.getParameter("originalSystem");
	String targetSystemInput = request.getParameter("targetSystem");

        // FirstName or lastName was not given - send error message
        if (numberValueInput.length() == 0 || originalSystemInput.length() == 0 || targetSystemInput.length() == 0) {
            response.sendError(response.SC_BAD_REQUEST, "Input can't be empty!");
        } else {
            Converter converter = new Converter();
            String output = "";
            
            try{
                    String conversionResult = converter.convertNumeralSystem(numberValueInput, originalSystemInput, targetSystemInput);
                    registry.addConversionSet(numberValueInput,originalSystemInput,targetSystemInput,conversionResult);
                    output = conversionResult;
            } catch (InvalidParameterException e) {
                    response.sendError(response.SC_BAD_REQUEST, e.getMessage());
            }
            out.println("<html>\n<body>\n<h1>" + output + "</h1>\n");
            out.println("</body>\n</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/plain; charset=ISO-8859-2");
        PrintWriter out = response.getWriter();

        out.println("Passed parameters:");

        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            out.println(name + " = " + request.getParameter(name));
        }
    }
}
