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
            <div class="container">
                <form action="${pageContext.request.contextPath}/JSP/ConfermaRegistrazione.jsp" method="POST">
                   <div class="row">
                        <div class="form-group">
                            <p>Autista</p>
                            <div class="form-field">
                                <span class="ion-ios-person"></span>
                                <input type="radio" class="icon" placeholder="" onclick="aggiornaAutista()" name="radiobutton" value="autista" checked required>
                            </div>
                            <p>Passeggero</p>
                            <div class="form-field">
                                <span class="ion-ios-person"></span>
                                <input type="radio" class="icon" placeholder="" onclick="aggiornaPasseggero()" name="radiobutton" value="passeggero" required>
                            </div>
                        </div>
                    </div>
                   <div class="row">
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Email</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-email"></span></div>
                                <input type="text" class="form-control col-md-6" placeholder="inserisci mail" name="email" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Nome</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-person"></span></div>
                                <input type="text" class="form-control col-md-6" placeholder="inserisci nome" name="nome" required>
                            </div>
                        </div>
                    </div>
                       </div>
            <div class="row">
            <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Cognome</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-person"></span></div>
                                <input type="text" class="form-control col-md-6" placeholder="inserisci cognome" name="cognome" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Data Nascita</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-calendar"></span></div>
                                <input type="date" class="form-control col-md-6" placeholder="inserisci data di nascita" name="data_nascita" required>
                            </div>
                        </div>
                    </div>
            </div>
            <div class="row">
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Luogo</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-location"></span></div>
                                <input type="text" class="form-control col-md-6" placeholder="inserisci luogo" name="luogo" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Telefono</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-telephone"></span></div>
                                <input type="text" class="form-control col-md-6" placeholder="inserisci numero di telefono" name="telefono" required>
                            </div>
                        </div>
                    </div>
            </div>
                    <div id="elementiSpecifici"></div>
                    
            <div class="row">
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Password</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-log-in"></span></div>
                                <input type="password" class="form-control col-md-6" placeholder="inserisci password" name="password" required>
                            </div>
                        </div>
                    </div>
            </div>
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
