package org.hbrs;

import java.util.ArrayList;
import java.util.List;

public class BlackJackRegeln implements Regeln {

    @Override
    public void kartenVergleichen() {

    }

    @Override
    public List<Karte> deckErzeugen(){
        List<Karte> deck = new ArrayList<Karte>();

        // TODO je nachdem welche Karten benötigt werden
        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) { // TODO durch enum KartenTyp ersetzten
                int wert = i;
                if (i > 10) {
                    wert = 10;
                }
                if (i == 14) {
                    wert = 11;
                }
                Karte karte = new Karte("j", i, wert);

                deck.add(karte);
            }
        }

        return deck;
    }
}
