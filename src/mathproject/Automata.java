package mathproject;

import java.util.List;
import java.util.ArrayList;

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
    private List<Estado> temp = new ArrayList<>();
    protected List<String> strings = new ArrayList<>();
    
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
    public void execute() {
        List<String> symbols;        
        symbols = new ArrayList<>();
        for (int i = 0; i < simbolos.size(); i++) {
            char s = simbolos.get(i).getSimbolo();
            symbols.add(Character.toString(s));
        }
        
        if (symbols.contains("l") == true) {
            System.out.println("El automata es de tipo no determinístico con transiciones lambda");
            //printAutomate("Automata Finito No Deterministico con Transiciones lambda");
            Automata nfa = calculateNFA();
            nfa.getEstadosFinales();
            //printAutomate("Automata Finito No Deterministico");
            Automata dfa = nfa.calculateDFA();
            //printAutomate("Automata Finito Deterministico");
            Automata min = dfa.calculateMinimized();
            //printAutomate("Automata Finito Minimizado");
        } else {
            if (isDFA() == false) {
                //printAutomate("Automata Finito No Deterministico");
                Automata dfa = calculateDFA();
                //printAutomate("Automata Finito Deterministico");
                Automata min = calculateMinimized();
                //printAutomate("Automata Finito Minimizado");
            } else {
                //printAutomate("Automata Finito Deterministico");
                Automata min = calculateMinimized();
                //printAutomate("Automata Finito Minimizado");
            }
        }
    }
    
    /**
     * Method calculateNFA calculates the Non-Deterministic Finite Automata.
     * @return 
     */
    public Automata calculateNFA() {
        // Removes lambda, keeps other symbols
        Automata nfa = new Automata();
        List<Simbolo> symbols = new ArrayList<>();
        for (int i = 0; i < simbolos.size(); i++) {
            char s = simbolos.get(i).getSimbolo();
            if (s != 'l') {
                Simbolo sym = new Simbolo();
                sym.setSimbolo(s);
                symbols.add(sym);
            }
        }
        nfa.setSimbolos(symbols);
        // Add states
        List<Estado> es = new ArrayList<>();
        for (int i = 0; i < estados.size(); i++) {
            Estado e = new Estado();
            String s = estados.get(i).getEstado();
            e.setEstado(s);
            es.add(e);
        }
        nfa.setEstados(es);
        nfa.setEstadoInicio(estadoInicio);
        nfa.setEstadosFinales(estadosFinales);
        List<Transition> transitions = new ArrayList<>();
        for (int i = 0; i < transiciones.size(); i++) { 
            Transition t = new Transition();
            if (transiciones.get(i).getSimbolo() != 'l') {
                t.setEstadosInicio(transiciones.get(i).getEstadosInicio());
                List<Estado> e = transiciones.get(i).getEstadosInicio();
                for (int j = 0; j < e.size(); j++) {
                    t.setSimbolo(transiciones.get(i).getSimbolo());
                    System.out.println("Calculate l-closure");
                    lclosure(transiciones.get(i));
                }
            }
        }
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
    
    /**
     * Method: printAutomate, print automate table
     * @param title
     */
    protected void printAutomate(String title) {
        String[][] tablaTransiciones = new String[simbolos.size()][estados.size()];
        System.out.println(title);
        // Fill table
        int count = 0;
        int max = 0;
        for (int i = 0; i < estados.size(); i++) {
            for (int j = 0; j < simbolos.size(); j++) {
                StringBuilder sb = new StringBuilder();
                List<Estado> arrivals = transiciones.get(count).getEstadosLlegada();
                sb.append('{');
                for (int k = 0; k < arrivals.size(); k++) {
                    if (k == arrivals.size() - 1) {
                        sb.append(arrivals.get(k).getEstado());
                        sb.append('}');
                    } else {
                        sb.append(arrivals.get(k).getEstado());
                        sb.append(',');
                    }
                    tablaTransiciones[j][i] = sb.toString();
                    if (sb.length() > max) {
                        max = sb.length();
                    }
                }
                count++;
            }
        }
        // Print header
        StringBuilder sb = new StringBuilder();
        sb.append("t");
        while(sb.length() < max + 1) {
            sb.append(' ');
        }
        System.out.print(sb.toString());
        for (int i = 0; i < simbolos.size(); i++) {
            sb = new StringBuilder();
            sb.append("|");
            sb.append(simbolos.get(i).getSimbolo());
            while (sb.length() < max + 2) {
                sb.append(' ');
            }
            System.out.print(sb.toString());
        }
        System.out.println();
        for (int i = 0; i < estados.size(); i++) {
            sb = new StringBuilder();
            sb.append(estados.get(i).getEstado());
            while (sb.length() < max + 1) {
                sb.append(' ');
            }
            System.out.print(sb.toString());
            for (int j = 0; j < simbolos.size(); j++) {
                System.out.print('|');
                sb = new StringBuilder();
                sb.append(tablaTransiciones[j][i]);
                while(sb.length() < max + 1) {
                    sb.append(' ');
                }
                System.out.print(sb.toString());
            }
            System.out.println();
        }
        
    }
    
    public List<Estado> lclosure(Transition transicion) {
        // Recorre las transiciones y agrega dependiendo de d(qi, l)     
        
        
        for (int i = 0; i < transiciones.size(); i++) {
            List<Estado> initials = transiciones.get(i).getEstadosInicio();
            char s = transiciones.get(i).getSimbolo();
            for (int j = 0; j < initials.size(); j++) {
                String current = initials.get(j).getEstado();
                for (int k = 0; k < transicion.getEstadosInicio().size(); k++) {
                    String temporal = transicion.getEstadosInicio().get(k).getEstado();
                    if (temporal.equals(current) && transicion.getSimbolo() == s) {
                        Estado estado = new Estado();
                        if (strings.contains(current) != true) {
                            System.out.println("Agregó " + current);
                            estado.setEstado(current);
                            strings.add(current);
                            temp.add(estado);
                            //lclosure(transicion);
                        }
                    }
                }
            }
        }
        System.out.print(strings.toString());
        return temp;
    }
    
}
