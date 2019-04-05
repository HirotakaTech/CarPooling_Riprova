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
                <form action="/5IB_Bartelloni-Bellezza-NiccolaiF_CarPooling/JSP/ConfermaLogin.jsp" method="POST">
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Email</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-log-in"></span></div>
                                <input type="text" class="form-control" placeholder="Email" name="email" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg align-items-end">
                        <div class="form-group">
                            <label for="#">Password</label>
                            <div class="form-field">
                                <div class="icon"><span class="ion-ios-log-in"></span></div>
                                <input type="password" class="form-control" placeholder="Password" name="password" required>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg align-self-end">
                        <div class="form-group">
                            <div class="form-field">
                                <input type="submit" value="Accedi" class="form-control btn btn-primary">
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </section>
</div>
<%@include file="/JSP/base/footer.jsp" %>
</body>
</html>
