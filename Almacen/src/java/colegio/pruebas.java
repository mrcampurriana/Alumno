/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;

import java.util.ArrayList;



/**
 *
 * @author Mario
 */
public class pruebas {
    public static void main(String args[]){
        try {
            Fichero f = new Fichero("ejemplo.bin","ab");
            ArrayList<Alumno> alumnos=new ArrayList<>();
            alumnos.add(new Alumno("Raul","Perez",33));
            alumnos.add(new Alumno("Raul","Lopez",34));
            alumnos.add(new Alumno("Raul","Ramirez",35));
            alumnos.add(new Alumno("Raul","Sanchez",36));
            ArrayList<Object> objetos = Alumno.AlumnoAObjeto(alumnos);
            f.escribirTodos(objetos);
        } catch (AperturaFicheroExcepcion ex) {
            System.out.println("Error en la apertura");
        }
       
        Fichero f;
        try {
            f = new Fichero("ejemplo.bin","rb");
            ArrayList<Alumno> alumnos = Alumno.ObjectoAAlumno(f.leerTodos());
            for(Alumno alum : alumnos){
                System.out.println(alum.toString());
            }
        }catch (AperturaFicheroExcepcion ex) {
            System.err.println(ex.getMessage());
        }    
    }
}
