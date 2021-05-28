import React from 'react'
import '../index.css';
import { Link } from "react-router-dom";

export default function FormEliminacion() {
    return (
        <div>
             <h1>Eliminar Persona Censada</h1>
            <form name="deleteForm" method="post" action="http://localhost:8080/Censo/EliminarPersona " >
                <label for="NDoc">Numero Documento de la persona a eliminar </label>
                <input type="number" name="numDocEliminar" required></input>
                <button type="submit"> Eliminar Persona </button>
            <Link to="/">
      <button> Volver al inicio </button>
      </Link>
            </form>
        </div>
    )
}