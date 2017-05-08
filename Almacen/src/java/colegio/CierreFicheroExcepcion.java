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
public class CierreFicheroExcepcion extends Exception{
    public CierreFicheroExcepcion(String mensaje){
        super(mensaje);
    }
}