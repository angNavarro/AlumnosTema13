/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author angel
 */
public record Alumno (String nombre, double notaT1, double notaT2, double notaT3){
    //Creamos la clase alumno, el toString es solo para dar formato como en el printf.
    public String toString(){
        return String.format("%s: %.2f %.2f %.2f - %.2f", nombre, notaT1,notaT2,notaT3, (notaT1+notaT2+notaT3)/3);
    }
}
