

<%@page import="dao.ViaggiDao"%>
<%@page import="dao.PrenotazioneDao"%>
<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.AutistiDao"%>
<%
    if(session.getAttribute("utente")==null){
        response.sendRedirect("Login.jsp");
    }
    String codice = request.getParameter("codice"); 
    PrenotazioneDao dao = new PrenotazioneDao();
        if(dao.accettaPrenotazione(codice)){
            response.sendRedirect("AccettazionePrenotazioni.jsp"); %>
    <%} else {%>
    <h1>Qualcosa � andato storto! C'� stato un errore...</h1>
        <br><a href="${pageContext.request.contextPath}/JSP/ListaViaggi.jsp">Visualizza tutti i viaggi</a>
        <br><a href="${pageContext.request.contextPath}/JSP/index.jsp">Home</a>
    <%}%>