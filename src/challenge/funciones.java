/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenge;
import java.io.IOException;
import java.io.FileWriter;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author castr
 */
public class funciones {
    int numerosAl=0;
    ordenamientos ord = new ordenamientos();
    //Funciones
    //---------
    //numero 1
    //---------
    public void crearArchivo(String nomArchivo) throws IOException
    {
        Scanner sn = new Scanner(System.in);
        FileWriter fichero = new FileWriter ("../"+nomArchivo+".txt");//LINUX
        //FileWriter fichero = new FileWriter ("C:/Users/castr/Documents/"+nomArchivo+".txt");//Hay que cambiar esta ruta para hacer funcionar en otra pc
        //FileWriter fichero = new FileWriter ("C:/Users/"+nomArchivo+".txt");//Esta ruta deberia funcionar en cualquierpc pero hay que iniciar netbenas como admin
        //-----------------------------------------------------------
        //solucionar problema de que esta ruta funciona solo en mi pc
        //-----------------------------------------------------------
        if(nomArchivo=="archivo")
        {
            System.out.println("Cuantos numeros desea ingresar: ");
            int cantNum = sn.nextInt();
            while(numerosAl<cantNum)
            {
                Random numAlea = new Random();
                String insertarNum = Integer.toString(numAlea.nextInt());
                fichero.write(insertarNum+"\n");
                numerosAl++;
            }

        numerosAl=0;
        System.out.println("Archivo creado exitosamente");
        fichero.close();
        }
    }
    //---------
    //numero 2
    //---------
    public void leerArchivo(String nombreArchivo)
    {
        File archivo;
        FileReader fr;
        BufferedReader br;
        
        try 
        {
            archivo = new File(nombreArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null)
            {
                System.out.println(linea);
            }
            br.close();
            fr.close();
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Hubo un error leyendo el archivo "+e);
        }    
    }
    //---------
    //numero 3
    //---------
    public void ordenarArchivo(String nombreArchivo)
    {
        File archivo;
        FileReader fr;
        BufferedReader br;
        
        String muestras[];
        List <String> al = new ArrayList<String>();
        String arrDesordenado[];
        
        try 
        {
            archivo = new File("../archivo.txt");//LINUX
            //archivo = new File("C:/Users/castr/Documents/archivo.txt");//Hay que cambiar esta ruta para hacer funcionar en otra pc
            //archivo = new File("C:/Users/archivo.txt");//Esta ruta deberia funcionar en cualquierpc pero hay que iniciar netbenas como admin
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int recArreglo=0;
            while((linea=br.readLine())!=null)
            {
                al.add(linea);//guardo cada linea en una lista 
            }
            
            arrDesordenado = al.toArray(new String[al.size()]);// convierto a array la lista 
            
            //Arrays.sort(arrDesordenado);//metodo para ordenar la lista, puede variar entre los distintos tipos de sort pero no le veo el sentido 
            //Arrays.parallelSort(arrDesordenado);
            //ord.bubbleSort((arrDesordenado));
            //ord.HeapSort((arrDesordenado));
            //int prueba = arrDesordenado.length;
            //ord.quickSort((arrDesordenado),0,prueba - 1);
            elegirMetodo(arrDesordenado);
            crearArchivo("archivoNuevo");
            File archivo2;
            FileWriter escribir;
            PrintWriter linea2;
            archivo2 = new File("../archivoNuevo.txt");//LINUX
            //archivo2 = new File("C:/Users/castr/Documents/archivoNuevo.txt");//Hay que cambiar esta ruta para hacer funcionar en otra pc
            //archivo2 = new File("C:/Users/archivoNuevo.txt");//Esta ruta deberia funcionar en cualquierpc pero hay que iniciar netbenas como admin
            while(recArreglo<arrDesordenado.length)//recorro el arreglo 
            {
                escribir = new FileWriter(archivo2,true);
                linea2 = new PrintWriter(escribir);
                linea2.println(arrDesordenado[recArreglo]);
                recArreglo++;
                linea2.close();
            }
            br.close();
            fr.close();
            System.out.println(" ");
            System.out.println("Archivo ordenado exitosamente");
            System.out.println(" ");
        } catch (Exception e) {
        }
    }
    //---------
    //numero 5
    //---------
    public void buscarNumero(int numero)
    {
        File archivo;
        FileReader fr;
        BufferedReader br;
        String muestras[];
        List <String> al = new ArrayList<String>();
        String buscarArr[];
        boolean contiene=false;
        int posicion=0;
        int posicionF=0;
        try {
            archivo = new File ("../archivoNuevo.txt");//LINUX
            //archivo = new File("C:/Users/castr/Documents/archivoNuevo.txt");//Hay que cambiar esta ruta para hacer funcionar en otra pc
            //archivo = new File("C:/Users/archivoNuevo.txt");//Esta ruta deberia funcionar en cualquierpc pero hay que iniciar netbenas como admin
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            while((linea=br.readLine())!=null)
            {
                posicion++;
                al.add(linea);
                System.out.println(linea+" = "+numero);
                if(linea.equals(Integer.toString(numero)))
                {
                    contiene=true;
                    posicionF=posicion;
                } 
                
            } 
            
            if(contiene)
            {
                System.out.println("El archivo contiene el numero "+ numero +" en la posicion "+posicionF);
            }
            else
            {
                System.out.println("El archivo no contiene el numero");
            }
        } catch (Exception e) {
        }
    }
    
    public void elegirMetodo(String[] arr)
    {
        System.out.println("Elija el metodo de ordenamiento");
        Scanner sca = new Scanner(System.in);
        int opc;
        boolean sal = false;

        System.out.println(" ");
        System.out.println("*----------------------*");
        System.out.println("Opciones");
        System.out.println("*----------------------*");
        System.out.println("1.SORT- ");
        System.out.println("2.PARALLELSORT- ");
        System.out.println("3.BUBBLESORT- ");
        System.out.println("4.HEAPSORT- ");
        System.out.println("5.QUICKSORT- ");
        System.out.println("Introduce un numero: ");
        opc = sca.nextInt();
        switch(opc)
        {
            case 1:
                Arrays.sort(arr);
                break;
            case 2:
                Arrays.parallelSort(arr);
                break;
            case 3:
                ord.bubbleSort(arr);
                break;
            case 4:
                ord.HeapSort(arr);
                break;
            case 5:
                int prueba = arr.length;
                ord.quickSort(arr, 0, prueba-1);
                break;
        }
        
    }
}



