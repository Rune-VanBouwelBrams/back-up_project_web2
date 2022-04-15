<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
            <%-- <article class="home"> <%-- geen article van maken maar ipv alle verschillende onderdelen een article maken --%> <%--


        <%-- misschien verschillende class/divs maken van de verschillende alineas in de index.jsp???? --%> <%--
        <p>Om te voorkomen dat er duivenkuikens zijn, maken we gebruik van het DACP.</p>
        <p>De vrijwilligers moeten om de twee dagen de duiveneieren nakijken.
        Dit doen ze door er met een zaklamp/felle lichtbron op te schijnen en te kijken of ze al dan niet bevrucht zijn.</p>
        <%-- foto's toevoegen --%> <%--
        <p>De vrijwilligers dienen daarna op de pagina 'Voeg toe' in te geven hoeveel eieren ze hebben weggehaald, hun eigen naam en de datum.</p>

    </article> --%>
            <h3>Duiven Anticonceptie Protocol (DACP)</h3>

            <article class=”doel”>
                <p>Het doel van het DACP is om de voortplanting van de duiven te voorkomen, er worden namelijk al meer dan 200 duiven opgevangen bij Forrest and Friends. </p>
                <p>We passen dit protocol toe omdat de anticonceptie via de ‘pil’ te duur is (zo’n €3000 per maand). Dit is helaas te duur voor een dierenopvang.</p>
            </article>

            <article class=”uitleg”>
                <p>De broedperiode bij duiven bedraagt 17 dagen.</p>
                <p>Ze leggen vaak twee eieren en beginnen pas met broeden wanneer het tweede ei is gelegd.</p>
                <p>Om te voorkomen dat de kuikens zouden sterven in de eieren, draaien de duiven hun eieren. Wanneer je een bevrucht ei vastneemt mag je het voorzichtig draaien, schudden is echter dodelijk. </p>
                <p>Een duif die broedt, zal haar ei(eren) beschermen door haar vleugels naar je te slaan en desnoods te pikken. Dit doet geen pijn. Ga gewoon met je hand onder de duif en neem het ei voorzichtig weg. </p>
                <p>Om te zien of een ei bevrucht is en hoe ver, hou je het ei tegen de zaklamp van je gsm.</p>
                <p>Is het ei doorschijnend? Dan is het niet bevrucht of nog maar pas gelegd.</p>
                <p>Na 4 à 5 dagen zie je een rode bol met uiteenlopende aders. Dit is een bevrucht ei.</p>
                <p>Daarna groeit het vruchtje. Hoe groter het kuiken wordt, hoe minder doorschijnend het ei.</p>
                <%-- <img src="img/pasgelegd_ei.jpg" alt="Pasgelegd ei, mag weggehaald worden." class="image">
                <img src="img/bevrucht_ei.jpg" alt="Bevrucht ei, niet weghalen." class="image">
                <img src="img/ei_uitkomen.jpg" alt="Ei dat bijna zal uitkomen." class="image"> --%>
            </article>

            <article class=”tijdstippen”>
                <p>We controleren en halen de eieren weg om de twee dagen.</p>
                <p>In januari gebeurt dit op de even dagen, in februari en maart op de oneven. In april en mei weer de even dagen en juni en juli de oneven. Op de even dagen in augustus en de oneven in september en oktober. In november en december zijn het terug de even dagen.</p>
            </article>

            <article class="meesteEierenDACP">
                <p>Het meeste aantal eieren is momenteel <%= request.getAttribute("meesteAantalEieren")%>.</p>
            </article>

        </main>
    </div>


    <%-- <h1><%= "Hello World!" %>
    </h1>
    <br/>
    <a href="hello-servlet">Hello Servlet</a> --%>
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