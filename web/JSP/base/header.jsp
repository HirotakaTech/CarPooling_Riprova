<%-- 
    Document   : header
    Created on : Mar 25, 2019, 9:57:50 PM
    Author     : Bartelloni-Bellezza-NiccoaliF
--%>


<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/JSP/index.jsp"><span>CarPooling</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active"><a href="${pageContext.request.contextPath}/JSP/index.jsp" class="nav-link">Home</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/JSP/Recensioni.jsp" class="nav-link">Recensioni</a></li>
                    <% Boolean isAutista = (Boolean) session.getAttribute("isAutista");
                        try {
                            
                            if (isAutista != null && isAutista == true) {%>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/JSP/AggiuntaViaggio.jsp" class="nav-link">Aggiungi un viaggio</a></li>

                <% }else if(isAutista==false){
                   %> <li class="nav-item active"><a href="${pageContext.request.contextPath}/JSP/ListaViaggi.jsp" class="nav-link">Prenota</a></li><%
                }
                    } catch (NullPointerException e) {

                    }%>
                <%if (session.getAttribute("utente") == null) {%> 
                <li class="nav-item"><a href="${pageContext.request.contextPath}/JSP/Register.jsp" class="nav-link">Registrati</a></li>
                <li class="nav-item cta"><a href="${pageContext.request.contextPath}/JSP/Login.jsp" class="nav-link">Login</a></li>
                    <%} else {%> 
                <div class="btn-group">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                        <%=session.getAttribute("utente")%><span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
                        <%try{if(isAutista !=null && isAutista==true){%>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/JSP/ViaggiCreati.jsp" class="nav-link"><div class="p-3 mb-2 bg-light text-dark">I miei Viaggi</div></a></li>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/JSP/AccettazionePrenotazioni.jsp" class="nav-link"><div class="p-3 mb-2 bg-light text-dark">Accettazione</div></a></li>
                        <%} else if(isAutista != null && isAutista == false){%>
                                            <li class="nav-item"><a href="${pageContext.request.contextPath}/JSP/ListaPrenotazioni.jsp" class="nav-link"><div class="p-3 mb-2 bg-light text-dark">Le mie prenotazioni</div></a></li>
<%}}catch(NullPointerException e){}%>
                        <li class="nav-item"><a href="${pageContext.request.contextPath}/JSP/Logout.jsp" class="nav-link"><div class="p-3 mb-2 bg-light text-dark">Logout</div></a></li>
                    </ul>

                </div>
                <%}%>
            </ul>
        </div>
    </div>
</nav>
