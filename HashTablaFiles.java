import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.TreeMap;

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

    public String[] sortStringsByTreeMap(String[] array){
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        

        for(String elemento : array){
            if(treeMap.containsKey(elemento)){
                treeMap.put(elemento, treeMap.get(elemento) + 1);
            } else {
                treeMap.put(elemento, 1);
            }
        }

        String[] resultado = new String[array.length];
        int indice = 0;
        
        for(String clave : treeMap.keySet()){
            int cantidad = treeMap.get(clave);
            for(int i = 0; i < cantidad; i++){
                resultado[indice] = clave;
                indice++;
            }
        }
        
        return resultado;
    }

    public void escribirarrayFile(String fileName, String[] array){
        FileWriter file;
        PrintWriter writer;
        try{
            file = new FileWriter("c:\\Archivos\\" + fileName);
            writer = new PrintWriter(file);
            for(String unDato : array)
                writer.println(unDato);
            file.close();
        } catch ( Exception e) {
            System.out.println("Error al crear el archivo: " + e.toString());
        }
    }
}