/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import modelo.Alumno;

/**
 *
 * @author angel
 */
public class AlumnoDAO {

    //1- Crear funcion de leer datos. 
    //Importamos Path, Paths, Files, Exception, ArrayList y  creamos excepcion. 
    private static List<String> leerAlumnos() {
        try {
            //Leemos el archivo y 
            Path ruta = Paths.get("src/modelo/listadoAlumnos.txt");
            return Files.readAllLines(ruta);
        } catch (IOException ex) {
            System.out.println("Error de lectura");
            return new ArrayList<>();
        }
    }

    //2- Creamos funcion para split de informacion
    private static Alumno filaToAlumnos(String linea) {

        final String[] partes = linea.split(":"); //Dos puntos y espacio es el trigger de separar. 
//Comprobacion de que esta cogiendo. 
//System.out.println(Arrays.toString(partes));
        final String[] notas = partes[1].split(" "); // Cada vez que hay un espacio es el trigger. 

        //Ahora devolvemos el objeto Alumno. 
        return new Alumno(
                partes[0], //Nombre
                Double.parseDouble(notas[0]),
                Double.parseDouble(notas[1]),
                Double.parseDouble(notas[2])
        );
    }
    //3- Funciones de escritura
    //Convertimos alumo a linea de archivo dando el formato como el del fichero. 

    private static String conversionString(Alumno a) {
        return a.nombre() + ":" + a.notaT1() + " " + a.notaT2() + " " + a.notaT3();
    }

    //Funcion de alumno to line para todos los alumnos, con esta lista escribimos el fichero. 
    private static List<String> alumnosAString(List<Alumno> alumnos) {
        List<String> filas = new ArrayList<>();
        for (Alumno a : alumnos) {
            filas.add(conversionString(a));
        }
        return filas;
    }

    
    //4-Funcion para leer el documento. 
    public static List <Alumno> recogerTodos(){
        List<Alumno> alumnos = new ArrayList<>();
        List<String> lineas = leerAlumnos(); //Lee las lineas del archivo. 
        for (String linea :lineas ){
            alumnos.add(filaToAlumnos(linea));//Convierte cada fila de fichero a alumno y lo mete en arrayList. 
          }
        return alumnos;
     }
    
    public static boolean guardarTodo(List<Alumno>alumnos){
        try{
        List<String> filas = alumnosAString(alumnos);
        Path ruta =Paths.get ("src/modelo/listadoAlumnos.txt");
        Files.write(ruta, filas, StandardCharsets.UTF_8);
        return true;
        }catch(IOException ex){
            System.out.println(ex);
            return false; 
        }
        
    }
}
