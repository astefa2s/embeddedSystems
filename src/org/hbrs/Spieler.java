package org.hbrs;

import java.util.Scanner;

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

    public void handLeeren() {
        setHand(new Hand());
    }

    /*
     * Mindesteinsatz
     * TODO die Logik für Input/Output in eigene GUI Klasse verschieben
     * TODO Dabei eventuell Pattern anwenden (strategy zum Beispiel)
     */
    public int geldSetzten(int mindesteinsatz) {
        int einsatz = -1;
        System.out.println(this.getName() + " bitte Geld setzten. Mindesteinsatz: "+ mindesteinsatz + " ; Vermögen: " + vermoegen);
        // TODO Spieler fragen und setzten
        // Konsoleneingabe lesen
        Scanner scanner = new Scanner(System.in);
        einsatz = scanner.nextInt();


        if (einsatz > vermoegen) {
            System.out.println("Sie haben nicht so viel Geld");
            einsatz = -1;
        }

        if (einsatz < mindesteinsatz) {
            System.out.println("Sie haben weniger als den Mindesteinsatz gesetzt");
            einsatz = -1;
        }

        return einsatz;
    }

    public void vermoegenAktualisieren(int differenz) {
        vermoegen += differenz;
    }
}
