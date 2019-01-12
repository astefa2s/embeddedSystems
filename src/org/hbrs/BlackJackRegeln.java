package org.hbrs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BlackJackRegeln implements Regeln {

    @Override
    public Spieler kartenVergleichen(List<Spieler> aktiveRundenSpieler) {
        Spieler bester = aktiveRundenSpieler.get(0);
        for (Spieler spieler: aktiveRundenSpieler) {
            int handwert = spieler.getHand().totalHandWert();
            System.out.println("Kartenwert von spieler " + spieler.getName() + " = " + handwert);

            if (handwert > bester.getHand().totalHandWert()) {
                // dieser Spieler ist neuer bester
                bester = spieler;
            }
        }

        return bester;
    }

    @Override
    public Stack<Karte> deckErzeugen(){
        Stack<Karte> deck = new Stack<Karte>();

        // Karten Zahl: 2 - 14
        for (int i = 2; i <= 14; i++) {

            for (KartenTyp typ: KartenTyp.values()) {
                int wert = i;
                if (i > 10) {
                    wert = 10;
                }
                if (i == 14) {
                    wert = 11;
                }
                Karte karte = new Karte(typ, i, wert);

                deck.add(karte);
            }
        }

        return deck;
    }
}
