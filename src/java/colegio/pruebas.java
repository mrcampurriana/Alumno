/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;



/**
 *
 * @author Mario
 */
public class pruebas {
    public static void main(String args[]){
        try {
            Fichero f = new Fichero("ejemplo.bin","ab");
            Alumno alum = new Alumno("Raul","Perez",33);
            f.escribirObjeto(alum);
        } catch (AperturaFicheroExcepcion ex) {
            System.out.println("Error en la apertura");
        }
       
        Fichero f;
        try {
            f = new Fichero("ejemplo.bin","rb");
            Alumno alum = (Alumno)f.leerObjeto();
            while(alum!=null){
              
                System.out.println(alum.toString());
                //respuesta+=aux.toString();
                   
                    
                alum = (Alumno) f.leerObjeto();
            }
        }catch (AperturaFicheroExcepcion ex) {
            System.err.println(ex.getMessage());
        }    
    }
}
