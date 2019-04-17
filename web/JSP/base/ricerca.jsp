<%-- 
    Document   : ricerca
    Created on : Mar 25, 2019, 10:19:30 PM
    Author     : Fierino
--%>

<section class="ftco-section ftco-no-pb ftco-no-pt">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="search-wrap-1 ftco-animate p-4">
                            <form action="${pageContext.request.contextPath}/JSP/ConfermaRicerca.jsp" method="GET" class="search-property-1">
                                <div class="row">
                                    <div class="col-lg align-items-end">
                                        <div class="form-group">
                                            <label for="#">Destinazioni</label>
                                            <div class="form-field">
                                                <div class="icon"><span class="ion-ios-search"></span></div>
                                                <input type="text" class="form-control" placeholder="Nome città" name="destinazione" required>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg align-items-end">
                                        <div class="form-group">
                                            <label for="#">Giorno</label>
                                            <div class="form-field">
                                                <div class="icon"><span class="ion-ios-calendar"></span></div>
                                                <input type="text" class="form-control checkin_date" placeholder="Data di partenza" name="data" required>
                                            </div>
                                        </div>
                                    </div>
                                   
                                    <div class="col-lg align-items-end">
                                        <div class="form-group">
                                            <label for="#">Limite Prezzo</label>
                                            <div class="form-field">
                                                <div class="select-wrap">
                                                    <div class="icon"><span class="ion-ios-arrow-down"></span></div>
                                                    <select name="prezzo" id="" class="form-control" required>
                                                        <option>5</option>
                                                        <option>10</option>
                                                        <option>50</option>
                                                        <option>100</option>
                                                        <option>200</option>
                                                        <option>300</option>
                                                        <option>400</option>
                                                        <option>500</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-lg align-self-end">
                                        <div class="form-group">
                                            <div class="form-field">
                                                <input type="submit" value="Search" class="form-control btn btn-primary">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>