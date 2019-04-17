

<%@page import="dao.FeedbackDao"%>
<%@page import="beans.Feedback"%>
<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.UtenteDao"%>
<%@page import="dao.PasseggeroDao"%>
<%@page import="dao.AutistaDao"%>
<%
    String emailMandante = (String)session.getAttribute("email");
    if(emailMandante == null){%>
        <%response.sendRedirect("Login.jsp");%>
    <%} else {
        UtenteDao daoUt = new UtenteDao();
        PasseggeroDao daoPass = new PasseggeroDao();
        AutistaDao daoAut = new AutistaDao();
        FeedbackDao daoFed = new FeedbackDao();
        String emailRicevente = request.getParameter("utente");
        int voto = Integer.parseInt(request.getParameter("voto"));
        String giudizio = request.getParameter("giudizio");
        Feedback fed = new Feedback(giudizio, voto, emailMandante, emailRicevente);
        if(daoPass.isPasseggero(emailMandante)){
           if(daoAut.isAutista(emailRicevente)){
               daoFed.insertFeedbackA(fed);
            }
        } else if(daoAut.isAutista(emailMandante)) {
            if(daoPass.isPasseggero(emailRicevente)){
               daoFed.insertFeedbackP(fed);
            }
        }
    }%>
