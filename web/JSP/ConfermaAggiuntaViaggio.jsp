

<%@page import="dao.ViaggiDao"%>
<%@page import="beans.Viaggio"%>
<%@page import="beans.Autista"%>
<%@page import="mail.Mail"%>
<%@page import="beans.Utente"%>
<%@page import="dao.UtentiDao"%>
<%@page import="dao.PasseggeriDao"%>
<%
    
    if(session.getAttribute("utente")== null){
        response.sendRedirect("Login.jsp");
    }
    if ((Boolean)session.getAttribute("isAutista") != null ||
            (Boolean)session.getAttribute("isAutista") == true) {
        String citta_partenza = request.getParameter("citta_partenza");
        String data_partenza = request.getParameter("data_partenza");
        String ora_partenza = request.getParameter("ora_partenza");
        String citta_destinazione = request.getParameter("citta_destinazione");
        float prezzo = Float.parseFloat(request.getParameter("prezzo"));
        String tempi = request.getParameter("tempi");
        String info = request.getParameter("info");
        String email = (String) session.getAttribute("email");
        Viaggio viag = new Viaggio(citta_partenza, citta_destinazione,
                data_partenza, ora_partenza, prezzo,
                tempi, info, email);
        ViaggiDao daoViag = new ViaggiDao();
        if (daoViag.insertViaggio(viag)) {
            response.sendRedirect("index.jsp");
        }
    } 
%>