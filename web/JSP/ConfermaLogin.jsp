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
    } else {ATTACKONTITAN
        url = "index.jsp";
    }
    response.sendRedirect(url);
    %>