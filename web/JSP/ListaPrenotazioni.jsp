<%-- 
    Document   : ListaPrenotazioni
    Created on : 16-apr-2019, 22.04.12
    Author     : hirotaka
--%>

<%@page import="beans.Viaggio"%>
<%@page import="dao.ViaggioDao"%>
<%@page import="beans.Prenotazione"%>
<%@page import="dao.PrenotazioneDao"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/JSP/base/head.jsp"%>
    </head>
    <body>
        <%@include file="/JSP/base/header.jsp" %>
        <%
            boolean isAutist = false;
            boolean ok = true;
            try {
                isAutist = (Boolean) session.getAttribute("isAutista");
            } catch (Exception e) {
                ok = false;
            }
            if (!isAutist && ok) {
                ViaggioDao dao = new ViaggioDao();
                ArrayList<Viaggio> lista = dao.findViaggiPrenotati((String) session.getAttribute("email"));
                for (Viaggio viag : lista) {%>
        <div class="container" style="margin-top: 100px; text-align: center;">
            <div class="row">
                <div class="col-md-2">
                    <%=viag.getCitta_partenza()%>
                </div>

                <div class="col-md-2">
                    <%=viag.getData_partenza()%>
                </div>
                <div class="col-md-2">
                    <%=viag.getOra_partenza()%>
                </div>
                <div class="col-md-2">
                    <%=viag.getCitta_destinazione()%>
                </div>
                <div class="col-md-2">
                    <%=viag.getPrezzo()%>
                </div>
                <div class="col-md-2">
                    <%=viag.getTempi_stimati()%>
                </div>
                <div class="col-md-2">
                    <a href="" title="<%=viag.getInfo_aggiuntive()%>">...</a>
                </div>

            </div>
            <%}%>
        </div>

        <%}%>


    </body>
</html>