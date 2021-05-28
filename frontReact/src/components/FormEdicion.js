import React from 'react'
import '../index.css';
import { Link } from "react-router-dom";

export default function FormEdicion() {
    return (
        <>
             <h1>Editar Persona Censada</h1>
            <form name="editarForm" action="http://localhost:8080/Censo/EditarPersona" method="post">
                <label for="NDoc">Numero Documento de la persona a editar </label>
                <input type="number" name="numDocEditar" required></input>

                <h3>Edite los datos que vea necesario</h3>

                <label for="Nombre">Nombre:</label>
                <input type="text" name="nombreEditar"  />

                <label for="Apellido">Apellido:</label>
                <input type="text" name="apellidoEditar"  />

                <label for="FechaNacimiento">Fecha de Nacimiento</label>
                <input type="date" name="fechaNacEditar"  />

                <label>Genero:</label>
                <select name="generoEditar" >
                    <option value="" disabled selected>Escoja su genero</option>
                    <option value="hombre">Hombre</option>
                    <option value="mujer">Mujer</option>
                </select>

                <label for="Direccion">Direccion:</label>
                <input type="text" name="direccionEditar" />

                <label for="Telefono">Telefono</label>
                <input type="number" name="telefonoEditar" />

                <label for="ocupacion">Ocupacion</label>
                <input type="text" name="ocupacionEditar" />

                <label for="Ingreso">Ingreso Mensual</label>
                <input type="number" name="ingresoEditar"  />

                <button type="submit"> Editar Persona </button>
            <Link to="/">
      <button> Volver al inicio </button>
      </Link>
            </form>


        </>
    )
}