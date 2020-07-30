<%@page import="modelos.dao.ClienteDao"%>
<%
    // parametros enviados desde index.jsp
    int std = Integer.parseInt(request.getParameter("std"));
    int id = Integer.parseInt(request.getParameter("id"));
    ClienteDao dao = new ClienteDao();
    dao.UpdateSTD(std, id);
    response.sendRedirect("index.jsp");
%>
