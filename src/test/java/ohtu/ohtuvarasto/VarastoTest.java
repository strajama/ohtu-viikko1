package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);

    }

    @Test
    public void konstruktori1LuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktori1LuoTaytetynVaraston() {
        Varasto varasto2 = new Varasto(10, 1);
        assertEquals(1, varasto2.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktori1KorjaaVirheellisenVarastonKoon() {
        Varasto miinus = new Varasto(-1);
        assertEquals(0, miinus.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void konstruktori2KorjaaVirheellisenVarastonKoon() {
        Varasto miinus = new Varasto(-1, 10);
        assertEquals(0, miinus.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus1() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus2() {
        Varasto varasto2 = new Varasto(10, 1);
        assertEquals(10, varasto2.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaLiianIsoAlkusaldo() {
        Varasto iso = new Varasto(10, 20);
        assertEquals(10, iso.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaMiinusAlkusaldo() {
        Varasto minus = new Varasto(10, -10);
        assertEquals(0, minus.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysMiinusSaldoa() {
        varasto.lisaaVarastoon(-10);
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaaLiikaaSaldoa() {
        varasto.lisaaVarastoon(11);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenMiinusMääränVerran() {
        varasto.lisaaVarastoon(8);
        double saatuMaara = varasto.otaVarastosta(-10);
        // varastossa pitäisi olla tilaa 10 - 8 eli 2
        assertEquals(0, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenEnemmänKuinVarastossaOn() {
        varasto.lisaaVarastoon(8);
        double saatuMaara = varasto.otaVarastosta(10);
        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }
    
    @Test
    public void testaaToString() {
        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }
    

}
