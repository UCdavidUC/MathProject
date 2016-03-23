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
    protected static List<Transition> afnd = new ArrayList<>();
    protected static List<Transition> afd = new ArrayList<>();
    protected static char simbolo = ' ';
    protected static int numeroDeEstado = 0;
    
    public static void main(String[] args) throws IOException {
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
                            Estado estado = new Estado();
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
                            Simbolo symbol = new Simbolo(simbolosEnLista[0]);
                            simbolos.add(symbol);
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
        
        calcularAutomataFinitoNoDeterministico(transiciones, simbolos);
    }
    
    /**
     * Method: cacularAutomataFinitoNoDeterministico form the AFND with lambda transitions
     * convert it to AFND with no lambda transitions
     * @param transiciones, list of transitions from the original lambda non deterministic automate
     * @param simbolos
     */
    protected static void calcularAutomataFinitoNoDeterministico(List<Transition> transiciones, List<Simbolo> simbolos) {
        if (lambdaTransition(simbolos) == false) {
            calcularAutomataFinitoDeterministico(transiciones);
        } else {
            // Local variables for new transitions generation
            printAutomate("Autómata Finito No Determinístico");
        }
        
    }
    
    /**
     * Method: calcularAtuomataFinitoDeterministico from the AFND with no lambda transition
     * convert it to AFD.
     * @param transiciones, receives a transitions list from a non-deterministic automate
     */
    protected static void calcularAutomataFinitoDeterministico(List<Transition> transiciones) {
        // Calculo de la cerradura lambda.
        for (int i = 0; i < transiciones.size(); i++) {
            if (transiciones.get(i).getEstadosLlegada().size() > 1) {
                System.out.println("Calculando afd");
                createTransition(transiciones.get(i));
            }
        }
        printAutomate("Autómata Finito Determinístico");
    }
    
    /**
     * Method: createTransition, this method creates new transitions based on the transition received
     * @param transition
     * @return added
     */
    protected static boolean createTransition(Transition transition) {
        Transition nuevaTransicion = new Transition();
        boolean added = false;
        List<Estado> entradas = transition.getEstadosLlegada();
        List<Estado> llegadas = new ArrayList<>();
        // Creates new initial state with the arrivings of the transition received.
        for (int i = 0; i < entradas.size(); i++) {
            String entrada = entradas.get(i).getEstado();
            nuevaTransicion.addEstadoInicio(entrada);
        }
        // Applies the algorithm for arriving states from a set of initial states.
        if (stateExists(entradas) == true) {
            
        }
        transiciones.add(nuevaTransicion);
        return added;
    }
        
    /**
    * Method: lambdaTransition determines based on the list of registered symbols if it is a lambda transitions automate.
    * @param simbolos
    * @return isAfndl
    */
    protected static boolean lambdaTransition(List<Simbolo> simbolos) {
        boolean isAfndl = false;
        for (int i = 0; i < simbolos.size(); i++) {
            if (simbolos.get(i).getSimbolo() == 'l' && isAfndl == false) {
                isAfndl = true;
                System.out.println("Es afnd lambda " + simbolos.get(i).getSimbolo());
            }
        }
        return isAfndl;
    }
    
    /**
     * Method: exists, tells if a state is already defined, if it is then it will overwrite or skip it
     * @param estados
     * @return exists
     */
    protected static boolean stateExists(List<Estado> estados) {
        boolean exists = false;
        if (estados.size() > 0) {
            for (int j = 0; j < transiciones.size(); j++) {
                if (estados.toArray() == transiciones.get(j).getEstadosInicio().toArray()) {
                    exists = true;
                    System.out.println("El estado existe!");
                    return exists;
                }
            }
        }
        return exists;
    }
    
    /**
     * Method: stateGetter
     * @param estados
     * @param simbolo
     * @return arrivals
     */
    protected static List<Estado> stateGetter(List<Estado> estados, char simbolo) {
        List<Estado> arrivals = new ArrayList<>();
        for (int i = 0; i < estados.size(); i++) {
            for (int j = 0; j < transiciones.size(); j++) {
                List<Estado> inicio = transiciones.get(j).getEstadosInicio();
                char symbol = transiciones.get(j).getSimbolo();
                for (int k = 0; k < inicio.size(); k++){
                    if (estados.get(i) == inicio.get(k) && simbolo == symbol) {
                        
                    }
                }
            }
        }
        return arrivals;
    }
    
    /**
     * Method: printAutomate, print automate table
     * @param title
     */
    protected static void printAutomate(String title) {
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
            while (sb.length() < max + 1) {
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
    
}
