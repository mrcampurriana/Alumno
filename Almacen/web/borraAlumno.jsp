<%-- 
    Document   : borraAlumno
    Created on : 04-may-2017, 23:44:55
    Author     : Mario
--%>

<%@page import="colegio.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="colegio.Fichero"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String nombre = request.getParameter("nombre");
        String respuesta = "";
        if(nombre!=null){
            respuesta="No se encontraron coincidencias";
            Fichero f = new Fichero("fichero.bin","rb");
            ArrayList<Alumno> alumnos = Alumno.ObjectoAAlumno(f.leerTodos());
            f.close();
            ArrayList<Alumno> alumNuevo = new ArrayList<>();
            for(Alumno alum: alumnos){
                if(!alum.getNombre().equals(nombre)){
                    alumNuevo.add(alum);
                    respuesta="Encontré al menos una coincidencia";
                }
            }
            f = new Fichero("fichero.bin","wb");
            f.escribirTodos(Alumno.AlumnoAObjeto(alumNuevo));
            f.close();
        }
    %>
    <body>
        <h1>Borrar alumno</h1>
        <form action="borraAlumno.jsp" method="POST">
            Nombre:<input type="text" name="nombre"><br>
            <input type="submit" value="Borrar">
            <input type="reset" value="Reset">
        </form>
        <%=respuesta%>
    </body>
</html>
