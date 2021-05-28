package formularioServlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formulario
 */
@WebServlet("/EliminarPersona")
public class EliminarPersona extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	static final String DB_URL =  "jdbc:sqlite:C:\\Users\\VTE Global\\Desktop\\sqlite\\censoArg.db"; 
	static final String DELETE_QUERY ="DELETE FROM censo WHERE NumDoc = ?";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
	
		
		int numDocEliminar = Integer.parseInt(req.getParameter("numDocEliminar"));
	
		
		try { 
			Connection conn = DriverManager.getConnection(DB_URL);
		    PreparedStatement stmt = conn.prepareStatement(DELETE_QUERY);
		    stmt.setInt(1,numDocEliminar);
		    int cambiosRealizados = stmt.executeUpdate();
		    
		    if (cambiosRealizados > 0) {
		    	PrintWriter out = response.getWriter();
			    out.println("<h1> Persona eliminada exitosamente </h1>"
							+  "<button><a href=http://localhost:3000/> Volver al inicio </a></button>");
		    } else {
		    	PrintWriter out = response.getWriter();
			    out.println("<h1> Persona no encontrada </h1>"
							+  "<button><a href=http://localhost:3000/> Volver al inicio </a></button>");
		    }
		  
		      } catch (SQLException e) {
		         e.getMessage();
		      } 

}
}	