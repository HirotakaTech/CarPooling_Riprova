<%-- 
    Document   : index
    Created on : Mar 13, 2019, 1:24:18 PM
    Author     : Bartelloni-Bellezza-NiccoaliF
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/JSP/base/head.jsp"%>
    </head>
    <body>
        <%@include file="/JSP/base/header.jsp" %>
        <div class="hero-wrap js-fullheight" style="background-image: url('/5IB_Bartelloni-Bellezza-NiccolaiF_CarPooling/JSP/images/bg_1.jpg');" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-end" data-scrollax-parent="true">
                    <div class="col-md-7 ftco-animate mt-5" data-scrollax=" properties: { translateY: '70%' }">
                        <h1 class="mb-4" data-scrollax="properties: { translateY: '30%', opacity: 1.6 }">Viaggia a basso costo ovunque in Italia.<br> Parti all'avventura</h1>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="/JSP/base/ricerca.jsp" %>

        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center pb-5">
                    <div class="col-md-12 heading-section text-center ftco-animate">
                        <h2 class="mb-4">Viaggia Adesso!</h2>
                        <p>Roma, Venezia, Milano, Firenze...scegli una meta e parti!</p>
                    </div>
                </div>

            </div>
        </section>

        <%@include file="/JSP/base/footer.jsp" %>
    </body>
</html>