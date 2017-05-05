<%-- 
    Document   : listaAlumno
    Created on : 02-may-2017, 23:16:50
    Author     : Mario
--%>

<%@page import="java.io.EOFException"%>
<%@page import="colegio.Alumno"%>
<%@page import="java.io.*"%>
<%@page import="colegio.Fichero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista alumno</title>
    </head>
    <body>
        <h1>Lista alumno</h1>
        <%@include file="html/nav.html" %>
        <table>
            <tr>
                <th>Nombre</th>
                <th>Apellidos</th>
                <th>Edad</th>
            </tr>
        <%
            ObjectInputStream ois;
            String respuesta="";
            
           
                Fichero f = new Fichero("fichero.bin","rb");
                Alumno aux = (Alumno) f.leerObjeto();
                while(aux!=null){
                    
                    respuesta+="<tr>\n"
                            + "<td>"+aux.getNombre()+"</td>\n"
                            + "<td>"+aux.getApellidos()+"<td>\n"
                            + "<td>"+aux.getEdad()+"</td>\n"
                            + "</tr>\n";
                    //respuesta+=aux.toString();
                   
                    
                    aux = (Alumno) f.leerObjeto();
                }
            
            f.close();
        %>
        <%=respuesta%>
       </table>
        
    </body>
</html>
