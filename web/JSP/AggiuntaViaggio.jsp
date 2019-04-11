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
            <form>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="inputEmail4">Città di Partenza</label>
                        <input type="text" class="form-control" name="citta_partenza" placeholder="Città di Partenza">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputPassword4">Data di partenza</label>
                        <input type="date" class="form-control" name="data_partenza" placeholder="data">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputPassword4">Ora di Partenza</label>
                        <input type="time" class="form-control" name="ora_partenza" placeholder="Ora">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-6">
                        <label for="inputAddress">Citta di Destinazione</label>
                        <input type="text" class="form-control" name="citta_destinazione" placeholder="Città di Destinazione">
                    </div>
                    <div class="form-group col-6">
                        <label>Prezzo</label>
                        <input type="numeric" class="form-control" name="prezzo" placeholder="Inserisci il prezzo">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputAddress2">Address 2</label>
                    <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">City</label>
                        <input type="text" class="form-control" id="inputCity">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputState">State</label>
                        <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                        </select>
                    </div>
                    <div class="form-group col-md-2">
                        <label for="inputZip">Zip</label>
                        <input type="text" class="form-control" id="inputZip">
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-check">
                        <input class="form-check-input" type="checkbox" id="gridCheck">
                        <label class="form-check-label" for="gridCheck">
                            Check me out
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Sign in</button>
            </form>



    </body>
</html>
