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

    </head>
    <body>
        <%@include file="/JSP/base/header.jsp" %>
        <section class="ftco-section">

            <h1 style="text-align: center">Esegui l'accesso</h1>
            <form action="${pageContext.request.contextPath}/JSP/ConfermaLogin.jsp" method="POST">
                <div class="container">
                    <div class="form-row justify-content-between">

                        <div class="form-group col-md-6">
                            Autista
                            <span class="ion-ios-person"></span>
                            <input type="radio" class="icon" placeholder="" name="radiobutton" value="autista" checked required>
                        </div>

                        <div class="form-group col-md-6">
                            Passeggero
                            <span class="ion-ios-person"></span>
                            <input type="radio" class="icon" placeholder="" name="radiobutton" value="passeggero" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <div class="icon"><span class="ion-ios-log-in"></span></div>
                            <input type="email" class="form-control" placeholder="Email" name="email" required>
                        </div>
                        <div class="form-group col-md-6">
                            <div class="icon"><span class="ion-ios-log-in"></span></div>
                            <input type="password" class="form-control" placeholder="Password" name="password" required>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-12">
                            <input type="submit" value="Accedi" class="form-control btn btn-primary">
                        </div>
                    </div>
                </div>
            </form>
        </section>
        <%@include file="/JSP/base/footer.jsp" %>
    </body>
</html>
