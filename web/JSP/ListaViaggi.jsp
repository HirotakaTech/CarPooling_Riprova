<%-- 
    Document   : Recensioni
    Created on : Mar 25, 2019, 10:18:12 PM
    Author     : Fierino
--%>

<%@page import="beans.Viaggio"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ViaggioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/JSP/base/head.jsp" %>
    </head>
    <body>
        <%@include file="/JSP/base/header.jsp" %>
        <%
            boolean isAutist = false;
            boolean ok = true;
            try{
            isAutist = (Boolean) session.getAttribute("isAutista");
            }catch(Exception e){
                ok =false;
            } 
           if (!isAutist && ok ) {
            ViaggioDao dao = new ViaggioDao();
                ArrayList<Viaggio> viaggi = dao.visualizzaViaggi();%>
                <form action="PrenotaViaggio.jsp" method="POST">
                <div class="span6 offset-lg-0 offset-6" style='margin-top: 8%'>
                    <div class="container">
                <div class="table col-md-12">
                    
                    <div class="row">
                        <div class="col-lg-1">
                        Prenota
                    </div>
                        <div class="col-lg-1">
                        Partenza
                    </div>
                    
                    <div class="col-lg-2">
                        Data
                    </div>
                    <div class="col-lg-1">
                        Ora
                    </div>
                    <div class="col-lg-1">
                        Arrivo
                    </div>
                    <div class="col-lg-1">
                       Prezzo(€)
                    </div>
                    <div class="col-lg-1">
                        Durata
                    </div>
                    <div class="col-lg-1">
                        Info
                    </div>
                    <div class="col-lg-1">
                        Autista
                    </div>
                        
                    </div>
                <%for(Viaggio viag: viaggi){%>
                <div class="row">
                    
                    <div class="col-lg-1">
                        <input type="hidden" value="<%=viag.getId()%>" name="id"/>
                        <input type="submit" value="Prenota" name="prenota"/>
                    </div>
                    <div class="col-lg-1">
                        <%=viag.getCitta_partenza()%>
                    </div>
                    
                    <div class="col-lg-2">
                        <%=viag.getData_partenza()%>
                    </div>
                    <div class="col-lg-1">
                        <%=viag.getOra_partenza()%>
                    </div>
                    <div class="col-lg-1">
                        <%=viag.getCitta_destinazione()%>
                    </div>
                    <div class="col-lg-1">
                        <%=viag.getPrezzo()%>
                    </div>
                    <div class="col-lg-1">
                        <%=viag.getTempi_stimati()%>
                    </div>
                    <div class="col-lg-1">
                        <a href="" title="<%=viag.getInfo_aggiuntive()%>">...</a>
                    </div>
                    <div class="col-lg-1">
                        <%=viag.getEmail_autista()%>
                    </div>
                        </div>
                <%}%>
                </div>
            <%}%>
            
</div>
                </form>
            </div>
    </body>
</html>
