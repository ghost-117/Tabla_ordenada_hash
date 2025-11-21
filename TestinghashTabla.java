import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestinghashTabla{

    public static void printStringArray(String[] array){
        System.out.println("\n========== CONTENIDO DEL ARREGLO ==========");
        // Se añade una comprobación básica por si el arreglo es null (ej. si falla la lectura del archivo)
        if (array == null) {
            System.out.println("El arreglo es nulo o está vacío.");
            System.out.println("---------------------------------\n");
            return;
        }

        for (int i=0; i<array.length; i++)
            System.out.println("[" + i + "] " + array[i]);
        System.out.println("==========================================\n");
    }

    public static void main(String[] args) throws IOException{
        // CORRECCIÓN 1: El nombre de la clase es 'HashTablaFiles' y no 'HashTableFiles_v1_1'
        HashTablaFiles files = new HashTablaFiles();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String[] nombres;
        String[] nombresSorteados;

        System.out.println("\nEscribe el nombre del archivo a leer (ej. nombres.txt): ");
        fileName = bufer.readLine();
        
        nombres = files.fileToStringArray(fileName);
        
        if (nombres != null) { // Se comprueba si la lectura fue exitosa
            System.out.println("\nArreglo Original:");
            printStringArray(nombres);
            nombresSorteados = files.sortStringsByTreeMap(nombres); 
            System.out.println("Arreglo Ordenado (Alfabéticamente):");
            printStringArray(nombresSorteados);
            
            System.out.println("Escribe el nombre del nuevo archivo para guardar resultados (ej. resultado.txt): ");
            fileName = bufer.readLine();

            files.escribirarrayFile(fileName, nombresSorteados); 
            System.out.println("Archivo guardado correctamente.");
        } else {
            System.out.println("\nNo se pudo procesar el archivo. Finalizando el programa.");
        }
    }
}