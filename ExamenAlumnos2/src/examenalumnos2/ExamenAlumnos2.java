/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examenalumnos2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import modelo.Alumno;
import modelo.AlumnoDAO;

/**
 *
 * @author angel
 */
public class ExamenAlumnos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        //Comprobacion de lectura de archivo. Creamos la ruta y usamos para que cada vez que lea una linea haga un printline. 
        
        //Path ruta = Paths.get("src/modelo/listadoAlumnos.txt");
        //Files.readAllLines(ruta).forEach(System.out::println);
        //Comprobacion correcta. 
        
        
        //Codigo para ver el archivo
        System.out.println("-------Lectura del archivo original-------");
        final var alumnos =AlumnoDAO.recogerTodos(); 
        alumnos.forEach(System.out::println);
        
        
        //Añadimos alumnos 
        
        alumnos.add(new Alumno("Juan Perez", 6.4, 3.4,1.9));
        alumnos.add(new Alumno("Miguel Perez", 6.4, 3.4,1.9));
        
        //Guardamos el archivo en memoria en el documento. 
        AlumnoDAO.guardarTodo(alumnos);
        
        //Recuperamos el archivo txt de nuvo. 
        final var alumnos2=AlumnoDAO.recogerTodos();
        System.out.println("-------Imprimimos el archivo QUE HEMOS GUARDADO-------");
        alumnos2.forEach(System.out::println);
    }
    
}
