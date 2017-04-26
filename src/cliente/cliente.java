/*
 * Programa cliente del servidor
 */
package cliente;
import java.io.*;
import java.net.*;
/**
 * Clase para el cliente
 * @author Mario
 */
public class cliente {
    private final static String HOST = "localhost";
    private final static int PUERTO = 2018;
    public static void main(String args[]) {
         
        Socket socketComunicacion;  //Para hablar con alguien
        BufferedReader entrada;
        DataOutputStream salida; //Los mensajitos
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
            salida.writeUTF("¿Hay alguien?\n");
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
