package org.hbrs.test;

import org.hbrs.Spiel;
import org.hbrs.Spieler;

import java.util.Scanner;

public class SpielTest {
    public static void main(String[] args) {
        Spiel spiel = new Spiel();
        Spieler spieler1 = new Spieler(100, "Spieler1");
        Spieler spieler2 = new Spieler(100, "Spieler2");
        Spieler spieler3 = new Spieler(100, "Spieler3");
        spiel.spielerRegistrieren(spieler1);
        spiel.spielerRegistrieren(spieler2);
        spiel.spielerRegistrieren(spieler3);

        spiel.rundeSpielen();

        System.out.println("Weitere Runde spielen? (ja/nein)");
        Scanner scanner = new Scanner(System.in);
        while (scanner.next().equals("ja")) {
            spiel.rundeSpielen();
            System.out.println("Weitere Runde spielen? (ja/nein)");
        }

        System.out.println("\n Spiel beendet.\n Gewinner = " + spiel.gewinnerErnennen());

    }
}
