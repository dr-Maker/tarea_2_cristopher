
<%@page import="modelos.vo.Tipocli"%>
<%@page import="java.util.List"%>
<%@page import="modelos.vo.Estado"%>
<%@page import="modelos.dao.TipocliDao"%>
<%@page import="modelos.dao.EstadoDao"%>
<%
    EstadoDao daoe = new EstadoDao();
    List<Estado> listae = daoe.Listar();
    TipocliDao daot = new TipocliDao();
    List<Tipocli> listat = daot.Listar();
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
        <div class="container">
            <div class="card">
                <div class="card-header">
                    <h1>Nuevo Cliente</h1>
                </div>
                <div class="card-body">
                    <form id="frm" name="frm" action="clienteinsert.jsp" method="post">
                        <p>
                            <label>Nombres</label>
                            <input required class="form-control" type="text" name="nombre" value="" />
                        </p>
                        <p>
                            <label>Apellidos </label>
                            <input required class="form-control" type="text" name="apellido" value="" />
                        </p>
                        <p>
                            <label>Email</label>
                            <input required class="form-control" type="text" name="email" value="" />
                        </p>
                        <p>
                            <label>Telefono</label>
                            <input required class="form-control" type="text" name="fono" value="" />
                        </p>
                        <p>
                            <label>Edad</label>
                            <input required class="form-control" type="number" name="edad" value="" />
                        </p>
                        <p>
                            <label>Renta</label>
                            <input required class="form-control" type="number" name="renta" value="" />
                        </p>
                        <p>
                            <label>Estado</label>
                            <select required class="form-control" name="estadoid">
                                <option value="">Seleccionar...</option>
                                <%
                                    for (Estado item : listae) {
                                        out.print("<option value='" + item.getEstadoid() + "'>" + item.getEstadodesc() + "</option>");
                                    }
                                %>
                            </select>
                        </p>
                        <p>
                            <label>Tipo</label>
                            <select required class="form-control" name="tipoid">
                                <option value="">Seleccionar...</option>
                                <%
                                    for (Tipocli item : listat) {
                                        out.print("<option value='" + item.getTipoid() + "'>" + item.getTipodesc() + "</option>");
                                    }
                                %>
                            </select>
                        </p>
                        <p>
                            <input class="btn btn-primary" type="submit" value="Grabar" />
                        </p>
                    </form>
                    <a href="index.jsp">Volver</a>
                </div>
            </div>
        </div>
    </body>
</html>
