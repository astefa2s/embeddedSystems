package org.hbrs;

import java.util.List;
import java.util.Stack;

public interface Regeln {

    public Spieler kartenVergleichen(List<Spieler> aktiveRundenSpieler);

    public Stack<Karte> deckErzeugen();

}
