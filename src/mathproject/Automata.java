package mathproject;

import java.util.List;

/**
 *
 * @author Alejandra Martínez Cuevas
 * @author David Sánchez Almanza
 * @version 1.0
 */
public class Automata extends Converter {
    private List<Estado> estados;
    private List<Simbolo> simbolos;
    private List<Estado> estadoInicio;
    private List<Estado> estadosFinales;
    private List<Transition> transiciones;
    
    public Automata() { } ;
    
    public Automata(List<Estado> estados, List<Simbolo> simbolos, List<Estado> estadoInicio, List<Estado> estadosFinales, List<Transition> transiciones) {
        this.estados = estados;
        this.simbolos = simbolos;
        this.estadoInicio = estadoInicio;
        this.estadosFinales = estadosFinales;
        this.transiciones = transiciones;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Simbolo> getSimbolos() {
        return simbolos;
    }

    public void setSimbolos(List<Simbolo> simbolos) {
        this.simbolos = simbolos;
    }

    public List<Estado> getEstadoInicio() {
        return estadoInicio;
    }

    public void setEstadoInicio(List<Estado> estadoInicio) {
        this.estadoInicio = estadoInicio;
    }

    public List<Estado> getEstadosFinales() {
        return estadosFinales;
    }

    public void setEstadosFinales(List<Estado> estadosFinales) {
        this.estadosFinales = estadosFinales;
    }

    public List<Transition> getTransiciones() {
        return transiciones;
    }

    public void setTransiciones(List<Transition> transiciones) {
        this.transiciones = transiciones;
    }
    
    
    
    
}
