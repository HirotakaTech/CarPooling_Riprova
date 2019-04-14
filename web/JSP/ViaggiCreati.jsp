<%-- 
    Document   : ViaggiCreati
    Created on : 14-apr-2019, 19.34.33
    Author : hirotaka
  citta_partenza     
| data_partenza     
| ora_partenza       
| citta_destinazione 
| prezzo_passeggero 
| tempi_stimati     
| info_aggiuntive  
--%>

<%@page import="beans.Utente"%>
<%@page import="beans.Viaggio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ViaggioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/JSP/base/head.jsp" %>
    </head>
    <body>
        <%
            String email = (String) session.getAttribute("email");
            ArrayList<Viaggio> lista = null;
            ViaggioDao dao = new ViaggioDao();
            lista = dao.findByEmail(email);

        %>
        <%@include file="/JSP/base/header.jsp" %>
        <div class="container" style="margin-top: 100px;">
            <div class="row">
                <div class="col-2">Citta di Partenza</div>
                <div class="col-2">Data di Partenza</div>
                <div class="col-2">Ora di Partenza</div>
                <div class="col-2">Citta di Destinazione</div>
                <div class="col-2">Prezzo Passeggero</div>
                <div class="col-2">Tempi Stimati</div>
            </div>
        </div>
        <%for (Viaggio via : lista) {%>
        <div class="container" style="margin-top: 100px;">
            <div class="row">
                <div class="col-2"><%=via.getCitta_partenza() %></div>
                <div class="col-2"><%=via.getData_partenza() %></div>
                <div class="col-2"><%=via.getOra_partenza() %></div>
                <div class="col-2"><%=via.getCitta_destinazione() %></div>
                <div class="col-2"><%=via.getPrezzo() %></div>
                <div class="col-2"><%=via.getTempi_stimati() %></div>
            </div>
        </div>
        
        <%}%>

    </body>
</html>
