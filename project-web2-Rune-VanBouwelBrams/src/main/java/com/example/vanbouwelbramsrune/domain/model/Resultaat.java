package com.example.vanbouwelbramsrune.domain.model;

import java.time.LocalDate;

public class Resultaat {
    private String achternaam, voornaam;
    private String extraInfo;
    private int aantalEieren;
    private int id;
    private LocalDate datum;

    public Resultaat(int id, String achternaam, String voornaam, int aantalEieren, LocalDate datum, String extraInfo) {
        setId(id);
        setAchternaam(achternaam);
        setVoornaam(voornaam);
        setAantalEieren(aantalEieren);
        setDatum(datum);
        setExtraInfo(extraInfo);
    }

    public Resultaat(String achternaam, String voornaam, int aantalEieren, LocalDate datum, String extraInfo) {
        setAchternaam(achternaam);
        setVoornaam(voornaam);
        setAantalEieren(aantalEieren);
        setDatum(datum);
        setExtraInfo(extraInfo);
    }

    public static boolean isValidString(String input) {
        return (input != null) && !(input.trim().isEmpty());
    }

    public static boolean isValidAantalEieren(int aantalEieren) {
        return aantalEieren >= 0;
    }

    public static boolean isValidDate(LocalDate datum) {
        if(datum.isAfter(LocalDate.now()) || datum.isBefore(LocalDate.of(2021, 1, 1))) {
            throw new IllegalStateException("Datum mag niet voor 1 januari 2021 zijn en mag ook niet in de toekomst liggen.");
        } else {
            return true;
        }
    }

    public String format() {
        return datum.getDayOfMonth() + "/" + datum.getMonth() + "/" + datum.getYear();
    }


    // setters
    public void setAchternaam(String achternaam) {
        if (isValidString(achternaam)) {
            this.achternaam = achternaam;
        } else {
            throw new IllegalArgumentException("Achternaam mag niet leeg zijn");
        }
    }

    public void setVoornaam(String voornaam) {
        if (isValidString(voornaam)) {
            this.voornaam = voornaam;
        } else {
            throw new IllegalArgumentException("Voornaam mag niet leeg zijn");
        }
    }

    public void setAantalEieren(int aantalEieren) {
        if (isValidAantalEieren(aantalEieren)) {
            this.aantalEieren = aantalEieren;
        } else {
            throw new IllegalArgumentException("Aantal eieren mag niet negatief zijn.");
        }
    }

    public void setDatum(LocalDate datum) {
        if (isValidDate(datum)) {
            this.datum = datum;
        } else {
            throw new IllegalArgumentException("Datum moet valid zijn.");
        }
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo; // extra info is niet verplicht dus mag wel leeg zijn!
    }

    public void setId(int sequence) {
        this.id = sequence;
    }

    // getters
    public int getId() {
        return this.id;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public int getAantalEieren() {
        return aantalEieren;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    @Override
    public String toString() {
        return "Id:" + this.id + "\nAchternaam: " + this.achternaam + "\nVoornaam: " + this.voornaam + "\nAantal eieren: " + this.aantalEieren + "\nDatum: " + this.datum + "\nExtra info: " + this.extraInfo;
    }
}
