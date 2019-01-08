package org.hbrs;

public class Spieler {

    private int vermoegen;
    private String name;
    private Hand hand;

    public int getVermoegen() {
        return vermoegen;
    }

    public void setVermoegen(int vermoegen) {
        this.vermoegen = vermoegen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void geldSetzten(int betrag) {
        if (betrag <= vermoegen) {
            // TODO Geld setzten
            // muss Spiel nicht auch einen Geld-Pot haben?
        }
    }

    public void vermoegenAktualisieren(int differenz) {
        // TODO nach Runde entweder gewonnen oder verloren
    }
}
