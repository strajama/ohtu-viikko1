package ohtu.ohtuvarasto;

public class Varasto {

    // --- piilotettu tietorakenteen toteutus: ---
    private double tilavuus;  // paljonko varastoon mahtuu,  > 0
    private double saldo;     // paljonko varastossa on nyt, >= 0

    // --- konstruktorit: ---
    public Varasto(double tilavuus) {  // tilavuus on annettava
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else // virheellinen, nollataan
        {
            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
        saldo = 0;     // oletus: varasto on tyhjä
    }

    public Varasto(double tilavuus, double alkuSaldo) { // kuormitetaan
        if (tilavuus > 0.0) {
            this.tilavuus = tilavuus;
        } else // virheellinen, nollataan
        {
            this.tilavuus = 0.0;  // => käyttökelvoton varasto
        }
   /*     if (alkuSaldo < 0.0) {
            this.saldo = 0.0;
        } else */
        if (alkuSaldo <= tilavuus) // mahtuu
        {
            this.saldo = alkuSaldo;
        } else {
            this.saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }
    

    // --- ottavat aksessorit eli getterit: ---
    public double getSaldo() {
        return saldo;
    }

    public double getTilavuus() {
        return tilavuus;
    }

    public double paljonkoMahtuu() {  // huom: ominaisuus voidaan myös laskea
        return tilavuus - saldo;        //  ei tarvita erillistä kenttää vielaTilaa tms.
    }

    // --- asettavat aksessorit eli setterit: ---
    public void lisaaVarastoon(double maara) {
        if (maara < 0) // virhetilanteessa voidaan tehdä 
        {
            return;       // tällainen pikapoistuminenkin!
        }
        if (maara <= paljonkoMahtuu()) // omia aksessoreita voi kutsua
        {
            saldo = saldo + maara;          // ihan suoraan sellaisinaan
        } else {
            saldo = tilavuus;  // täyteen ja ylimäärä hukkaan!
        }
    }

    public double otaVarastosta(double maara) {
        if (maara < 0) // virhetilanteessa voidaan tehdä 
        {
            return 0.0;   // tällainen pikapoistuminenkin!
        }
        if (maara > saldo) {          // annetaan mitä voidaan
            double kaikkiMitaVoidaan = saldo;
            saldo = 0.0;               // ja tyhjäksi menee
            return kaikkiMitaVoidaan;  // poistutaan saman tien
        }
        // jos tänne päästään, kaikki pyydetty voidaan antaa
        saldo = saldo - maara;  // vähennetään annettava saldosta
        int testi = 0;
        int testi2 = 2;
        int testi1 = 1;
        int testi3 = 3;
        int testi4 = 4;
        int testi5 = 0;
        int testi12 = 2;
        int testi11 = 1;
        int testi13 = 3;
        int testi14 = 4;
        int testia = 0;
        int testia2 = 2;
        int testia1 = 1;
        int testia3 = 3;
        int testia4 = 4;
        int testia5 = 0;
        int testia12 = 2;
        int testia11 = 1;
        int testia13 = 3;
        int testia14 = 4;
        int testib = 0;
        int testi2b = 2;
        int testi1b = 1;
        int testi3b = 3;
        int testi4b = 4;
        int testi5b = 0;
        int testi12b = 2;
        int testi11b = 1;
        int testi13b = 3;
        int testi1b4 = 4;
        int testci = 0;
        int testci2 = 2;
        int tescti1 = 1;
        int testci3 = 3;
        int testci4 = 4;
        int tescti5 = 0;
        int tescti12 = 2;
        int testci11 = 1;
        int testci13 = 3;
        int testci14 = 4;
        return maara;
    }

    // --- Merkkijonoesitys Varasto-oliolle: ----
    public String toString() {
        return ("saldo = " + saldo + ", vielä tilaa " + paljonkoMahtuu());
    }
}
