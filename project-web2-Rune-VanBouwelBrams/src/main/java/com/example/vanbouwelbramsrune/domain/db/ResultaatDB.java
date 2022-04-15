package com.example.vanbouwelbramsrune.domain.db;

import com.example.vanbouwelbramsrune.domain.model.Resultaat;

import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.vanbouwelbramsrune.domain.model.Resultaat.isValidDate;

public class ResultaatDB {
    private int sequence = 0;
    private final ArrayList<Resultaat> resultaten = new ArrayList<>();

    public ResultaatDB() {
        this.add(new Resultaat(1, "Bex", "Dennis", 13, LocalDate.of(2022, 2, 7), "1 gebroken ei, 6 bevruchte eieren."));
        this.add(new Resultaat(2, "Brams", "Katleen", 8, LocalDate.of(2022, 2, 9), "2 eieren die bijna uit zullen komen."));
        this.add(new Resultaat(3, "Weckx", "Sofie", 12, LocalDate.of(2022, 2, 11), "2 eieren uitgekomen."));
        this.add(new Resultaat(4, "Everaert", "Linda", 12, LocalDate.of(2022, 2, 13), "4 bevruchte eieren."));
        this.add(new Resultaat(5, "Lemmens", "Jonah", 11, LocalDate.of(2022, 2, 15), "4 eieren die bijna uit zullen komen."));
    }

    public ArrayList<Resultaat> getResultaten() {
        return this.resultaten;
    }

    public void add(Resultaat resultaat) {
        if(resultaat == null){
            throw new IllegalArgumentException("Geen DACP-resultaat meegegeven.");
        }
        this.sequence++;
        resultaat.setId(sequence);
        resultaten.add(resultaat);
    }

    public void vervangAchternaam(String achternaam, Resultaat resultaat) {
        if(achternaam == null || resultaat == null) {
            throw new IllegalArgumentException("Geen achternaam of resultaat meegegeven");
        }
        resultaat.setAchternaam(achternaam);
    }

    public void vervangVoornaam(String voornaam, Resultaat resultaat) {
        if(voornaam == null || resultaat == null) {
            throw new IllegalArgumentException("Geen voornaam of resultaat meegegeven.");
        }
        resultaat.setVoornaam(voornaam);
    }

    public void vervangAantalEieren(int aantalEieren, Resultaat resultaat) {
        if(aantalEieren < 0 || resultaat == null) {
            throw new IllegalArgumentException("Aantal eieren mag niet negatief zijn of geen resultaat meegegeven.");
        }
        resultaat.setAantalEieren(aantalEieren);
    }

    public void vervangDatum(LocalDate datum, Resultaat resultaat) {
        if(datum.isAfter(LocalDate.now()) || datum.isBefore(LocalDate.of(2021, 1, 1)) || resultaat == null) {
            throw new IllegalArgumentException("Datum moet valid zijn of geen resultaat meegegeven.");
        }
        resultaat.setDatum(datum);
    }

    public void vervangExtraInfo(String extraInfo, Resultaat resultaat) {
        if(resultaat == null) {
            throw new IllegalArgumentException("Geen resultaat meegegeven.");
        }
        resultaat.setExtraInfo(extraInfo);
    }

    public Resultaat getResultaatViaId(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException("Meegegeven id mag niet 0 of negatief zijn.");
        }
        for(Resultaat r: this.resultaten) {
            if(r.getId() == id) {
                return r;
            }
        }
        throw new IllegalArgumentException("Geen resultaat met deze id gevonden.");
    }

    public Resultaat getResultaatViaDatum(LocalDate datum) {
        if(!isValidDate(datum)){        //if(!isValidDate(datum)) = hetzelfde als if(isValidDate(datum) == false)
            throw new IllegalArgumentException("Meegegeven datum moet valid zijn.");
        }
        for(Resultaat r: this.resultaten) {
            if(r.getDatum() == datum) {
                return r;
            }
        }
        throw new IllegalArgumentException("Geen resultaat gevonden met deze datum.");
    }

    public Resultaat getResultaatMeesteAantalEieren() {
        int meesteEierenResultaat = 0;
        int idMeesteEierenResultaat = 0;
        for(Resultaat r: this.resultaten) {
            if(r.getAantalEieren() > meesteEierenResultaat) {
                meesteEierenResultaat = r.getAantalEieren();
                idMeesteEierenResultaat = r.getId();
            }
        }
        if(meesteEierenResultaat == 0 && idMeesteEierenResultaat == 0) {
            throw new IllegalStateException("Geen resultaten beschikbaar.");
        } else {
            return getResultaatViaId(idMeesteEierenResultaat);
        }
    }

    public int getTotaalAantalResultaten(){
        int count = 0;
        for (Resultaat r: this.resultaten) {
            count ++;
        }
        return count;
    }

    public void remove(Resultaat resultaat) {
        if (resultaat == null) {
            throw new IllegalArgumentException("Resultaat mag niet null of leeg zijn.");
        }
        else if (resultaten.contains(resultaat)) {
            resultaten.remove(resultaat);
        } else {
            throw new IllegalArgumentException("Resultaat staat niet in de lijst.");
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Resultaten DACP: \n");
        for (Resultaat r: this.resultaten) {
            result.append(r.toString()).append("\n");
        }
        return result.toString();
    }
}
