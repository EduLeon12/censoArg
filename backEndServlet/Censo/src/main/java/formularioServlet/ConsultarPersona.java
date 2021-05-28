package formularioServlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Formulario
 */
@WebServlet("/ConsultarPersona")
public class ConsultarPersona extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	static final String DB_URL =  "jdbc:sqlite:C:\\Users\\VTE Global\\Desktop\\sqlite\\censoArg.db"; 

	static final String QUERY ="SELECT * FROM censo WHERE NumDoc = ?";
		
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		int numDoc = Integer.parseInt(req.getParameter("numDocConsulta"));
		
		try { 
			Connection conn = DriverManager.getConnection(DB_URL);
		    PreparedStatement pstmt = conn.prepareStatement(QUERY);
		    pstmt.setInt(1, numDoc);
		    ResultSet rs = pstmt.executeQuery();
		    
		    PrintWriter out = response.getWriter();
		    if (rs != null) {
		    	out.println("<h1> Persona encontrada </h1>"
		    			
		
		    			+ "<h5>Nombre: "+rs.getString("Nombre")+"</h5>"
		    		    + "<h5>Apellido: "+rs.getString("Apellido")+"</h5>"	

				    	+ "<h5>Genero: "+rs.getString("Genero")+"</h5>"
				    
				    	+ "<h5>Direccion: "+rs.getString("Direccion")+"</h5>"
				    
				    	+ "<h5>Telefono: "+rs.getInt("Telefono")+"</h5>"
				    	
				    	+ "<h5>Ocupacion: "+rs.getString("Ocupacion")+"</h5>"
			
				    	+ "<h5>Edad: "+rs.getString("Edad")+"</h5>"
				    
				    	+ "<h5>Ingreso: "+rs.getInt("Ingreso")+"</h5>"
				    
						+ "<button><a href=http://localhost:3000/>Volver</a></button>");
		    } else {
		    	out.println("<h1> Persona no censada </h1>"
		    			+ "<br>"
						+"<button><a href=http://localhost:3000/> Volver al inicio </a></button>");
		    }
		    
	  
		      } catch (SQLException e) {
		         e.getMessage();
		      } 

}
}