import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Hashtable;

public class HashTablaFiles{

    int countFileLines(String fileName){
        File file;
        FileReader reader;
        BufferedReader bufer;
        int numLines = 0;

        try{
            file = new File("C:\\Archivos\\" + fileName);
            reader = new FileReader(file);
            bufer = new BufferedReader(reader);
            while ( (bufer.readLine()) != null ){
                numLines++;
            }
            reader.close();
        }catch( Exception e ) {
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return numLines;
    }

    public String[] fileToStringArray(String fileName){
        File file;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        String[] array = null;
        int i=0;
        int t;
        try{
            t = countFileLines(fileName);
            array = new String[t];
            file = new File("C:\\Archivos\\" + fileName);
            reader = new FileReader(file);
            bufer = new BufferedReader(reader);
            while ( (linea = bufer.readLine()) != null ){
                array[i] = linea;
                i++;
            }
            reader.close();
        } catch( Exception e){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return array;
    }

    // Ordenamiento con Hash Table optimizado usando búsqueda binaria
    public String[] sortStringsByHashTableOptimized(String[] array){
        Hashtable<String, Integer> hashTable = new Hashtable<>();
        
        for(String elemento : array){
            if(!hashTable.containsKey(elemento)){
                hashTable.put(elemento, 1);
            } else {
                hashTable.put(elemento, hashTable.get(elemento) + 1);
            }
        }
        String[] claves = hashTable.keySet().toArray(new String[0]);
        Arrays.sort(claves);
        
        // Reconstruir el array con los elementos ordenados (incluyendo duplicados)
        String[] resultado = new String[array.length];
        int indice = 0;
        
        for(String clave : claves){
            int cantidad = hashTable.get(clave);
            for(int i = 0; i < cantidad; i++){
                resultado[indice] = clave;
                indice++;
            }
        }
        
        return resultado;
    }

}