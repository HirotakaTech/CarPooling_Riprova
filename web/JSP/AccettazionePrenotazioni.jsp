<%-- 
    Document   : Recensioni
    Created on : Mar 25, 2019, 10:18:12 PM
    Author     : Bartelloni-Bellezza-NiccolaiF
--%>

<%@page import="beans.Passeggero"%>
<%@page import="beans.Prenotazione"%>
<%@page import="dao.PrenotazioniDao"%>
<%@page import="beans.Viaggio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ViaggiDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/JSP/base/head.jsp" %>
    </head>
    <body>
        <%@include file="/JSP/base/header.jsp" %>
        <%if (session.getAttribute("utente") == null) {
                response.sendRedirect("Login.jsp");
            }%>
        <%
            boolean isAutist = false;
            boolean ok = true;
            try {
                isAutist = (Boolean) session.getAttribute("isAutista");
            } catch (Exception e) {
                ok = false;
            }
            if (isAutist && ok) {
                PrenotazioniDao dao = new PrenotazioniDao();
                ArrayList<Prenotazione> prenotazioni = dao.findAll(false,
                        (String) session.getAttribute("email"));
        %>

        <div class="span6 offset-lg-0 offset-6" style='margin-top: 8%'>
            <div class="container">
                <div class="table col-md-12">
                    <div class="row" style="margin-bottom: 20px;color: black;font-size: 15pt">
                        <div class="col-md-1">
                            Accetta
                        </div>
                        <div class="col-md-2">
                            Partenza
                        </div>

                        <div class="col-md-2">
                            Data
                        </div>
                        <div class="col-md-1">
                            Ora
                        </div>
                        <div class="col-md-2">
                            Arrivo
                        </div>
                        <div class="col-md-1">
                            Prezzo(€)
                        </div>
                        <div class="col-md-1">
                            Durata
                        </div>
                        <div class="col-md-1">
                            Info
                        </div>
                        <div class="col-md-1">
                            Passeggero
                        </div>

                    </div>
                    <%for (Prenotazione prenotazione : prenotazioni) {%>
                    <div class="row">

                        <div class="col-md-1">

                            <form action="ConfermaAccettazione.jsp" method="POST">
                                <input type="hidden" value="<%=prenotazione.getCodice()%>" name="codice"/>
                                <input type="submit" value="Accetta" name="accetta"/>
                            </form>
                        </div>
                        <%Viaggio viag = prenotazione.getViaggio();%>
                        <div class="col-md-2">
                            <%=viag.getCitta_partenza()%>
                        </div>

                        <div class="col-md-2">
                            <%=viag.getData_partenza()%>
                        </div>
                        <div class="col-md-1">
                            <%=viag.getOra_partenza()%>
                        </div>
                        <div class="col-md-2">
                            <%=viag.getCitta_destinazione()%>
                        </div>
                        <div class="col-md-1">
                            <%=viag.getPrezzo()%>
                        </div>
                        <div class="col-md-1">
                            <%=viag.getTempi_stimati()%>
                        </div>
                        <div class="col-md-1">
                            <a href="" title="<%=viag.getInfo_aggiuntive()%>">...</a>
                        </div>
                        <div class="col-md-1">
                            <a href="" title="<%=prenotazione.getEmail_passeggero()%>">...</a>
                        </div>
                    </div>
                    <%}%>
                </div>
                <%}%>

            </div>

        </div>
                <br><br> <br><br> <br><br> <br><br> <br><br> <br><br> <br><br>
        <%@include file="/JSP/base/footer.jsp" %>

    </body>
</html>
