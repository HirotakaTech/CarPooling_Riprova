<%-- 
    Document   : ConfermaLogin
    Created on : 1-apr-2019, 17.02.24
    Author     : checc_000
--%>
<%@page import="dao.UtenteDao"%> 
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    UtenteDao ut = new UtenteDao();
    String url = "";
    boolean logged = ut.login(email,password);
    if(!logged){
        url = "Login.jsp";
    } else {
        url = "index.jsp";
        session.setAttribute("utente", ut.findByEmail(email).getNome());
        session.setAttribute("email", email);
    }
    response.sendRedirect(url);
    %>