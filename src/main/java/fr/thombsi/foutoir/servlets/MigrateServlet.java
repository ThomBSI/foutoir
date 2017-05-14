package fr.thombsi.foutoir.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MigrateServlet extends HttpServlet {
    public static final String VIEW   = "/WEB-INF/migrate.jsp";
    public static final String TITTLE = "Faire évoluer la BDD";

    public void doGet( HttpServletRequest request,
            HttpServletResponse response )
            throws ServletException, IOException {

        request.setAttribute( "tittle", TITTLE );

        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }
}
