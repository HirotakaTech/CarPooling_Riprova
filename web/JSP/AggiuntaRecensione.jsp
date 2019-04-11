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
                <form action="${pageContext.request.contextPath}/JSP/ConfermaAddRecensione.jsp" method="POST">
                    <div class="row">
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Nome passeggero/autista</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-person"></span></div>
                                <input type="text" class="form-control col-md-6" placeholder="inserisci nome" name="utente" required>
                            </div>
                        </div>
                    </div>
                    </div>
                    <div class="row">
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Voto</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-person"></span></div>
                                <input type="number" class="form-control col-md-6" placeholder="inserisci nome" name="utente" required>
                            </div>
                        </div>
                    </div>
                    </div>
                    
                    <div class="row">
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Giudizio</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-person"></span></div>
                                <input type="text" class="form-control col-md-6" placeholder="inserisci giudizio" name="giudizio" required>
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
