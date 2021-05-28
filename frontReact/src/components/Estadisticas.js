import React from 'react'
import '../index.css';
import { Link } from "react-router-dom";    

export default function Estadisticas() {
    return (
        <div>
            <h1>Escoja estadistica para descargar</h1>
            <div>
            <form name="descargaPersonasForm" method="get" action="http://localhost:8080/Censo/DescargarPersonas " >
                <button className="width" type="submit"> Personas Censadas  </button>
            </form>
            </div>
            <div>
            <form name="descargaPersonasPobresForm" method="get" action="http://localhost:8080/Censo/DescargarPersonasPobres " >
                <button type="submit"> Personas Pobres  </button>
            </form>
            </div>
            <div>
            <form name="descargaPersonasDesempleadasMayroesForm" method="get" action="http://localhost:8080/Censo/DescargarMayoresEdadDesempleados " >
                <button type="submit"> Personas Mayores Desempleadas  </button>
            </form>
            <div>
            </div>
            <form name="descargarCantMujerHombre" method="get" action="http://localhost:8080/Censo/DescargarCantHombreMujer " >
                <button type="submit"> Cantidad Mujeres y Hombres  </button>
            </form>
            </div>
            <div> <Link to="/">
      <button> Volver al inicio </button>
      </Link></div>
        </div>
    )
}