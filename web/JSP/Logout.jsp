<%-- 
    Document   : Logout
    Created on : 10-apr-2019, 11.04.31
    Author     : utente
--%>

<%session.setAttribute("utente", null);%>
<%session.setAttribute("email",null);%>
<%response.sendRedirect("index.jsp");%>