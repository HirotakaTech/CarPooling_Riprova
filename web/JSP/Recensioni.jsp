<%-- 
    Document   : Recensioni
    Created on : Mar 25, 2019, 10:18:12 PM
    Author     : Fierino
--%>

<%@page import="beans.Utente"%>
<%@page import="dao.UtenteDao"%>
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
            ArrayList<Feedback> lista = dao.findAll();
            for (Feedback ciao : lista) {
                System.out.println(ciao.getEmailRicevente());
            }
            UtenteDao utenteDao = new UtenteDao();
            Utente ute=utenteDao.findByEmail("bellezza.francesco@studenti-ittfedifermi.gov.it");
            ute.getEmail();
            
        %>
        <%@include file="/JSP/base/header.jsp" %>
        <div class="container my-container">

            <div class="row">
                <div class="col-md-4">
                    <br>
                    <img class="img-fluid rounded" src="https://www.abc.net.au/news/image/8314104-1x1-940x940.jpg" alt="Smiley face">

                </div>
                <div class="col-md-8 justify-content-end">
                    <div class="container">
                        <div class="row justify-content-between">
                            <div class="col-md-3"><b>Banana suus</b></div>
                            <div class="col-md-7">🌟🌟🌟🌟🌟</div>
                        </div>
                        <div class="row"><br></div>
                        <div class="row">
                            <div class="col">Francesco Sforza (Cigoli, 23 luglio 1401 – Milano, 8 marzo 1466) è stato il primo duca di Milano appartenente alla dinastia degli Sforza.

                                Valente condottiero di compagnia di ventura, per anni Francesco Sforza combatté al servizio dei vari principati italiani, dal Regno di Napoli allo Stato della Chiesa, per giungere infine alla corte del duca di Milano Filippo Maria Visconti. Nel ventennale servizio presso quest'ultimo, lo Sforza dovette destreggiarsi tra gli intrighi organizzati dal duca medesimo, invidioso e sospettoso della popolarità e delle abilità militari del suo capitano di ventura.

                                Nel 1441, Francesco giunse a sposare la figlia del duca, Bianca Maria, divenendo de facto il successore del potentato milanese. Tuttavia, alla morte di Filippo Maria avvenuta nel 1447, Milano insorse proclamando la Repubblica, destinata a indebolirsi progressivamente a causa dell'influenza politica e militare che lo Sforza stesso riuscì a esercitare sul popolo meneghino.</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <% for (Feedback fed : lista) {%>
        <div class="container my-container">
            <div class="row">
                <div class="col-md-4">
                    <br>
                    <img class="img-fluid rounded" src="https://www.abc.net.au/news/image/8314104-1x1-940x940.jpg" alt="Smiley face">

                </div>
                <div class="col-md-8 justify-content-end">
                    <div class="container">
                        <div class="row justify-content-between">
                            <div class="col-md-3"><b><%Utente utente = utenteDao.findByEmail(fed.getEmailMandante());%>
                                    <%=utente.getNome()%></b></div>

                            <div class="col-md-7"><%=fed.getVoto()%></div>
                        </div
                        <div class="row"><br></div>
                        <div class="row">
                            <div class="col"><%=fed.getGiudizio()%></div>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>





    </body>
</html>
