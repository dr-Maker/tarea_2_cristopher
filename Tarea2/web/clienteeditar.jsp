<%@page import="modelos.vo.Cliente"%>
<%@page import="modelos.dao.ClienteDao"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ClienteDao dao = new ClienteDao();
    Cliente c = dao.Buscar(id);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h1>Editar cliente</h1>
                </div>
                <div class="card-body">
                    <form action="clienteupdate.jsp" method="post">
                        <p>
                            <label>Nombres</label>
                            <input required class="form-control" type="text" name="nombre" value="<%=c.getNombre()%>" />
                        </p>
                        <p>
                        <p>
                            <label>Apellidos</label>
                            <input required class="form-control" type="text" name="apellido" value="<%=c.getApellido()%>" />
                        </p>
                        <p>
                            <label>Email</label>
                            <input required class="form-control" type="text" name="email" value="<%=c.getEmail()%>" />
                        </p>
                        <p>
                            <label>Telefono</label>
                            <input required class="form-control" type="text" name="fono" value="<%=c.getFono()%>" />
                        </p>
                        <p>
                            <label>Edad</label>
                            <input required class="form-control" type="number" name="edad" value="<%=c.getEdad()%>" />
                        </p>
                        <p>
                            <label>Renta</label>
                            <input required class="form-control" type="number" name="renta" value="<%=c.getRenta()%>" />
                        </p>
                        <p>
                            <label>Estado</label>
                            <input readonly class="form-control" type="text" value="<%=c.getEstado()%>" />
                            <label>Tipo</label>
                            <input readonly class="form-control" type="text" value="<%=c.getTipocli().getTipodesc()%>" />
                        </p>
                        <p>
                            <input type="hidden" name="id" value="<%=c.getClienteid()%>" />
                            <input class="btn btn-warning" type="submit" value="Grabar" />
                        </p>
                    </form>
                    <a href="index.jsp">Volver</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
