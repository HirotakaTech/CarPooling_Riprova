<%-- 
    Document   : ConfermaLogin
    Created on : 1-apr-2019, 17.02.24
    Author     : checc_000
--%>
<%@page import="dao.AutistaDao"%>
<%@page import="dao.PasseggeroDao"%>
<%@page import="dao.UtenteDao"%> 
<%
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    UtenteDao ut = new UtenteDao();
    PasseggeroDao pass = new PasseggeroDao();
    AutistaDao aut = new AutistaDao();
    String url = "";
    boolean logged = ut.login(email, password);
    if (!logged) {
        url = "Login.jsp";
    } else {
        boolean ok = false;
        url = "index.jsp";
        if ("autitsta".equals(request.getParameter("radiobutton"))) {
            ok = aut.isAutista(email);
        } else {
            ok = pass.isPasseggero(email);
        }
        session.setAttribute("utente", ut.findByEmail(email).getNome());
        session.setAttribute("email", email);
        if (ok) {
                if ("autitsta".equals(request.getParameter("radiobutton"))) {
                    session.setAttribute("isAutista", true);
                } else {
                    session.setAttribute("isAutista", false);
                }
            }
        }

    }%>