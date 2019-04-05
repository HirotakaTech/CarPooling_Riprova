

<%
    AutistaDao daoAutista = new AutistaDao();
    Passengero daoPassengero = new PasseggeroDao();
    String email = (String)request.getParameter("email");
String password = (String)request.getParameter("password");
String nome = (String)request.getParameter("nome");
String cognome = (String)request.getParameter("cognome");
String data_nascita = (String)request.getParameter("data_nascita");
String luogo = (String)request.getParameter("luogo");
String telefono = (String)request.getParameter("telefono");
UtenteDao dao = new UtenteDao();
Utente utente = new Utente(email,password,nome,cognome,data_nascita,luogo,telefono);
if(dao.findUser){
    response.sendRedirect("Register.jsp");
} else {
    dao.inserisciUtente(user);
    boolean ok = false;
    if("autista".equals(request.getParameter("radiobutton"))){
        ok = aggiungiAutista(email);
    }else{
        ok = aggiungiPasseggero(email);
    }
    if(ok){
        Mail.send("carpoolingnoreply@gmail.com", "CarPooling4EVER!", email, "Your registration is done!");
    } else {
        response.sendRedirect("error.jsp");
    }
}%>

<%!public boolean aggiungiPasseggero(String email){
    String documento = request.getParameter("documento");
    return (daoPasseggero.insertPasseggero(email,documento));
}%>

<%!public boolean aggiungiAutista(String email){
    int numero_posti = (int)request.getParameter("posti");
    String data_scadenza_patente = (String)request.getParameter("data_patente");
    String foto = (String)request.getParameter("foto"); //URL
    String numero_patente = (String)request.getParameter("patente");
    String targa_auto = (String)request.getParameter("targa");
    String modello_auto = (String)request.getParameter("modello");    
    Autista au = new Autista(numero_posti,data_scadenza_patente,foto, 
        numero_patente,targa_auto,modello_auto);
    au.setEmail(email);
    return (daoAutista.insertAutista(au));
}%>