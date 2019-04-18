

<%@page import="dao.ViaggiDao"%>
<%@page import="dao.PrenotazioniDao"%>
<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.AutistiDao"%>
<head>
    <%@include file="/JSP/base/head.jsp"%>

</head>

<%
    if (session.getAttribute("utente") == null) {
        response.sendRedirect("Login.jsp");
    }
    int idViaggio = Integer.parseInt(request.getParameter("id"));
    PrenotazioniDao dao = new PrenotazioniDao();
    if (dao.isPostiLiberi(idViaggio)) {
        if (dao.insertPrenotazioni(idViaggio, (String) session.getAttribute("email"))) {
            response.sendRedirect("index.jsp");
        } %>
<%} else {
   %>
<%@include file="/JSP/base/header.jsp" %>
<h1 style="margin-top:100px; text-align: center">Tutti i posti per quel viaggio sono stati già prenotati!</h1>
<br><center><a href="${pageContext.request.contextPath}/JSP/index.jsp" style="font-size: 24pt">Home</a></center>

<br><br> <br><br> <br><br> <br><br> <br><br> <br><br> <br><br>

<%@include file="/JSP/base/footer.jsp" %>
<%}%>