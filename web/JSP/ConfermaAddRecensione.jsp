

<%@page import="dao.FeedbackDao"%>
<%@page import="beans.Feedback"%>
<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.UtentiDao"%>
<%@page import="dao.PasseggeriDao"%>
<%@page import="dao.AutistiDao"%>
<%
    String emailMandante = (String)session.getAttribute("email");
    if(emailMandante == null){%>
        <%response.sendRedirect("Login.jsp");%>
    <%} else {
        UtentiDao daoUt = new UtentiDao();
        PasseggeriDao daoPass = new PasseggeriDao();
        AutistiDao daoAut = new AutistiDao();
        FeedbackDao daoFed = new FeedbackDao();
        String emailRicevente = request.getParameter("utente");
        int voto = Integer.parseInt(request.getParameter("voto"));
        String giudizio = request.getParameter("giudizio");
        Feedback fed = new Feedback(giudizio, voto, emailMandante, emailRicevente);
        if(daoPass.isPasseggero(emailMandante)){
           if(daoAut.isAutista(emailRicevente)){
               daoFed.insertFeedbackA(fed);
               response.sendRedirect("Recensioni.jsp");
            }
        } else if(daoAut.isAutista(emailMandante)) {
            if(daoPass.isPasseggero(emailRicevente)){
               daoFed.insertFeedbackP(fed);
               response.sendRedirect("Recensioni.jsp");
            }
        }
    }%>
