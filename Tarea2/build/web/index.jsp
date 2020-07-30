
<%@page import="java.util.List"%>
<%@page import="modelos.vo.Cliente"%>
<%@page import="modelos.dao.ClienteDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Clientes</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h1>Listar Clientes</h1>
                </div>
                <div class="card-body">   
                    <p>
                        <a class="btn btn-primary" href="clientenuevo.jsp">Nuevo</a>
                    </p>
                    <table class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Email</th>
                                <th>Telefono</th>
                                <th>Edad</th>
                                <th>Renta</th>
                                <th>Estado</th>
                                <th>Tipo</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                ClienteDao dao = new ClienteDao();
                                List<Cliente> lista = dao.Listar();
                                for (Cliente item : lista) {
                                    out.print("<tr>");
                                    out.print("<td>" + item.getClienteid() + "</td>");
                                    out.print("<td>" + item.getNombre() + "</td>");
                                    out.print("<td>" + item.getApellido() + "</td>");
                                    out.print("<td>" + item.getEmail() + "</td>");
                                    out.print("<td>" + item.getFono() + "</td>");
                                    out.print("<td>" + item.getEdad() + "</td>");
                                    out.print("<td>" + item.getRenta() + "</td>");
                                    out.print("<td>" + item.getEstado().getEstadodesc() + "</td>");
                                    out.print("<td>" + item.getTipocli().getTipodesc() + "</td>");

                                    out.print("<td><a href='clienteeditar.jsp?id=" + item.getClienteid() + "'>Editar</a></td>");

                                    if (item.getEstado().getEstadoid() == 1) {
                                        out.print("<td><a href='clientestd.jsp?std=2&id=" + item.getClienteid() + "'>Dar de baja</a></td>");
                                    } else {
                                        out.print("<td><a href='clientestd.jsp?std=1&id=" + item.getClienteid() + "'>Reactivar</a></td>");
                                    }

                                    out.print("</tr>");
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
