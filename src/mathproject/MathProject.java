package mathproject;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandra Martínez Cuevas
 * @author David Sánchez Almanza
 * @version 1.0
 */
public class MathProject {

    protected static String line;
    protected static int lineCount;
    protected static List<String> lineStrings = new ArrayList<>();
    protected static List<Estado> estados = new ArrayList<>();
    protected static List<Simbolo> simbolos = new ArrayList<>();
    protected static String estadoInicial;
    protected static List<Estado> estadosFinales = new ArrayList<>();
    protected static List<Transition> transiciones = new ArrayList<>();
    protected static List<Transition> afd = new ArrayList<>();
    protected static char simbolo = ' ';
    protected static int numeroDeEstado = 0;
    
    public static void main(String[] args) throws IOException {
        Estado estado = new Estado();
        String filename = "file.txt";
        lineCount = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                switch(lineCount) {
                    // First line describes the automate states.
                    case 0:
                        String[] listaEstados = line.split(",");
                        for (String listaEstado : listaEstados) {
                            estado.setEstado(listaEstado);
                            estados.add(estado);
                        }
                        lineCount++;
                        break;
                    // Second line describes the symbols of the automate.
                    case 1:
                        String[] listaSimbolos = line.split(",");
                        for (String listaSimbolo : listaSimbolos) {
                            char[] simbolosEnLista = listaSimbolo.toCharArray();
                            Simbolo simbolo = new Simbolo(simbolosEnLista[0]);
                            simbolos.add(simbolo);
                        }
                        lineCount++;
                        break;
                    // Third line describes the initial state.
                    case 2:
                        estadoInicial = line;
                        lineCount++;
                        break;
                    // Fourth line describes the final states.
                    case 3:
                        String[] listaEstadosFinales = line.split(",");
                        for (String listaEstadoFinal : listaEstadosFinales) {
                            Estado estadoFinal = new Estado();
                            estadoFinal.setEstado(listaEstadoFinal);
                            estadosFinales.add(estadoFinal);
                        }
                        lineCount++;
                        break;
                    // Fifth line and up describes the transitions
                    case 4:
                        String[] descriptor = line.split("=>");
                        String[] first = descriptor[0].split(",");
                        String[] second = descriptor[1].split(",");
                        Transition transicion = new Transition();
                        // TODO reminder: For AFND-lambda, no initial states that 
                        // are a combination of two other states will be write to
                        // the initial states.
                        /*if (first.length > 2) {
                            for (int i = 0; i < first.length - 1; i++) {
                                transicion.addEstadoInicio(first[i]);
                            }
                        } else {
                            transicion.addEstadoInicio(first[0]);
                        }*/
                        transicion.addEstadoInicio(first[0]);
                        char[] symbolArray = first[first.length - 1].toCharArray();
                        simbolo = symbolArray[0];
                        transicion.setSimbolo(simbolo);
                        for (String estadoLlegada : second) {
                            transicion.addEstadoLlegada(estadoLlegada);
                        }
                        transiciones.add(transicion);
                        transicion.printTransition();
                        break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: No se encontro el archivo " + ex.getMessage());
        }
        calcularAutomataFinitoDeterministico(transiciones);
    }
    
    /**
     * cacularAutomataFinitoNoDeterministico form the AFND with lambda transitions
     * convert it to AFND with no lambda transitions
     */
    protected static void calcularAutomataFinitoNoDeterministico() {}
    
    /**
     * calcularAtuomataFinitoDeterministico from the AFND with no lambda transition
     * convert it to AFD.
     * * @param transiciones, receives a transitions list from a non-deterministic automate
     */
    protected static void calcularAutomataFinitoDeterministico(List<Transition> transiciones) {
        
        
        
    }
    
    protected static void createTransition(Transition transition, int numeroDeEstado) {
        Transition nuevaTransicion = new Transition();
        //StringBuilder sb = new StringBuilder();
        numeroDeEstado++;
        transition.getEstadosLlegada().stream().forEach((estadosLlegada) -> {
            nuevaTransicion.addEstadoInicio(estadosLlegada.getEstado());
        });
        //nuevaTransicion.addEstadoInicio((sb.append(numeroDeEstado)).toString());
        nuevaTransicion.setSimbolo(transition.getSimbolo());
        List<Estado> estadosDeLlegada = transition.getEstadosLlegada();
        for (int i = 0; i < transiciones.size(); i++) {
            for (int j = 0; j < estadosDeLlegada.size(); j++) {
                Estado estado = new Estado();
                estado = transiciones.get(i).getEstadosInicio().get(0);
                String temp1 = estado.getEstado();
                String temp2 = estadosDeLlegada.get(j).getEstado();
                System.out.println("Estado: " + temp1 + " de las transiciones contra " + temp2 + " de los estados de llegada");
                if (temp1 == temp2) {
                    nuevaTransicion.addEstadoLlegada(estado.getEstado());
                    System.out.println("Estado " + estado.getEstado() + " añadido correctamente");
                } else {
                    System.out.println(temp1 + "==" + temp2);
                }
            }
        }
        nuevaTransicion.printTransition();
    }
    
}
