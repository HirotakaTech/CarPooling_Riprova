<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.UtentiDao"%>
<%@page import="dao.PasseggeriDao"%>
<%@page import="dao.AutistiDao"%>
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String nome = request.getParameter("nome");
    String cognome = request.getParameter("cognome");
    String data_nascita = request.getParameter("data_nascita");
    String luogo = request.getParameter("luogo");
    String telefono = request.getParameter("telefono");
    UtentiDao dao = new UtentiDao();
    Utente utente = new Utente(email, password, nome, cognome, data_nascita, luogo, telefono);
    boolean ok = false;
    if (!dao.isUser(email)) {
        ok = dao.inserisciUtente(utente);
        if ("autista".equals(request.getParameter("radiobutton"))) {
            ok = aggiungiAutista(email, request);
        } else {
            ok = aggiungiPasseggero(email, request);
        }
    } else {
        if ("autista".equals(request.getParameter("radiobutton"))) {
            ok = aggiungiAutista(email, request);
        } else {
            ok = aggiungiPasseggero(email, request);
        }
    }
    if (ok) {
        Mail.send("carpoolingnoreply@gmail.com", "CarPooling4EVER!", email, "Registration Complete!", "Your registration is done!");
        response.sendRedirect("index.jsp");
    } else {
        response.sendRedirect("Register.jsp");
    }%>

<%!public boolean aggiungiPasseggero(String email, HttpServletRequest request) {

        PasseggeriDao daoPasseggero = new PasseggeriDao();
        String documento = request.getParameter("documento");
        return (daoPasseggero.insertPasseggero(email, documento));
    }%>

<%!public boolean aggiungiAutista(String email, HttpServletRequest request) {

        AutistiDao daoAutista = new AutistiDao();
        int numero_posti = Integer.parseInt(request.getParameter("posti"));
        String data_scadenza_patente = request.getParameter("data_patente");
        String foto = request.getParameter("foto"); //URL
        String numero_patente = request.getParameter("patente");
        String targa_auto = request.getParameter("targa");
        String modello_auto = request.getParameter("modello");
        Autista au = new Autista(numero_posti, data_scadenza_patente, foto,
                numero_patente, targa_auto, modello_auto);
        au.setEmail(email);
        return (daoAutista.insertAutista(au));
    }%>
