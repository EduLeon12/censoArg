package formularioServlet;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
@WebServlet("/DescargarCantHombreMujer")
public class DescargarCantHombreMujer extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	static final String DB_URL =  "jdbc:sqlite:C:\\Users\\VTE Global\\Desktop\\sqlite\\censoArg.db"; 
	static final String QUERY ="SELECT Genero, count(*) AS Contador From censo ";
		
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DescargarCantHombreMujer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter pw = response.getWriter();
		
		  try {
			  Connection conn = DriverManager.getConnection(DB_URL);
			    PreparedStatement pstmt = conn.prepareStatement(QUERY);
			    ResultSet rs = pstmt.executeQuery();
			    
			    File file = new File("C:\\Users\\VTE Global\\Desktop\\statistics\\cant_generos_censados.txt");
			    FileWriter fstream = new FileWriter(file,true);
			    BufferedWriter out = new BufferedWriter(fstream);
			    
	            while (rs.next()) {
	            	out.write(rs.getString("Genero") +", ");
	            	out.write(rs.getInt("Contador") +", ");
			    	out.newLine();       	
	            } 
	      

	            System.out.println("Descarga Completada");
			    pw.println("<h1> Descarga Completada Exitosamente </h1>"
						+ "<button><a href=http://localhost:3000/> Volver al inicio </a></button>");
			    out.close();
			    
			      } catch (SQLException e) {
			         e.getMessage();
			      }          
}
}