/*
 * Programa para crear un servidor
 */

import java.io.*;
import java.net.*;
import java.time.*;

/**
 * Clase servidor para montarse un pequeño escuchante.
 * @author Mario
 */
public class servidor {
    private final static int PUERTO=2018;
    public static void main(String args[]){
        BufferedReader entrada;
        DataOutputStream salida;
        
        Socket socketComunicacion;
        ServerSocket socketEscuchante;
        
        System.out.println("SOY EL SERVIDOR");
        
        try{
            socketEscuchante = new ServerSocket(PUERTO);
            System.out.println("Esperando un cliente...");
			while(true){            
				socketComunicacion = socketEscuchante.accept();
	            System.out.println("Alguien llamó...");
            
    	        // Establecemos los canales de entrada y salida
            
    	        entrada = new BufferedReader(new InputStreamReader(
    	                    socketComunicacion.getInputStream()));
    	        salida = new DataOutputStream(
    	                   socketComunicacion.getOutputStream());
            
          		  // Chachi ya hemos establecido los canales de comunicacion
            
          		System.out.println(" Conectado con: "
                    + socketComunicacion.getInetAddress());
           		salida.flush();
	            String mensaje = entrada.readLine();
    	        System.out.println(socketComunicacion.getInetAddress()
    	                +" dice: "+mensaje);
            	
				String mensajeSalida="Comando u orden incorrecta";
				if(mensaje.endsWith("SKYNET")){
					mensajeSalida="Mañana destruiré el mundo";
				}else if(mensaje.endsWith("DATE")){
					mensajeSalida=LocalDate.now().toString();
				}else if(mensaje.endsWith("NOMBRE")){
					mensajeSalida="Yo soy yo";
				}
				
				System.out.println("Mensaje de respuesta:"+mensajeSalida);
		        salida.writeUTF(mensajeSalida+"\n");

				
		        
		        System.out.println("Confirmando al cliente");
		        //Cuelga tu, no tu, no tu
		        System.out.println("Cerrando la conexión...");
				entrada.close();
				salida.close();
				socketComunicacion.close();
			}		
			//socketEscuchante.close();
            
        }catch(IOException io){
            System.err.println("Error en la comunicacion "+io.getMessage());
			//socketEscuchante.close();
        }
    }

}   
    
