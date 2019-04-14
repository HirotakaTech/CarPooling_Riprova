<%-- 
    Document   : Recensioni
    Created on : Mar 25, 2019, 10:18:12 PM
    Author     : Fierino
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/JSP/base/head.jsp" %>

    </head>
    <style>

    </style>
    <body>
        <%@include file="/JSP/base/header.jsp" %>
        <div class="col-8" style="margin:0 auto; margin-top: 100px;">
            <center>  <h1>Aggiungi un Viaggio</h1></center>
            <form action="ConfermaAggiuntaViaggio.jsp" method="POST">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="inputEmail4">Città di Partenza</label>
                        <input type="text" class="form-control" name="citta_partenza" placeholder="Città di Partenza" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputPassword4">Data di partenza</label>
                        <input type="date" class="form-control" name="data_partenza" placeholder="data" required>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputPassword4">Ora di Partenza</label>
                        <input type="time" class="form-control" name="ora_partenza" placeholder="Ora" required> 
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-4">
                        <label for="inputAddress">Citta di Destinazione</label>
                        <input type="text" class="form-control" name="citta_destinazione" placeholder="Città di Destinazione" required>
                    </div>
                    <div class="form-group col-4">
                        <label>Prezzo</label>
                        <input type="numeric" class="form-control" name="prezzo" placeholder="Inserisci il prezzo" required>
                    </div>
                    <div class="form-group col-4">
                        <label>Tempi Stimati</label>
                        <input type="time" class="form-control" name="tempi" placeholder="Inserisci i tempi stimati" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputAddress2">Inforamzioni Aggiuntive</label>
                    <textarea type="text" class="form-control" placeholder="Inserisci le informazioni aggiuntive" name="info" rows="5" required></textarea>
                </div>

                <button type="submit" class="btn btn-primary">Aggiungi</button>
            </form>
        </div>
        <br><br><br><br><br><br><br><br>F
            <%@include file="/JSP/base/footer.jsp" %>


    </body>
</html>
