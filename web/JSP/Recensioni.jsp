<%-- 
    Document   : Recensioni
    Created on : Mar 25, 2019, 10:18:12 PM
    Author     : Bartelloni-Bellezza-NiccolaiF
--%>

<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.UtentiDao"%>
<%@page import="beans.Feedback"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.FeedbackDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/JSP/base/head.jsp" %>

    </head>
    <style>
        .my-container{
            background-color: #232931;
            margin-top: 100px;

            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            text-align: center;
        }
    </style>

    <%
        FeedbackDao dao = new FeedbackDao();
        ArrayList<Feedback> lista = dao.findVotiPerAutisti();

        UtentiDao utenteDao = new UtentiDao();
    %>
    <%@include file="/JSP/base/header.jsp" %>

    <center><h1 style="margin-top: 110px">Media delle Recensioni dei Nostri Utenti</h1></center>
    <br>
    <center><button class="btn btn-primary"><a href="${pageContext.request.contextPath}/JSP/AggiuntaRecensione.jsp" style="text-decoration: none;color: white">Aggiungi una recensione</a></button></center>

    <% for (Feedback fed : lista) {%>
    <%Utente utente = utenteDao.findByEmail(fed.getEmailRicevente());%>
    <div class="container my-container">
        <br>
        <div class="row">

            <div class="col-md-12 justify-content-end">
                <div class="container">
                    <div class="row justify-content-between">
                        <div class="col-md-3"><b><%=utente.getNome()%> <%=utente.getCognome()%> </b>
                        </div>

                        <div class="col-md-7"><%for (int i = 0; i < fed.getVoto(); i++) {
                            %>🌟<%}
                            %></div>
                        <div class="col-md-2"><a href="${pageContext.request.contextPath}/JSP/RecensioniUtente.jsp?email=<%=fed.getEmailMandante()%>">Guarda Tutte le Recensioni</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%}
        lista = dao.findVotiPerPasseggeri();
    %>

    <% for (Feedback fed : lista) {%>
    <%Utente utente = utenteDao.findByEmail(fed.getEmailRicevente());%>
    <div class="container my-container">
        <br>
        <div class="row">

            <div class="col-md-12 justify-content-end">
                <div class="container">
                    <div class="row justify-content-between">
                        <div class="col-md-3"><b><%=utente.getNome()%> <%=utente.getCognome()%> </b>
                        </div>

                        <div class="col-md-7"><%for (int i = 0; i < fed.getVoto(); i++) {
                            %>🌟<%}
                            %></div>
                        <div class="col-md-2"><a href="${pageContext.request.contextPath}/JSP/RecensioniUtente.jsp?email=<%=fed.getEmailRicevente()%>">Guarda Tutte le Recensioni</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%}%>
    <br><br> <br><br> <br><br> <br><br> <br><br> <br><br> <br><br>
    <%@include file="/JSP/base/footer.jsp" %>





</html>
