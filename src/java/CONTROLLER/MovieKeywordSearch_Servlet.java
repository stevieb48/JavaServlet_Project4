/**
 * @author: Stephen Bailey #970396252
 * course: COP4856 201808
 * assignment: Project 4
 * @since: 11/30/2018 file name: MovieKeywordSearch_Servlet.java
 * @version: 1.0
 */
package CONTROLLER;

import MODEL.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description: Purpose of this servlet MovieKeywordSearch_Servlet is to
 * RETRIEVE all the playlists from the Users MYSQL database that contain the
 * user input (keyword), REDIRECT to results.html if found passing the results,
 * REDIRECT to notFound.html if NOT found, CONTAINS JavaDocs Annotations.
 */
@WebServlet(
        name = "MovieKeywordSearch_Servlet",
        urlPatterns = {"/MovieKeywordSearch_Servlet"},
        asyncSupported = true)
public class MovieKeywordSearch_Servlet extends HttpServlet {
    
    // CONSTANT
    private final String NOT_FOUND = "NOT FOUND";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");        

        // store keyword parameter
        String keywordInput = request.getParameter("txtMovieKeyword");

        // create database object with connection
        DatabaseCommunication newDatabaseCommunication = new DatabaseCommunication();

        // pass lowercase keyword to database object requestRecord method and return results object
        Movie newSearchResults = newDatabaseCommunication.requestRecord(keywordInput.toLowerCase());

        // new variable to store the new response string
        String movieResults = "";

        // if results object title variable equals searchResults CONSTANT "NOT FOUND"
        if (newSearchResults.title.equals(NOT_FOUND)) {
            // store the not found response string
            movieResults = "<h1 id='keywordNotFound'>SORRY - I could not find a movie matching the keyword = " + keywordInput;
        } else {
            // store the movie found response string
            movieResults = newSearchResults.toString();
        }

        // setup new response
        response.reset();
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(movieResults);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
