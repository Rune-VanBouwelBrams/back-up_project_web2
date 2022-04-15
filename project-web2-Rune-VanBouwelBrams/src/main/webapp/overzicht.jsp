<%@ page import="com.example.vanbouwelbramsrune.domain.model.Resultaat" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: runev
  Date: 25/02/2022
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forrest and Friends</title>
    <link rel="stylesheet" href="normalize.css"> <%-- normalize.css toevoegen!!! --%>
    <link rel="stylesheet" href="style.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Amatic+SC&family=Assistant&display=swap" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="./img/forrest_friends_favicon.png">
</head>
<body>
<div id="page-container">
    <div id="content-wrap">
        <header>
            <h1>Forrest and Friends</h1>
            <h2>Animal Sanctuary</h2>
            <div class="nav">
                <input type="checkbox" id="nav-toggle" class="nav-toggle"> <!-- voor het hamburger menu te kunnen maken (zodat het menu zichtbaar wordt) -->
                <nav>
                    <ul>
                        <li><a href="Controller?command=index" ${param.hier eq "index"?"id='huidigePagina'":""}>Home</a></li>
                        <li><a href="Controller?command=voegToe" ${param.hier eq "voegToe"?"id='huidigePagina'":""}>Toevoegen</a></li>
                        <li><a href="Controller?command=overzicht" ${param.hier eq "overzicht"?"id='huidigePagina'":""}>Overzicht</a></li>
                        <li><a href="Controller?command=zoekFormulier" ${param.hier eq "zoek"?"id='huidigePagina'":""}>Zoek</a></li>
                    </ul>
                </nav>
                <label for="nav-toggle" class="nav-toggle-label">
                    <span></span>
                </label>
            </div>
        </header>

        <main>
            <h3>Bekijk alle resultaten</h3>

            <table>
                <thead>
                <tr>
                    <th>Id</th>
                    <th>Naam</th>
                    <th>Voornaam</th>
                    <th>Aantal eieren</th>
                    <th>Datum</th>
                    <th>Extra info</th>
                </tr>
                </thead>

                <tbody>
                <% for (Resultaat r: (ArrayList<Resultaat>) request.getAttribute("resultaten")) { %>

                <tr>
                    <td><%=r.getId()%></td>
                    <td><%=r.getAchternaam()%></td>
                    <td><%=r.getVoornaam()%></td>
                    <td><%=r.getAantalEieren()%></td>
                    <td><%=r.getDatum()%></td>
                    <td><%=r.getExtraInfo()%></td>
                    <td>Edit</td>
                    <td>X</td>
                </tr>
                <% } %>
                </tbody>
            </table>

            <%-- <article>
                <p>Het meeste aantal eieren is <%= request.getAttribute("meesteAantalEieren")%>.</p>
            </article> --%>


        </main>
    </div>

    <footer id="footer">
        <h4>Contact</h4>
        <p>Bredestraat 128 3293 Kaggevinne (Diest) België</p>
        <p><a href="tel:+32 492 54 04 97">+32 492 54 04 97</a></p>

        <h4>Social media</h4>
        <p><a href="https://www.facebook.com/forrestfriendsvzw" target="_blank">Facebook Forrest and Friends</a></p>
        <%-- hier telnr van Forrest and Friends + link naar hun website + link naar hun fb zetten --%>
    </footer>
</div>


</body>
</html>
