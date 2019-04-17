<%@ page isErrorPage="true" import="java.io.*" contentType="text/html"%>
<h1 align='center'>Sembra esserci un problema</h1>
<center><p>Il server ha riscontrato un problema con la pagina. Se il problema persiste prova a riavviare.</p></center>
<br>
<br>
<h3>Errore:</h3>
<%=exception.getMessage()%>
