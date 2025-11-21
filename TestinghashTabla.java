import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestinghashTabla{

    public static void printStringArray(String[] array){
        System.out.println("\n========== CONTENIDO DEL ARREGLO ==========");
        for (int i=0; i<array.length; i++)
            System.out.println("[" + i + "] " + array[i]);
        System.out.println("------------------------------------------\n");
    }

    public static void main(String[] args) throws IOException{
        HashTablaFiles files = new HashTablaFiles();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        String[] nombres;
        String[] nombresSorteados;

        System.out.println("--------------------------------------");
        
        System.out.println("\nEscribe el nombre del archivo a leer: ");
        fileName = bufer.readLine();
        
        nombres = files.fileToStringArray(fileName);
        System.out.println("\nArreglo Original:");
        printStringArray(nombres);
        
        nombresSorteados = files.sortStringsByTreeMap(nombres);
        printStringArray(nombresSorteados);
        
        System.out.println("Escribe el nombre del nuevo archivo para guardar resultados: ");
        fileName = bufer.readLine();
        files.escribirarrayFile(fileName, nombresSorteados);
        System.out.println("Archivo guardado correctamente.");
    }
}