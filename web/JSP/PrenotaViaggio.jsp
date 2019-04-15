

<%@page import="dao.PrenotazioneDao"%>
<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.UtenteDao"%>
<%@page import="dao.PasseggeroDao"%>
<%@page import="dao.AutistaDao"%>
<%
    int numeroPosti = Integer.parseInt(request.getParameter("posti"));
    int idViaggio = Integer.parseInt(request.getParameter("id")); 
    PrenotazioneDao dao = new PrenotazioneDao();
    if(dao.isPostiLiberi(idViaggio)){
        if(dao.updatePrenotazioni(numeroPostiPrenotati)){
            //Operazione andata a buon fine!
        } else {
            //Operazione fallita!
        }
    }
        //Mail.send("carpoolingnoreply@gmail.com", "CarPooling4EVER!", email, "Registration Complete!", "Your registration is done!");
    %>