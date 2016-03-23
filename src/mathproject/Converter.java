/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathproject;

/**
 *
 * @author Alejandra Martínez Cuevas
 * @author David Sánchez Almanza
 * @version 1.0
 */
public abstract class Converter {
    
    public Automata convertToNFA(Automata nfal) {
        Automata nfa = new Automata();
        return nfa;
    }
    
    public Automata convertToDFA(Automata nfa) {
        Automata dfa = new Automata();
        return dfa;
    }
    
    
    
}
