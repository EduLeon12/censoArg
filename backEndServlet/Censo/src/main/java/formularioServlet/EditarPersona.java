package formularioServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
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
@WebServlet("/EditarPersona")
public class EditarPersona extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	static final String DB_URL =  "jdbc:sqlite:C:\\Users\\VTE Global\\Desktop\\sqlite\\censoArg.db"; 
	static final String UPDATE_QUERY ="UPDATE censo SET"
			+"Nombre = ?, "
			+"Apellido = ?, "
			+"Edad = ?, "
			+"Genero = ?, "
			+"Direccion = ?, "
			+"Telefono = ?, "
			+"Ocupacion = ?, "
			+"Ingreso = ?,"
			+"[WHERE NumDoc = ?]";
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		int numDoc = Integer.parseInt(req.getParameter("numDocEditar"));
		String nombre = req.getParameter("nombreEditar");
		String apellido = req.getParameter("apellidoEditar");
		String fechaNac = req.getParameter("fechaNacEditar");
		String [] stringFecha = fechaNac.split("-");
		int anio = Integer.parseInt(stringFecha[0]);
		int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		int edad = anioActual - anio; 
		String genero = req.getParameter("generoEditar");
		String direccion = req.getParameter("direccionEditar");
		int telefono = Integer.parseInt(req.getParameter("telefonoEditar"));
		String ocupacion = req.getParameter("ocupacionEditar").toLowerCase();
		int ingreso = Integer.parseInt(req.getParameter("ingresoEditar"));
				
		try { 
			Connection conn = DriverManager.getConnection(DB_URL);
		    PreparedStatement pstmt = conn.prepareStatement(UPDATE_QUERY);
		
		    pstmt.setString(1, nombre);
		    pstmt.setString(2, apellido);
		    pstmt.setInt(3, edad);
		    pstmt.setString(4, genero);
		    pstmt.setString(5, direccion);
		    pstmt.setInt(6, telefono);
		    pstmt.setString(7, ocupacion);
		    pstmt.setInt(8, ingreso);   
		    pstmt.setInt(9, numDoc);
		    
		    int cambiosRealizados = pstmt.executeUpdate();
		    
		    if (cambiosRealizados > 0) {
		    	PrintWriter out = response.getWriter();
			    out.println("<h1> Persona editada exitosamente </h1>"
							+ "<button><a href=http://localhost:3000/> Volver al inicio </a></button>");
		    } else {
		    	PrintWriter out = response.getWriter();
			    out.println("<h1> Persona no encontrada </h1>"			    		
							+"<button style><a href=http://localhost:3000/> Volver al inicio </a></button>");
		    }
		  
		      } catch (SQLException e) {
		         e.getMessage();
		      } 

}
}