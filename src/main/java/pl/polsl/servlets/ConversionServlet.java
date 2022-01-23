package pl.polsl.servlets;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import pl.polsl.models.Converter;
import java.time.LocalDateTime;
import pl.polsl.models.InvalidParameterException;
import pl.polsl.models.Registry;
import pl.polsl.controllers.DatabaseController;
import pl.polsl.entities.DateEntry;
import pl.polsl.entities.RegistryEntry;

/**
 * Main class of the web application servlet, that handles the main form.
 *
 * @author Jakub Cisowski
 * @version 1.0
 */
@WebServlet("/Conversion")
public class ConversionServlet extends HttpServlet {
     /**
     * Converter
     */
    private final Converter converter = new Converter();
    
      /**
     * Database
     */
    private final DatabaseController databaseController = new DatabaseController();

   
    /**
     * Constructor 
    public ConversionServlet() {
         converter = new Converter();
     }
     */
    
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
        
        String numberValueInput = request.getParameter("numberValue");
        String originalSystemInput = request.getParameter("originalSystem");
	String targetSystemInput = request.getParameter("targetSystem");

        if (numberValueInput.length() == 0 || originalSystemInput.length() == 0 || targetSystemInput.length() == 0) {
            response.sendError(response.SC_BAD_REQUEST, "Input can not be empty!");
        } else {
            String output = "";
            
            try{
                    String conversionResult = converter.convertNumeralSystem(numberValueInput, originalSystemInput, targetSystemInput);
                    // RegistryServlet.registry.addConversionSet(numberValueInput,originalSystemInput,targetSystemInput,conversionResult);
                    output = conversionResult;
                    
                     // Add to database
                    DateEntry dateEntry = new DateEntry(LocalDateTime.now());
                    RegistryEntry registryEntry = new RegistryEntry(numberValueInput, originalSystemInput, output, targetSystemInput, dateEntry);

                    databaseController.persistObject(registryEntry);
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
        doGet(request, response);
    }
}
