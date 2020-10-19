/*
 Basado en el codigo de Cesar Aceros.
 Creado por Juan Sebastian Gomez Vera
 https://www.tutorialspoint.com/how-to-read-the-data-from-a-csv-file-in-java
 */

package PromedioCSVenVentana;
import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class PromedioCSVenVentana {
    public static final String delimiter = ",";
    public static void read(String csvFile) {
     try {
           int cantNot= 4; 
         /*Ahora abriremos el archivo y creamos el string que almacenará la
          linea */
         File file = new File(csvFile);
         FileReader fr = new FileReader(file);
         BufferedReader br = new BufferedReader(fr);
         String line;
         String[] tempArr;
         /* Creamos variables que nos servirán para almacenar las sumas y 
          acumulados del promedio, tambien arreglos para almacenar las notas */
         float sum = 0;
         int nest = 0;
         int i =0;
         float n[] = new float[cantNot+2];
         float nt[]= new float[cantNot+2];
         FileWriter Prom = new FileWriter("C:/Users/chach/OneDrive/Documentos/UNIVERSIDAD/CUARTO SEMESTRE/PROGRAMACION APLICADA II/Proyectos Java/PromedioCSVenVentana/src/promediocsvenventana/Promedio.txt");
         /* En este while leeremos linea por linea el archivo */
         while((line = br.readLine()) != null) {
             float num = 0;
             tempArr = line.split(delimiter);
             /* Ahora leeremos la primera columna que contiene notas, que 
              es la 2, y leeremos hasta la columna +1 de la cantidad de notas
              que el usuario indicó */
             for(i=2; i<=cantNot+1 ;i++) {
                 num += Float.parseFloat(tempArr[i]);
                 n[i] += Float.parseFloat(tempArr[i]);
                }
             /* Haremos operaciones para el promedio individual y lo imprimimos,
             y acumuladores para el promedio total */
             float prom = num /cantNot;  
             nest ++;
             Prom.write("Promedio del estudiante "+nest+": "+prom+"\n");       
             sum += prom;                           
            }
         /* Haremos operaciones para el promedio de cada nota y lo imprimimos,
             */
         Prom.write("\n");
         for(i=2; i<=cantNot+1 ;i++) {
             nt[i]=n[i]/nest;
             Prom.write("El promedio de la nota " +(i-1)+ " es: "+nt[i]+"\n"); 
            }
         br.close();
         Prom.close();
        }
            
         catch(IOException ioe) {
         ioe.printStackTrace();
        }
    }  
    
}
