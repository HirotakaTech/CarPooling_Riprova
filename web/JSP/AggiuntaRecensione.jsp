<%-- 
    Document   : Login.jsp
    Created on : 1-apr-2019, 16.19.07
    Author     : checc_000
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/JSP/base/head.jsp" %>
    </head>
    <body>
        <%@include file="/JSP/base/header.jsp" %>
        <section class="ftco-section">
            <div class="container">
                <center><h1>Scrivi una Recensione</h1></center>
                <form action="${pageContext.request.contextPath}/JSP/ConfermaAddRecensione.jsp" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">

                            <div class="icon"><span class="ion-ios-person"></span></div>
                            <input type="text" class="form-control" placeholder="Inserisci il nome dell'utente" name="utente" required>
                        </div>
                        <div class="form-group col-md-6">
                            <div class="icon "><span class="ion-ios-star"></span></div>
                            <input type="number" class="form-control" placeholder="Inserisci il giudizio (1 - 5)" name="voto" required>
                        </div>
                    </div>


                    <div class="form-row">

                        <div class="form-group col-md-12">
                            <label for="#">Giudizio</label>
                            <div class="icon"><span class="ion-ios-book"></span></div>
                            <textarea type="text" class="form-control" placeholder="Inserisci il motivo della recensione" rows="5" name="giudizio" required></textarea>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg align-self-end">
                            <div class="form-group">
                                <div class="form-field">
                                    <input type="submit" value="Invia Recensione" class="form-control btn btn-primary">
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>

        <%@include file="/JSP/base/footer.jsp" %>
    </body>
</html>
