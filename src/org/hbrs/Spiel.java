package org.hbrs;

import sun.security.provider.ConfigFile;

import java.util.*;

public class Spiel {

    private Regeln regeln = new BlackJackRegeln();
    private Stack<Karte> deck = regeln.deckErzeugen();
    private List<Spieler> spieler = new ArrayList<Spieler>();
    // Liste von Spieler, die nicht rausgegangen sind
    private List<Spieler> aktiveRundenSpieler;
    private Spieler dealer = new Spieler(1000, "dealer");
    private HashMap<Spieler, Integer> rundenEinsatz = new HashMap<Spieler, Integer>();

    public void deckMischen(){
        Collections.shuffle(deck);
    }

    // TODO Dealer Beteiligung implementieren
    /*
     * Methode für eine Runde bis aufgelöst wird und einer das Geld erhält.
     * In jeder dieser Runden kann jeder Spieler mitgehen oder raus gehen.
     */
    public void rundeSpielen() {
        // Zu Beginn einer Runde spielen alle Spieler mit
        ArrayList<Spieler> temp = (ArrayList<Spieler>) spieler;
        aktiveRundenSpieler = (ArrayList<Spieler>) temp.clone();

        Collections.copy(aktiveRundenSpieler, spieler);

        deckMischen();

        int aktuellerEinsatz = 0;

        // Einsätze sammeln
        for (Spieler spieler: aktiveRundenSpieler) {
            int spielerEinsatz = spieler.geldSetzten(aktuellerEinsatz);

            if (spielerEinsatz >= aktuellerEinsatz) {
                // Spieler bleibt drin
                aktuellerEinsatz = spielerEinsatz;
                rundenEinsatz.put(spieler, spielerEinsatz);
            } else {
                // Spieler ist raus gegangen
                aktiveRundenSpieler.remove(spieler);
            }

        }

        // Karten Verteilen
        for (Spieler spieler: aktiveRundenSpieler) {
            // Oberste Karte vom deck an die Spieler verteilen
            Karte karte = deck.pop();
            spieler.getHand().karteHinzufuegen(karte);
        }
        Karte karte = deck.pop();
        dealer.getHand().karteHinzufuegen(karte);

        // TODO Spieler dürfen beliebig oft Karten ziehen
        // unabhängig von einander
        // nur wenn sie wollen

        // Gewinner bestimmen
        Spieler rundenGewinner = regeln.kartenVergleichen(aktiveRundenSpieler);

        // Einsätze von jedem Spieler wegnehmen und gewinner geben
        for (Spieler spieler: spieler) {
            int spielerEinsatz = rundenEinsatz.remove(spieler);
            spieler.vermoegenAktualisieren(-spielerEinsatz);

            rundenGewinner.vermoegenAktualisieren(spielerEinsatz);
            spieler.handLeeren();
        }

    }

    // nur am Ende des Spiels
    public String gewinnerErnennen() {
        Spieler gewinner = spieler.get(0);
        for (Spieler spieler: spieler) {
            int vermoegen = spieler.getVermoegen();
            if (vermoegen > gewinner.getVermoegen()) {
                gewinner = spieler;
            }
        }
        return gewinner.getName();
    }

    public void spielerRegistrieren(Spieler spieler) {
        this.spieler.add(spieler);
    }
}
