import React from 'react'
import '../index.css';
import { Link } from "react-router-dom";

export default function Home(){
    return (
      <main>
          <div>
          <h1>Bienvenido al Censo Argentina 2021</h1>
          <h2>Escoja una opcion</h2>
          <Link to="/FormCreacion">
              <button> Censar Persona</button>
          </Link>
          <Link to="/FormEdicion">
              <button> Editar Persona </button>
          </Link>
          <Link to="/FormEliminacion">
              <button> Eliminar Persona </button>
          </Link>
          <Link to="/FormConsulta">
              <button> Consultar Persona </button>
          </Link>
          <Link to='/Estadisticas'>
              <button>Descargar Estadisticas</button>
          </Link>
          </div>

    </main>
    

    );
}