package com.example.vanbouwelbramsrune.ui.controller;

import com.example.vanbouwelbramsrune.domain.db.ResultaatDB;
import com.example.vanbouwelbramsrune.domain.model.Resultaat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private ResultaatDB resultaten = new ResultaatDB();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response) throws ServletException, IOException {
        /* String command = "home";
        if(request.getParameter("command") != null) {
            command = request.getParameter("command");
        } */

        String destination;
        destination = "home";
        String command = request.getParameter("command");

        if (command == null) command = "";

        switch (command) {
            case "home":
                destination = home(request, response);
                break;
            case "overzicht":
                destination = overzicht(request, response);
                break;
            case "voegToeForm":
                destination = addForm(request, response);
                break;
            case "voegToe":
                destination = add(request, response);
                break;
            case "deleteConfirmatie":
                destination = deleteConfirmatie(request, response);
                break;
            case "delete":
                destination = delete(request, response);
                break;
            case "editForm":
                destination = editForm(request, response);
                break;
            case "edit":
                destination = edit(request, response);
                break;
            case "zoekFormulier":
                destination = zoekForm(request, response);
                break;
            case "zoekConfirmatie":
                destination = zoekConfirmatie(request, response);
                break;
            case "zoek":
                destination = String.valueOf(zoek(request, response));
                break;
            default:
                destination = home(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }


    private String home(HttpServletRequest request,
                        HttpServletResponse response) {
        request.setAttribute("meesteAantalEieren", resultaten.getResultaatMeesteAantalEieren());
        return "index.jsp";
    }

    private String overzicht(HttpServletRequest request,
                             HttpServletResponse response) {
        try {
            request.setAttribute("resultaten", resultaten.getResultaten());
            return "overzicht.jsp";
        } catch (Exception e) {
            request.setAttribute("foutBoodschap", "Er zijn nog geen resultaten van het DACP.");
            return "overzicht.jsp";
        }

    }

    private String addForm(HttpServletRequest request,
                               HttpServletResponse response) {
        return "voegToe.jsp";
    }

    private String add(HttpServletRequest request,
                           HttpServletResponse response) {
        request.setAttribute("resultaten", resultaten.getResultaten());

        try {
            String achternaam = request.getParameter("achternaam");
            String voornaam = request.getParameter("voornaam");
            int aantalEieren = Integer.parseInt(request.getParameter("aantalEieren"));
            LocalDate datum = LocalDate.parse(request.getParameter("datum"));
            String extraInfo = request.getParameter("extraInfo");

            Resultaat r = new Resultaat(achternaam, voornaam, aantalEieren, datum, extraInfo);
            resultaten.add(r);
            return overzicht(request, response);
        } catch(Exception e) {
            request.setAttribute("foutBoodschap", "U vulde niet alle velden in.");
            return "voegToe.jsp";
        }
    }

    private String deleteConfirmatie(HttpServletRequest request,
                                     HttpServletResponse response) {
        LocalDate datum = LocalDate.parse(request.getParameter("datum"));
        request.setAttribute("resultaat", resultaten.getResultaatViaDatum(datum));
        return "deleteConfirmatie.jsp";
    }

    private String delete(HttpServletRequest request,
                          HttpServletResponse response) {
        LocalDate datum = LocalDate.parse(request.getParameter("datum"));
        Resultaat r = resultaten.getResultaatViaDatum(datum);
        try {
            resultaten.remove(r);
            return overzicht(request, response);
        } catch(Exception e) {
            request.setAttribute("foutBoodschap", "Kon resultaat niet verwijderen");
            return overzicht(request, response);
        }
    }

    private String editForm(HttpServletRequest request,
                            HttpServletResponse response) {
        LocalDate datum = LocalDate.parse(request.getParameter("datum"));
        request.setAttribute("resultaat", resultaten.getResultaatViaDatum(LocalDate.parse("datum")));
        return "edit.jsp";
    }

    private String edit(HttpServletRequest request,
                        HttpServletResponse response) {
        LocalDate vorigeDatum = LocalDate.parse(request.getParameter("datum"));
        Resultaat resultaatOudeStaat = resultaten.getResultaatViaDatum(vorigeDatum);

        String achternaam = request.getParameter("achternaam");
        String voornaam = request.getParameter("voornaam");
        int aantalEieren = Integer.parseInt(request.getParameter("aantalEieren"));
        LocalDate datum = LocalDate.parse(request.getParameter("datum"));
        String extraInfo = request.getParameter("extraInfo");

        try {
            resultaten.vervangAchternaam(achternaam, resultaatOudeStaat);
            resultaten.vervangVoornaam(voornaam, resultaatOudeStaat);
            resultaten.vervangAantalEieren(aantalEieren, resultaatOudeStaat);
            resultaten.vervangDatum(datum, resultaatOudeStaat);
            resultaten.vervangExtraInfo(extraInfo, resultaatOudeStaat);
            return overzicht(request, response);
        } catch (Exception e) {
            request.setAttribute("foutBoodschap", "Kon resultaat niet aanpassen.");
            return overzicht(request, response);
        }
    }

    private int zoek(HttpServletRequest request,
                        HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("resultaat", resultaten.getResultaatViaId(id));
        return Integer.parseInt("resultaat.jsp");
    }

    private String zoekForm(HttpServletRequest request,
                                 HttpServletResponse response) {
        return "zoekFormulier.jsp";
    }

    private String zoekConfirmatie(HttpServletRequest request,
                                    HttpServletResponse response) {
        return "zoekConfirmatie.jsp";
    }

}
