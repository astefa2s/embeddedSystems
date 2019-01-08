package org.hbrs;

import java.util.List;

public class Hand {

    private List<Karte> karten;

    public void karteHinzufuegen(Karte karte) {
        this.karten.add(karte);
    }

    public int totalHandWert(){
        int total = 0;
        for (Karte karte: karten) {
            total += karte.getWert();
        }
        return total;
    }

    public boolean ueberschritten() {
        return totalHandWert() > 21;
    }

}
