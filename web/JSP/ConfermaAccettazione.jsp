

<%@page import="dao.ViaggiDao"%>
<%@page import="dao.PrenotazioneDao"%>
<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.AutistiDao"%>
<%
    if (session.getAttribute("utente") == null) {
        response.sendRedirect("Login.jsp");
    }
    boolean isAutist = false;
    boolean ok = true;
    try {
        isAutist = (Boolean) session.getAttribute("isAutista");
    } catch (Exception e) {
        ok = false;
    }
    if (isAutist && ok) {
        String codice = request.getParameter("codice");
        PrenotazioneDao dao = new PrenotazioneDao();
        if (dao.accettaPrenotazione(codice)) {
            response.sendRedirect("AccettazionePrenotazioni.jsp"); %>
<%} else {%>
<h1>Qualcosa è andato storto! C'è stato un errore...</h1>
<br><a href="${pageContext.request.contextPath}/JSP/AccettazionePrenotazione.jsp">Torna indietro</a>
<br><a href="${pageContext.request.contextPath}/JSP/index.jsp">Home</a>
<%}%>
<%} else {
        if (!isAutist) {%>
<h1>Non sei un autista! Accedi come autista, se vuoi accettare le prenotazioni!</h1>
<br><a href="${pageContext.request.contextPath}/JSP/Login.jsp">Login</a>
<%} else {
            if (!ok) {%>
<h1>Qualcosa è andato storto! C'è stato un errore...</h1>
<br><a href="${pageContext.request.contextPath}/JSP/AccettazionePrenotazione.jsp">Torna indietro</a>
<br><a href="${pageContext.request.contextPath}/JSP/index.jsp">Home</a>
<%}%>
}%>
}%>