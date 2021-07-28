/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author castr
 */
public class Challenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Scanner sn = new Scanner(System.in);
        funciones fn = new funciones();
        
        
        
        boolean salir = false;
        int opcion;
        int opcion2;
        
        while(!salir)
        {
            System.out.println(" ");
            System.out.println("*----------------------*");
            System.out.println("Opciones");
            System.out.println("*----------------------*");
            System.out.println("1.- Genera un nuevo archivo");
            System.out.println("2.- Lee un archivo generado");
            System.out.println("3.- Ordena archivo");
            System.out.println("4.- Lee archivo ordenado");
            System.out.println("5.- buscar numero en archivo");
            System.out.println("6.- Salir");
            System.out.println("Introduce un numero: ");
            opcion = sn.nextInt();
            switch(opcion)
            {
                case 1:
                    fn.crearArchivo("archivo");
                    break;
                case 2:
                    //fn.leerArchivo("C:/Users/castr/Documents/archivo.txt");
                    fn.leerArchivo("../archivo.txt");//LINUX
                    break;
                case 3:
                    //fn.ordenarArchivo("C:/Users/castr/Documents/archivo.txt");
                    fn.ordenarArchivo("../archivoNuevo.txt");//LINUX
                    break;
                case 4:
                    //fn.leerArchivo("C:/Users/castr/Documents/archivoNuevo.txt");
                    fn.leerArchivo("../archivoNuevo.txt");//LINUX
                    break;
                case 5:
                    System.out.println("Introduce un numero para buscar en el archivo: ");
                    opcion2 = sn.nextInt();
                    fn.buscarNumero(opcion2);
                    break;
                case 6:
                    salir=true;
                    break;
            }
        }
        
        
    }
    
}
