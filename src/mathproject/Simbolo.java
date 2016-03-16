package mathproject;

/**
 *
 * @author Alejandra Martínez Cuevas
 * @author David Sánchez Almanza
 * @version 1.0
 */
public class Simbolo {
    
    private char simbolo;

    public Simbolo() {}
    public Simbolo(char simbolo) {
        this.simbolo = simbolo;
    }
    
    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
    
    public void printSimbolo() {
        System.out.println(simbolo);
    }
    
}
