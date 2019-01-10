package org.hbrs;

import java.util.HashMap;
import java.util.List;

public class Spiel {

    private Regeln regeln = new BlackJackRegeln();
    private List<Karte> deck = regeln.deckErzeugen();
    private List<Spieler> spieler;
    private Spieler dealer = new Spieler(1000, "dealer");
    private HashMap<Spieler, Integer> rundenEinsatz;

    public void deckMischen(){
        // TODO List Mischen Algorithmus online suchen
    }

    public void rundeSpielen() {
        deckMischen();
        // TODO Einsätze abholen
        int aktuellerEinsatz = 0;
        // TODO Logik einbauen, dass Spieler die raus gegangen sind nicht mehr abgefragt werden
        for (Spieler spieler: spieler) {
            int spielerEinsatz = spieler.geldSetzten(aktuellerEinsatz);
            rundenEinsatz.put(spieler, spielerEinsatz);

            if (spielerEinsatz >= aktuellerEinsatz) {
                aktuellerEinsatz = spielerEinsatz;
            }
        }
        // TODO karten vergleichen
        regeln.kartenVergleichen(); // TODO SpielerListe übergeben
    }

    // nur am Ende des Spiels
    public String gewinnerErnennen() {

        return null; // TODO gewinnername
    }

    public void spielerRegistrieren(Spieler spieler) {
        this.spieler.add(spieler);
    }
}
