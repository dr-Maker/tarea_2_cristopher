<%@page import="modelos.vo.Tipocli"%>
<%@page import="modelos.dao.TipocliDao"%>
<%@page import="modelos.dao.EstadoDao"%>
<%@page import="modelos.vo.Estado"%>
<%@page import="modelos.vo.Cliente"%>
<%@page import="modelos.dao.ClienteDao"%>
<%


    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String email = request.getParameter("email");
    String fono = request.getParameter("fono");
    int edad = Integer.parseInt(request.getParameter("edad"));
    int renta = Integer.parseInt(request.getParameter("renta"));



    Cliente obj = new Cliente(0, nombre, apellido, email, fono, edad, renta, null, null);
    ClienteDao dao = new ClienteDao();
    boolean estado = dao.Insert(obj);
    //response.sendRedirect("index.jsp");
    
    if(estado)
    {
 %>
 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Cliente</title>
        <link href="css/bootstrap.css" rel="stylesheet" />
    </head>
    <body>
        <h1> Usted es seco grabo al cliente </h1>
 <%   
    }
    else
{
%>
 <h1> Usted ee terrible penca asiq no grabo nada </h1>
<%
}
%>

</body>