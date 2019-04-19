<%-- 
    Document   : Login.jsp
    Created on : 1-apr-2019, 16.19.07
    Author     : Bartelloni-Bellezza-NiccolaiF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/JSP/base/head.jsp" %>
        <script>
            var xhttp = new XMLHttpRequest();
            function aggiornaAutista() {
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        aggiornaRisultato();
                    }
                };
                xhttp.open("GET", "${pageContext.request.contextPath}/JSP/AJAX/AjaxRegisterAutista.jsp", true);
                xhttp.send();
            }
            function aggiornaPasseggero() {
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        aggiornaRisultato();
                    }
                };
                xhttp.open("GET", "${pageContext.request.contextPath}/JSP/AJAX/AjaxRegisterPasseggero.jsp", true);
                xhttp.send();
            }
            function aggiornaRisultato() {
                document.getElementById("elementiSpecifici").innerHTML = xhttp.responseText;
            }
            window.onload = aggiornaAutista;
        </script>
    </head>
    <body>
        <%@include file="/JSP/base/header.jsp" %>
        <section class="ftco-section">
            <h1 style="text-align: center">Registrati</h1>
            <div class="container">
                <form action="${pageContext.request.contextPath}/JSP/ConfermaRegistrazione.jsp" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <p>Autista</p>                           
                            <span class="ion-ios-person"></span>
                            <input type="radio" class="icon" placeholder="" onclick="aggiornaAutista()" name="radiobutton" value="autista" checked required>
                        </div>
                        <div class="form-group col-md-6">
                            <p>Passeggero</p>
                            <span class="ion-ios-person"></span>
                            <input type="radio" class="icon" placeholder="" onclick="aggiornaPasseggero()" name="radiobutton" value="passeggero" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="#">Email</label>
                            <div class="icon"><span class="ion-ios-email"></span></div>
                            <input type="email" class="form-control" placeholder="inserisci mail" name="email" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="#">Nome</label>
                            <input type="text" class="form-control " placeholder="inserisci nome" name="nome" minlength="3" maxlength="35" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="#">Cognome</label>
                            <input type="text" class="form-control" placeholder="inserisci cognome" name="cognome" minlength="3" maxlength="35" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="#">Data Nascita</label>
                            <input type="date" class="form-control" id="nascita" placeholder="inserisci data di nascita" name="data_nascita" min="2001-01-01" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <label for="#">Password</label>
                            <input type="password" class="form-control" placeholder="inserisci password" name="password" minlength="8" maxlength="16" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="#">Luogo di Nascita</label>
                            <input type="text" class="form-control" placeholder="inserisci luogo" name="luogo" minlength="5" maxlength="40" required>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="#">Telefono (senza prefisso)</label>
                            <input type="tel" class="form-control" pattern="[0-9]{10}" placeholder="inserisci numero di telefono" name="telefono" required>
                        </div>
                    </div>
                    <div id="elementiSpecifici"></div>
                    <div class="col-lg align-self-end">
                        <div class="form-group">
                            <div class="form-field">
                                <input type="submit" value="Registrati" class="form-control btn btn-primary">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>

        <%@include file="/JSP/base/footer.jsp" %>
    </body>
</html>
