package org.hbrs;

public class Spieler {

    private int vermoegen;
    private String name;
    private Hand hand;

    public Spieler(int vermoegen, String name) {
        this.vermoegen = vermoegen;
        this.name = name;
        this.hand = new Hand();
    }

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

    /*
     * Mindesteinsatz
     */
    public int geldSetzten(int mindesteinsatz) {
        int einsatz = -1;
        System.out.println("Bitte Geld setzten. Mindesteinsatz: "+ mindesteinsatz + " ; Vermögen: " + vermoegen);
        // TODO Spieler fragen und setzten
        // Konsoleneingabe lesen

        if (einsatz > vermoegen) {
            System.out.println("Sie haben nicht so viel Geld");
            einsatz = -1;
        }

        if (einsatz <= mindesteinsatz) {
            System.out.println("Sie haben weniger als den Mindesteinsatz gesetzt");
            einsatz = -1;
        }

        return einsatz;
    }

    public void vermoegenAktualisieren(int differenz) {
        // TODO nach Runde entweder gewonnen oder verloren
        vermoegen += differenz;
    }
}
