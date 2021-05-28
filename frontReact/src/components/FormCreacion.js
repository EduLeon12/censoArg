import React from 'react'
import { Link } from "react-router-dom";

export default function FormCreacion(){
    return (
     
      <main>
      <form name="createForm" action="http://localhost:8080/Censo/CrearPersona" method="post">
        
        <h1>Censar nueva persona</h1>
          <label for="Tdoc">Tipo de Documento: </label>
          <select id="job" name="tipoDoc" required>
            <option value="dnir">DNI.</option>
            <option value="libretaCivica">L.C.</option>
            <option value="libretaEnrolamiento">L.E.</option>
            <option value="CedulaIdentidad">C.I.</option>   
        </select>
  
          <label for="NDoc" >Numero de Documento</label>
          <input type="number"  name="numDoc" required/>
          
          <label for="Nombre">Nombre:</label>
          <input type="text"  name="nombre" required />
          
          <label for="Apellido">Apellido:</label>
          <input type="text"  name="apellido" required/>
  
          <label for="FechaNacimiento">Fecha de Nacimiento</label>
          <input type="date" name="fechaNac" required/>
          
          <label>Genero:</label>
          <select name="genero" required>
           <option value="" disabled selected>Escoja su genero</option>
            <option value="hombre">Hombre</option>
            <option value="libretaCivica">Mujer</option> 
          </select>
  
          <label for="Direccion">Direccion:</label>
          <input type="text" name="direccion"/>
  
          <label for="Telefono">Telefono</label>
          <input type="number" name="telefono" />
  
          <label for="ocupacion">Ocupacion</label>
          <input type="text" name="ocupacion" />
  
          <label for="Ingreso">Ingreso Mensual</label>
          <input type="number" name="ingreso" required/>
  
        
        <button type="submit"> Censar Persona </button>
      <Link to="/">
      <button> Volver al inicio </button>
      </Link>
      </form>
      </main>
    );
}