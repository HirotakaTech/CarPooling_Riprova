<%-- 
    Document   : ConfermaLogin
    Created on : 1-apr-2019, 17.02.24
    Author     : Bartelloni-Bellezza-NiccolaiF
--%>
<%@page import="dao.AutistiDao"%>
<%@page import="dao.PasseggeriDao"%>
<%@page import="dao.UtentiDao"%> 
<%
    try {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UtentiDao ut = new UtentiDao();
        PasseggeriDao pass = new PasseggeriDao();
        AutistiDao aut = new AutistiDao();
        String url = "";
        boolean logged = ut.login(email, password);
        if (!logged) {
            url = "Login.jsp";
        } else {
            boolean ok = false;
            url = "index.jsp";
            if (request.getParameter("radiobutton").equals("autista")) {
                ok = aut.isAutista(email);
            } else {
                ok = pass.isPasseggero(email);
            }
            session.setAttribute("utente", ut.findByEmail(email).getNome());
            session.setAttribute("email", email);
            Boolean isAutista = true;
            if (ok) {
                if (request.getParameter("radiobutton").equals("autista")) {
                    session.setAttribute("isAutista", isAutista);
                } else if (request.getParameter("radiobutton").equals("passeggero")) {
                    isAutista = false;
                    session.setAttribute("isAutista", isAutista);
                }

                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("Login.jsp");
            }
        }
    } catch (Exception e) {
%><jsp:forward page="/JSP/Login.jsp"></jsp:forward><%
             }%>