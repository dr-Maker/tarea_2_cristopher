<%@page import="modelos.vo.Cliente"%>
<%@page import="modelos.dao.ClienteDao"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    String email = request.getParameter("email");
    String fono = request.getParameter("fono");
    int edad = Integer.parseInt(request.getParameter("edad"));
    int renta = Integer.parseInt(request.getParameter("renta"));
    Cliente obj = new Cliente(id, nombre, apellido, email, fono, edad, renta, null, null);
    ClienteDao dao = new ClienteDao();
    dao.Update(obj);
    response.sendRedirect("index.jsp");
%>
