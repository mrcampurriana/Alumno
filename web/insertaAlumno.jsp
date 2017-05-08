<%-- 
    Document   : insertaAlumno
    Created on : 02-may-2017, 22:33:38
    Author     : Mario
--%>

<%@page import="colegio.Fichero"%>
<%@page import="java.io.*"%>
<%@page import="colegio.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserta Alumno</title>
    </head>
    <%
            String nombre=request.getParameter("nombre");
            String apellidos=request.getParameter("apellidos");
            int edad;
            String respuesta;
            
            
            try{
                Fichero f = new Fichero("fichero.bin","ab");
                edad= Integer.parseUnsignedInt(request.getParameter("edad"));   
                if(nombre==null 
                        || apellidos==null 
                        || request.getParameter("edad")==null)
                {
                    respuesta="Alguno de los campos quedó sin rellenar";
                }
                else{
                    f.escribirObjeto(new Alumno(nombre,apellidos,edad));
                    respuesta="Se insertó con éxito";
                    
                }
                f.close();
            }catch(NumberFormatException nfe){
                respuesta="Error en los numeros";
            }
            
            
        %>
    <body>
        <h1>Inserta alumno</h1>
        <%@include file="html/nav.html" %>
        <h2>Formulario</h2>
        <form action="insertaAlumno.jsp" method="POST">
            Nombre:<input type="text" name="nombre"><br>
            Apellidos:<input type="text" name="apellidos"><br>
            Edad:<input type="number" name="edad"><br>
            <input type="submit" value="Enviar">
            <input type="reset" value="Reset">
        </form>
        <p><%=respuesta%></p>
              
    </body>
</html>
