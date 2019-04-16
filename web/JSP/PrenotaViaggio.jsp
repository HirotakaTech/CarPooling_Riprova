

<%@page import="dao.ViaggioDao"%>
<%@page import="dao.PrenotazioneDao"%>
<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.UtenteDao"%>
<%@page import="dao.PasseggeroDao"%>
<%@page import="dao.AutistaDao"%>
<%
    if(session.getAttribute("utente")==null){
        response.sendRedirect("Login.jsp");
    }
    int idViaggio = Integer.parseInt(request.getParameter("id")); 
    PrenotazioneDao dao = new PrenotazioneDao();
    if(dao.isPostiLiberi(idViaggio)){
        if(dao.insertPrenotazioni(idViaggio, (String)session.getAttribute("email"))){
        } else {
            //Operazione fallita!
        }
    }
    %>