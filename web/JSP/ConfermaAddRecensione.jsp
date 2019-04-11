

<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.UtenteDao"%>
<%@page import="dao.PasseggeroDao"%>
<%@page import="dao.AutistaDao"%>
<%
    String email = (String)session.getAttribute("email");
    if(email == null){
        //Display error
    } else {
        UtenteDao daoUt = new UtenteDao();
        PasseggeroDao daoPass = new PasseggeroDao();
        AutistaDao daoAut = new AutistaDao();
        String autista_passeggero = request.getParameter("utente");
        int voto = Integer.parseInt(request.getParameter("voto"));
        String giudizio = request.getParameter("giudizio");
        if(daoPass.isPasseggero(email)){
           if(daoAut.isAutista(daoUt.findByName(autista_passeggero).getEmail())){
                //Aggiungi recensione
            } else {
               //Non aggiungerla
           }
        } else if(daoAut.isAutista(email)) {
            if(daoPass.isPasseggero(daoUt.findByName(autista_passeggero).getEmail())){
                //Aggiungi recensione
            } else {
                //non aggiungerla
            }
        }
    }%>
