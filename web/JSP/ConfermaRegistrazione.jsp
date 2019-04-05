

<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.UtenteDao"%>
<%@page import="dao.PasseggeroDao"%>
<%@page import="dao.AutistaDao"%>
<%
    String email = request.getParameter("email");
String password = request.getParameter("password");
String nome = request.getParameter("nome");
String cognome = request.getParameter("cognome");
String data_nascita = request.getParameter("data_nascita");
String luogo = request.getParameter("luogo");
String telefono = request.getParameter("telefono");
UtenteDao dao = new UtenteDao();
Utente utente = new Utente(email,password,nome,cognome,data_nascita,luogo,telefono);
if(dao.findUser(email)){
    response.sendRedirect("Register.jsp");
} else {
    dao.inserisciUtente(utente);
    boolean ok = false;
    if("autista".equals(request.getParameter("radiobutton"))){
        ok = aggiungiAutista(email,request);
    }else{
        ok = aggiungiPasseggero(email,request);
    }
    if(ok){
        Mail.send("carpoolingnoreply@gmail.com", "CarPooling4EVER!", email,"Registration Complete!","Your registration is done!");
    } else {
        response.sendRedirect("error.jsp");
    }
}%>

<%!public boolean aggiungiPasseggero(String email, HttpServletRequest request){

    PasseggeroDao daoPasseggero = new PasseggeroDao();
    String documento = request.getParameter("documento");
    return (daoPasseggero.insertPasseggero(email,documento));
}%>

<%!public boolean aggiungiAutista(String email, HttpServletRequest request){

    AutistaDao daoAutista = new AutistaDao();
    int numero_posti = Integer.parseInt(request.getParameter("posti"));
    String data_scadenza_patente = request.getParameter("data_patente");
    String foto = request.getParameter("foto"); //URL
    String numero_patente = request.getParameter("patente");
    String targa_auto = request.getParameter("targa");
    String modello_auto = request.getParameter("modello");    
    Autista au = new Autista(numero_posti,data_scadenza_patente,foto, 
        numero_patente,targa_auto,modello_auto);
    au.setEmail(email);
    return (daoAutista.insertAutista(au));
}%>