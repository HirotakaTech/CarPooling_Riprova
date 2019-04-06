<%-- 
    Document   : Ricerca
    Created on : Mar 25, 2019, 8:00:43 PM
    Author     : Bartelloni-Bellezza-NiccoaliF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/JSP/base/head.jsp" %>

    </head>
    <body>
        <script>
            var xhttp = new XMLHttpRequest();
            function aggiorna() {
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        aggiornaRisultato();
                    }
                };
                xhttp.open("GET", "${pageContext.request.contextPath}/JSP/AJAX/AjaxRicerca.jsp", true);
                xhttp.send();
            }
            function aggiornaRisultato() {
                document.getElementById("risultati").innerHTML = xhttp.responseText;
           
            }
        </script>
        <%@include file="/JSP/base/header.jsp" %>
        <%
            String destinazione = request.getParameter("destinazione");
            String data = request.getParameter("data");
            String ora = request.getParameter("ora");
            String prezzo = request.getParameter("prezzo");
            session.setAttribute("destinazione", destinazione);
            session.setAttribute("data", data);
            session.setAttribute("ora", ora);
            session.setAttribute("prezzo", prezzo);

        %>


        <div id="risultati">
        </div>
        <%@include file="/JSP/base/ricerca.jsp" %>
        <div class="container">

            <div class="row">
                <button type="button" style="margin-top: 100px" onclick="aggiorna()">Click Me!</button>


            </div>
        </div>
    </body>
</html>
