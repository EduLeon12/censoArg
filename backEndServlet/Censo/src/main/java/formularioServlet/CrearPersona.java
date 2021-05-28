package formularioServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrearPersona
 */
@WebServlet("/CrearPersona")
public class CrearPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	static final String DB_URL =  "jdbc:sqlite:C:\\Users\\VTE Global\\Desktop\\sqlite\\censoArg.db"; 
	static final String QUERY ="INSERT INTO censo (TipoDoc, NumDoc, Nombre, Apellido, Edad, Genero, Direccion, Telefono, Ocupacion, Ingreso)"+
            "VALUES (?,?,?,?,?,?,?,?,?,?)";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPersona() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tipoDoc = req.getParameter("tipoDoc");
		int numDoc = Integer.parseInt(req.getParameter("numDoc"));
		String nombre = req.getParameter("nombre");
		String apellido = req.getParameter("apellido");
		String fechaNac = req.getParameter("fechaNac");
		String [] stringFecha = fechaNac.split("-");
		int anio = Integer.parseInt(stringFecha[0]);
		int anioActual = Calendar.getInstance().get(Calendar.YEAR);
		int edad = anioActual - anio; 
		String genero = req.getParameter("genero");
		String direccion = req.getParameter("direccion");
		int telefono = Integer.parseInt(req.getParameter("telefono"));
		String ocupacion = req.getParameter("ocupacion").toLowerCase();
		int ingreso = Integer.parseInt(req.getParameter("ingreso"));
		
	
		
		try { 
			Connection conn = DriverManager.getConnection(DB_URL);
		    PreparedStatement pstmt = conn.prepareStatement(QUERY);
		    pstmt.setString(1, tipoDoc);
		    pstmt.setInt(2, numDoc);
		    pstmt.setString(3, nombre);
		    pstmt.setString(4, apellido);
		    pstmt.setInt(5, edad);
		    pstmt.setString(6, genero);
		    pstmt.setString(7, direccion);
		    pstmt.setInt(8, telefono);
		    pstmt.setString(9, ocupacion);
		    pstmt.setInt(10, ingreso);   
	
		    int cambiosRealizados = pstmt.executeUpdate();
		    
		    if (cambiosRealizados > 0) {
		    	PrintWriter out = response.getWriter();
			    out.println("<h1> Persona censada exitosamente </h1>"
							+ "<button><a href=http://localhost:3000/> Volver al inicio </a></button>");
		    	
		    }
		  
		      } catch (SQLException e) {
		         e.getMessage();
		      } 

}}
