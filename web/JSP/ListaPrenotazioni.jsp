<%-- 
    Document   : ListaPrenotazioni
    Created on : 16-apr-2019, 22.04.12
    Author     : Bartelloni-Bellezza-NiccolaiF
--%>

<%@page import="beans.Viaggio"%>
<%@page import="dao.ViaggiDao"%>
<%@page import="beans.Prenotazione"%>
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
                ViaggiDao dao = new ViaggiDao();
                ArrayList<Viaggio> lista = dao.findViaggiPrenotati((String) session.getAttribute("email"));
        %><h1 style="margin-top: 100px;text-align: center">Le tue Prenotazioni</h1>
        <div class="container" style="margin-top: 20px;text-decoration: underline">
            <div class="row">
                <div class="col-2">Citta di Partenza</div>
                <div class="col-2">Data di Partenza</div>
                <div class="col-2">Ora di Partenza</div>
                <div class="col-2">Citta di Destinazione</div>
                <div class="col-2">Prezzo Passeggero</div>
                <div class="col-2">Tempi Stimati</div>
            </div>
        </div>
        <%
            for (Viaggio via : lista) {%>
        <div class="container" style="margin-top: 50px; background-color: #212529">
            <div class="row" style="height: 50px">
                <div class="col-2"><%=via.getCitta_partenza()%></div>
                <div class="col-2"><%=via.getData_partenza()%></div>
                <div class="col-2"><%=via.getOra_partenza()%></div>
                <div class="col-2"><%=via.getCitta_destinazione()%></div>
                <div class="col-2"><%=via.getPrezzo()%></div>
                <div class="col-2"><%=via.getTempi_stimati()%></div>
            </div>
        </div>
        <%}%>
    </div>

    <%}%>
    <br><br> <br><br> <br><br> <br><br> <br><br> <br><br> <br><br>
    <%@include file="/JSP/base/footer.jsp" %>

</body>
</html>