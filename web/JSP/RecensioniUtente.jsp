<%-- 
    Document   : Ricerca
    Created on : Mar 25, 2019, 8:00:43 PM
    Author     : Bartelloni-Bellezza-NiccoaliF
--%>

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
    <body>
        <%
            FeedbackDao dao = new FeedbackDao();
            ArrayList<Feedback> lista = dao.findByEmail((String) request.getParameter("email"));

            UtentiDao utenteDao = new UtentiDao();
        %>
        <%@include file="/JSP/base/header.jsp" %>

        <h1 style="margin-top:100px; text-align: center;">Recensioni di <%Utente utente = utenteDao.findByEmail(request.getParameter("email"));%><%=utente.getNome()%> <%=utente.getCognome()%></h1>
        <% for (Feedback fed : lista) {%>
        <% utente = utenteDao.findByEmail(fed.getEmailRicevente());%>
        <div class="container my-container">
            <br>

            <div class="col-md-12 justify-content-end">
                <div class="container">
                    <div class="row justify-content-between">
                        <div class="col-md-3"><b><%=utente.getNome()%> <%=utente.getCognome()%></b></div>
                        <div class="col-md-7"><%for (int i = 0; i < fed.getVoto(); i++) {
                            %>🌟<%}
                            %>
                        </div>
                    </div>
                    <div class="row"><br><br><br><br></div>
                    <div class="row">
                        <div class="col"><%=fed.getGiudizio()%> <br><br>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>               
    <%}%>


    <%@include file="/JSP/base/ricerca.jsp" %>

</body>
</html>
