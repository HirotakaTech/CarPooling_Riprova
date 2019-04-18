<%-- 
    Document   : Logout
    Created on : 10-apr-2019, 11.04.31
    Author     : Bartelloni-Bellezza-NiccolaiF
--%>

<%session.setAttribute("utente", null);%>
<%session.setAttribute("email",null);%>
<%session.setAttribute("isAutista",null);%>
<%response.sendRedirect("index.jsp");%>