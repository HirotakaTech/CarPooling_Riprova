<%-- 
    Document   : AjaxRicerca
    Created on : Mar 28, 2019, 5:03:46 PM
    Author     : Bartelloni-Bellezza-NiccolaiF
--%>

<%@page import="dao.ViaggiDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Viaggio"%>
<%
    String destinazione = (String) session.getAttribute("destinazione");
    ViaggiDao dao = new ViaggiDao();
    String data = (String) session.getAttribute("data");
    String ora = (String) session.getAttribute("ora");
    String[] dividi = data.split("/");
    data = dividi[2] + "-" + dividi[0] + "-" + dividi[1];
    int prezzo = Integer.parseInt((String) session.getAttribute("prezzo"));
    ArrayList<Viaggio> viaggi = dao.getViaggi(destinazione, data, ora, prezzo);

%> 
<center><div class="container" style="margin-top: 50px !important; color: black;">
        <div class="table col-md-12 ">
            <div class="row col-md-12" style="font-size: 20pt;margin-bottom: 20px">
                <div class="col-md-2">Prenota</div>
                <div class="col-md-2">Destinazione</div>
                <div class="col-md-2">Data</div>
                <div class="col-md-2">Ora</div>
                <div class="col-md-2">Prezzo</div>

            </div>

            <%for (Viaggio viaggio : viaggi) {%>
            <div class="row" style="background-color: #212529;color: white">
                <div class="col-md-2"><form action="${pageContext.request.contextPath}/JSP/PrenotaViaggio.jsp">
                        <input type="hidden" value="<%=viaggio.getId()%>" name="id"/>
                        <input type="submit" value="Prenota" name="prenota"/>
                    </form></div>
                <div class="col-md-2"><%=viaggio.getCitta_destinazione()%></div>
                <div class="col-md-2"><%=viaggio.getData_partenza()%></div>
                <div class="col-md-2"><%=viaggio.getOra_partenza()%></div>
                <div class="col-md-2"><%=viaggio.getPrezzo()%></div>

            </div>
        </div>
        <%}%>
    </div>
</center>
