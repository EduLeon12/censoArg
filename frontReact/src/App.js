import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Switch, Route } from "react-router-dom";
import FormCreacion from "./components/FormCreacion.js";
import FormEdicion from "./components/FormEdicion.js";
import FormEliminacion from "./components/FormEliminacion.js";
import FormConsulta from "./components/FormConsulta.js"
import Home from "./components/Home.js"
import Estadisticas from './components/Estadisticas';

function App() {
  return (
    <BrowserRouter>
        <div className="App">
          <Switch>
            <Route exact path="/">
              <Home/>
            </Route>
            <Route path="/FormCreacion">
              <FormCreacion />
            </Route>
            <Route path="/FormEliminacion">
              <FormEliminacion />
            </Route>
            <Route path="/FormEdicion">
              <FormEdicion />
            </Route>
            <Route path="/FormConsulta">
              <FormConsulta />
            </Route>
            <Route path="/Estadisticas">
              <Estadisticas />
            </Route>
          </Switch>
        </div>
      </BrowserRouter>
  );
}

export default App;
