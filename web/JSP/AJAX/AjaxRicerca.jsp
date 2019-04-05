<%-- 
    Document   : AjaxRicerca
    Created on : Mar 28, 2019, 5:03:46 PM
    Author     : Bartelloni-Bellezza-NiccolaiF
--%>

<%@page import="dao.ViaggioDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Viaggio"%>
<%
    String destinazione=(String)session.getAttribute("destinazione");
    ViaggioDao dao=new ViaggioDao();
    String data=(String)session.getAttribute("data");
    String ora=(String)session.getAttribute("ora");
    String[] dividi=data.split("/");
    data=dividi[2]+"/"+dividi[1]+"/"+dividi[0];
    float prezzo= Float.parseFloat((String)session.getAttribute("prezzo"));
    ArrayList<Viaggio> viaggi = dao.getViaggi(destinazione,data,ora,prezzo);
    %><table>
        <tr><td>Destinazione</td>
            <td>Data</td>
            <td>Ora</td>
            <td>Prezzo</td>
        </tr>
    <%for(Viaggio viaggio: viaggi){%>
    <tr><td><%=viaggio.getCitta_destinazione()%></td>
        <td><%=viaggio.getData_partenza()%></td>
        <td><%=viaggio.getOra_partenza()%></td>
        <td><%=viaggio.getPrezzo()%></td>
    </tr>
    <%}%>
    </table>
    