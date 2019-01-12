package org.hbrs;

public class Karte {

    private KartenTyp typ;
    private int zahl;
    private int wert;

    public Karte(KartenTyp typ, int zahl, int wert) {
        this.typ = typ;
        this.zahl = zahl;
        this.wert = wert;
    }

    public int getZahl() {
        return zahl;
    }

    public void setZahl(int zahl) {
        this.zahl = zahl;
    }

    public int getWert() {
        return wert;
    }

    public void setWert(int wert) {
        this.wert = wert;
    }

    public KartenTyp getTyp() {
        return typ;
    }

    public void setTyp(KartenTyp typ) {
        this.typ = typ;
    }
}
