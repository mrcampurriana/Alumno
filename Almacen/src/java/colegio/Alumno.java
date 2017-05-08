package colegio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    
    String nombre;
    String apellidos;
    int edad;
    public Alumno(String nombre, String apellidos, int edad) {
      this.nombre = nombre;
      this.apellidos = apellidos;
      this.edad = edad;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    /**
     * Convierte un ArrayList de Object a uno de Alumno
     * @param obj ArrayList<Object> - El ArrayList a convertir
     * @return ArrayList<Alumno> - El ArrayList convertido
     */
    public static ArrayList<Alumno> ObjectoAAlumno(ArrayList<Object> obj){
        ArrayList<Alumno> listado = new ArrayList<>();
        obj.forEach((objeto) -> {
            listado.add((Alumno)objeto);
        });
        return listado;
    }
    
    public static List ObjetoAAlumno(List obj){
        List listado = new ArrayList();
        for(Object objeto: obj){
            listado.add((Alumno) objeto);
        }
        return listado;
    }
    
    public static ArrayList<Object> AlumnoAObjeto(ArrayList<Alumno> alumnos){
        ArrayList<Object> listado = new ArrayList<>();
        alumnos.forEach((alumno) -> {
            listado.add((Object)alumno);
        });
        return listado;
    }
    
    public static List AlumnoAObjeto(List<Alumno> alumnos){
        List listado = new ArrayList();
        for(Alumno alum: alumnos){
            listado.add((Object) alum);
        }
        return listado;
    }

  
}
