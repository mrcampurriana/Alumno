/*
 * Programa cliente del servidor
 */

import java.io.*;
import java.net.*;
/**
 * Clase para el cliente
 * @author Mario
 */
public class cliente {
    private static String HOST = "localhost";
    private final static int PUERTO = 2018;
    public static void main(String args[]) {
         
        Socket socketComunicacion;  //Para hablar con alguien
        BufferedReader entrada;
        DataOutputStream salida; //Los mensajitos
		String cadena;		
		if(args.length==2)  //java cliente 192.168.1.169 hola que pasa
		{
			HOST=args[0];
			cadena=args[1];
		}
		else if(args.length==1){	// java cliente 192.168.1.169
			cadena="No tengo nada que decir";
			HOST=args[0];			
		}
		else{
			cadena="No tengo nada que decir";
		}	
			        
		
		System.out.println("SOY EL CLIENTE");
         
        try {
            //Creamos nuestro socket
            socketComunicacion = new Socket(HOST, PUERTO);
     
            entrada = new BufferedReader(new InputStreamReader(
                        socketComunicacion.getInputStream()));
            salida = new DataOutputStream(
                     socketComunicacion.getOutputStream());
            salida.flush();
            //Enviamos un mensaje
            salida.writeUTF(cadena+"\n");
			System.out.println("aqui llego");
            String mensaje = entrada.readLine();
            System.out.println("Nos dicen: "+mensaje);
            //Cerramos la conexión
            socketComunicacion.close();
 
        } catch (UnknownHostException e) {
            System.out.println("El numero marcado no existe");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
        }
         
    }
}
