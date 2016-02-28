package mathproject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandra Martínez Cuevas
 * @author David Sánchez Almanza
 * @version 1.0
 */
public class Transition {
    
    private List<Estado> estadosInicio = new ArrayList<>();
    private List<Estado> estadosLlegada = new ArrayList<>();
    private char simbolo;
    
    public Transition() {}
    public Transition(List<Estado> estado) {
        this.estadosInicio = estado;
    }
    
    public List<Estado> getEstadosInicio() {
        return estadosInicio;
    }

    public void setEstadosInicio(List<Estado> estado) {
        this.estadosInicio = estado;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public List<Estado> getEstadosLlegada() {
        return estadosLlegada;
    }

    public void setEstadosLlegada(List<Estado> estadosLlegada) {
        this.estadosLlegada = estadosLlegada;
    }
    
    public void addEstadoInicio(String estadoInicio) {
        Estado estado = new Estado();
        estado.setEstado(estadoInicio);
        estadosInicio.add(estado);
    }
    
    public void addEstadoLlegada(String estadoLlegada) {
        Estado estado = new Estado();
        estado.setEstado(estadoLlegada);
        estadosLlegada.add(estado);
    }
    public void printTransition() {
        Estado estado = new Estado();
        for (int i = 0; i < estadosInicio.size(); i++) {
            estado = estadosInicio.get(i);
            System.out.print(estado.getEstado() + ",");
        }
        System.out.print(simbolo);
        System.out.print("=>");
        for (int i = 0; i < estadosLlegada.size(); i++) {
            if (i < estadosLlegada.size() - 1) {
                estado = estadosLlegada.get(i);
                System.out.print(estado.getEstado() + ",");
            } else {
                estado = estadosLlegada.get(estadosLlegada.size() - 1);
                System.out.print(estado.getEstado());
            }
        }
        System.out.println();
    }
    
}
