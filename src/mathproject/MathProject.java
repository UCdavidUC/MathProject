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
    protected static char simbolo;
    
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
                        transicion.setEstado(first[0]);
                        char[] simbolArray = first[1].toCharArray();
                        simbolo = simbolArray[0];
                        transicion.setSimbolo(simbolo);
                        //System.out.println(transicion);
                        break;
                }
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: No se encontro el archivo " + ex.getMessage());
        }
    }
    
}
