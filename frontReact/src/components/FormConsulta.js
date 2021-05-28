import React from 'react'
import '../index.css';
import { Link } from "react-router-dom";

export default function ConsultarPersona() {
    return (
        <div>
             <h1>Consultar Persona Censada</h1>
            <form name="consultForm" method="post" action="http://localhost:8080/Censo/ConsultarPersona " >
                <label for="NDoc">Numero Documento de la persona a consultar </label>
                <input type="number" name="numDocConsulta" required></input>
                <button type="submit"> Consultar Persona </button>
            <Link to="/">
      <button> Volver al inicio </button>
      </Link>
            </form>
        </div>
    )
}