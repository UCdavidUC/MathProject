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
    private Estado estadoInicio;
    private List<Estado> estadosFinales;
    private List<Transition> transiciones;
    
    public Automata() { } ;
    
    public Automata(List<Estado> estados, List<Simbolo> simbolos, Estado estadoInicio, List<Estado> estadosFinales, List<Transition> transiciones) {
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

    public Estado getEstadoInicio() {
        return estadoInicio;
    }

    public void setEstadoInicio(Estado estadoInicio) {
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
    
    /**
     * Method isNFAL determines if the automate has lambda transitions
     * @return true, false
     */
    public boolean isNFAL() {
        for (int i = 0; i < simbolos.size(); i++) {
            if (simbolos.get(i).getSimbolo() == 'l') {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method isDFA determines if the automate is Deterministic or Non-Deterministic
     * @return true, false
     */
    public boolean isDFA() {
        for (int i = 0; i < transiciones.size(); i++) {
            List<Estado> llegadas = transiciones.get(i).getEstadosLlegada();
            if (llegadas.size() > 1) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Method execute runs all task needed to calculate nfa, dfa and minimized automata
     * @param automata 
     */
    public void execute(Automata automata) {
        if (simbolos.contains(new Simbolo('l')) == true) {
            System.out.println("El automata es de tipo no determinístico con transiciones lambda");
            Automata nfa = calculateNFA();
            nfa.getEstadosFinales();
            Automata dfa = nfa.calculateDFA();
            Automata min = dfa.calculateMinimized();
        } else {
            if (automata.isDFA() == false) {
                
            } else {
                
            }
        }
    }
    
    
    /**
     * Method calculateNFA calculates the Non-Deterministic Finite Automata.
     * @return 
     */
    public Automata calculateNFA() {
        Automata nfa = new Automata();
        return nfa;
    }
    
    /**
     * Method calcultaDFA calculate Deterministic Finite Automata.
     * @return 
     */
    public Automata calculateDFA() {
        Automata dfa = new Automata();
        return dfa;
    }
    
    /**
     * Method calculate Minimized calculates minimized Deterministic Finite Automata.
     * @return 
     */
    public Automata calculateMinimized() {
        Automata min = new Automata();
        return min;
    }
    
}
