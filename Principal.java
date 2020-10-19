//Basado en el codigo de Cesar Augusto Aceros y Juan Grajeda ("https://gist.github.com/jujogracu/3069454")
//Por Juan Sebastian Gomez Vera
package promediocsvenventana;

import PromedioCSVenVentana.PromedioCSVenVentana;

public class Principal {
    public static void main(String[] args) {
        //Se realiza primero la clase de Promedio, esta genera un archivo .txt y 
        // luego se lee en una ventana.
        String csvFile = "C:\\Users\\chach\\OneDrive\\Documentos\\UNIVERSIDAD\\CUARTO SEMESTRE\\PROGRAMACION APLICADA II\\Proyectos Java\\PromedioArchivoCSV\\src\\promedioarchivocsv\\PromedioCSV.csv";
        PromedioCSVenVentana.read(csvFile);
        PromedioCSVenVentana Prome = new PromedioCSVenVentana();
        Ventana v1 = new Ventana();
        v1.setVisible(true); //Hacemos visible la ventana
    }
}