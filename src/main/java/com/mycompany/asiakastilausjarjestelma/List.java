package com.mycompany.asiakastilausjarjestelma;

import java.util.Date;

public class List {

    //Tilaus
    private int tilausnumero;
    private int asiakasnumero;
    private Date tilauspäivä;
    private Date toimituspäivä;
    private Date eräpäivä;
    private int maksutapa;
    private String lisätietoja;
    //TilausRivi
    private int tilausRiviTuotenumero;
    private int tilausRiviMaara;
    private double tilausRiviAhinta;
    private int tilausrivinumero;
    //Tuote
    private String tuoteTuotenimi;

    public List(int tilausnumero, int asiakasnumero, Date tilauspaiva,
            Date toimituspaiva, Date erapaiva, int maksutapa, String lisatietoja) {
        //Tilaus
        this.tilausnumero = tilausnumero;
        this.asiakasnumero = asiakasnumero;
        this.tilauspäivä = tilauspaiva;
        this.toimituspäivä = toimituspaiva;
        this.eräpäivä = erapaiva;
        this.maksutapa = maksutapa;
        this.lisätietoja = lisatietoja;
    }

    public List(String tuoteTuotenimi, int tilausRiviMaara, double tilausRiviAhinta, int tilausrivinumero) {
        //TilausRivi
        this.tuoteTuotenimi = tuoteTuotenimi;
        this.tilausRiviMaara = tilausRiviMaara;
        this.tilausRiviAhinta = tilausRiviAhinta;
        this.tilausrivinumero = tilausrivinumero;
    }

    public int HaeTilausriviNumero() {
        return this.tilausrivinumero;
    }

    public int HaeTilausnumero() {
        return this.tilausnumero;
    }

    public int HaeAsiakasnumero() {
        return this.asiakasnumero;
    }

    public Date HaeTilauspäivä() {
        return this.tilauspäivä;
    }

    public Date HaeToimituspäivä() {
        return this.toimituspäivä;
    }

    public Date HaeEräpäivä() {
        return this.eräpäivä;
    }

    public int HaeMaksutapa() {
        return this.maksutapa;
    }

    public String HaeLisätietoja() {
        return this.lisätietoja;
    }

    //TilausRivi
    public int HaeTilausRiviTuotenumero() {
        return this.tilausRiviTuotenumero;
    }

    public int HaeTilausRiviMaara() {
        return this.tilausRiviMaara;
    }

    public double HaeTilausRiviAhinta() {
        return this.tilausRiviAhinta;
    }

    //Tuote
    public String HaeTuotenimi() {
        return this.tuoteTuotenimi;
    }
}
