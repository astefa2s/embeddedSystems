package org.hbrs;

public class Karte {

    private String typ; // TODO enum machen
    private int zahl;
    private int wert;

    public Karte(String typ, int zahl, int wert) {
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

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
