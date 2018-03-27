package com.mycompany.unicafe;

import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KassapaateTest {
    
    Kassapaate kassapaate;
    Maksukortti kortti;
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.kassapaate = new Kassapaate();
        this.kortti = new Maksukortti(1000); //10 euroa
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    //luodun kassapäätteen rahamäärä ja myytyjen lounaiden määrä on oikea (rahaa 1000, lounaita myyty 0)
    public void kassapaatteenRahamaaraOikea() {
        assertEquals("100000", Integer.toString(kassapaate.kassassaRahaa()));   
    }
    
    @Test 
    //luodun kassapäätteen rahamäärä ja myytyjen lounaiden määrä on oikea (rahaa 1000, lounaita myyty 0)
    public void maukkaidenLounaisenMaaraOikea() {
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    //luodun kassapäätteen rahamäärä ja myytyjen lounaiden määrä on oikea (rahaa 1000, lounaita myyty 0)
    public void edullistenLounaidenMaaraOikea() {
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
    }
    
    
    
    
    
    
    //Käteisostoa koskevat testit
    
    
    @Test 
    //jos maksu riittävä: kassassa oleva rahamäärä kasvaa lounaan hinnalla ja vaihtorahan suuruus on oikea
    public void syoEdullisestiKateisostoKasvattaaRahaaKassassaVaihtorahaOk() {
        kassapaate.syoEdullisesti(240);
        assertEquals(100240, kassapaate.kassassaRahaa());
        assertEquals(10, kassapaate.syoEdullisesti(250)); 
    }
    
    @Test
    //jos maksu riittävä: kassassa oleva rahamäärä kasvaa lounaan hinnalla ja vaihtorahan suuruus on oikea
    public void syoMaukkaastiKateisostoKasvattaaRahaaKassassaVaihtorahaOk() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(100400, kassapaate.kassassaRahaa());
        assertEquals(10, kassapaate.syoMaukkaasti(410));
    }
    
    @Test 
    //jos maksu on riittävä: myytyjen lounaiden määrä kasvaa
    public void syoEdullisestiKateisostoKasvattaaMyytyjenLounaidenMaaraa() {
        kassapaate.syoEdullisesti(240);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());     
    }
    
    @Test 
    //jos maksu on riittävä: myytyjen lounaiden määrä kasvaa
    public void syoMaukkaastiKateisostoKasvattaaMyytyjenLounaidenMaaraa() {
        kassapaate.syoMaukkaasti(400);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());     
    }
    
    @Test 
    //jos maksu ei ole riittävä: kassassa oleva rahamäärä ei muutu
    public void syoEdullisestiKateisostoKelvotonMaksuEiVaikutaRahaanKassassa() {
        kassapaate.syoEdullisesti(100);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test
    //jos maksu ei ole riittävä: kassassa oleva rahamäärä ei muutu
    public void syoMaukkaastiKateisostoKelvotonMaksuEiVaikutaRahaanKassassa() {
        kassapaate.syoMaukkaasti(100);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test 
    //jos maksu ei ole riittävä: kaikki rahat palautetaan vaihtorahana
    public void syoEdullisestiKateisostoKelvotonMaksuVaihtorahaOikein() {
        assertEquals(100, kassapaate.syoEdullisesti(100));
    }
    
    @Test
    //jos maksu ei ole riittävä: kaikki rahat palautetaan vaihtorahana
    public void syoMaukkaastiKateisostoKelvotonMaksuVaihtorahaOikein() {
        assertEquals(100, kassapaate.syoMaukkaasti(100));
    }
    
    @Test
    //jos maksu ei ole riittävä: myytyjen lounaiden määrässä ei muutosta
    public void syoEdullisestiKateisostoKelvotonMaksuLounaidenMaaraEiMuutu() {
        kassapaate.syoEdullisesti(100);
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());     
    }
    
    @Test
    //jos maksu ei ole riittävä: myytyjen lounaiden määrässä ei muutosta
    public void syoMaukkaastiKateisostoKelvotonMaksuLounaidenMaaraEiMuutu() {
        kassapaate.syoMaukkaasti(100);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());     
    }
    
    
    
    
    
    
    //Korttiostoa koskevat testit
    
    
    
    @Test 
    //jos kortilla on tarpeeksi rahaa, veloitetaan summa kortilta ja palautetaan true
    public void syoEdullisestiKorttiostoVeloittaaOikeinJaPalauttaaTrue() {
        assertEquals(true, kassapaate.syoEdullisesti(kortti));
        assertEquals(760, kortti.saldo());
    }
    
    @Test
    //jos kortilla on tarpeeksi rahaa, veloitetaan summa kortilta ja palautetaan true
    public void syoMaukkaastiKorttiostoVeloittaaOikeinJaPalauttaaTrue() {
        assertEquals(true, kassapaate.syoMaukkaasti(kortti));
        assertEquals(600, kortti.saldo());
    }
    
    @Test 
    //jos kortilla on tarpeeksi rahaa, myytyjen lounaiden määrä kasvaa
    public void syoEdullisestiKorttiostoKasvattaaMyytyjenLounaidenMaaraa() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals(1, kassapaate.edullisiaLounaitaMyyty());     
    }
    
    @Test
    //jos kortilla on tarpeeksi rahaa, myytyjen lounaiden määrä kasvaa
    public void syoMaukkaastiKorttiostoKasvattaaMyytyjenLounaidenMaaraa() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(1, kassapaate.maukkaitaLounaitaMyyty());     
    }
    
    @Test
    //jos kortilla ei ole tarpeeksi rahaa, kortin rahamäärä ei muutu, myytyjen lounaiden määrä muuttumaton ja palautetaan false
    public void syoEdullisestiKorttiostoKelvotonMaksuLounaidenMaaraEiMuutu() {
        kortti.otaRahaa(900); //kortilla 100, alussa 1000
        kassapaate.syoEdullisesti(kortti);
        assertEquals(100, kortti.saldo());
        assertEquals(0, kassapaate.edullisiaLounaitaMyyty());
        assertEquals(false, kassapaate.syoEdullisesti(kortti));
    }
    
    @Test
    //jos kortilla ei ole tarpeeksi rahaa, kortin rahamäärä ei muutu, myytyjen lounaiden määrä muuttumaton ja palautetaan false
    public void syoMaukkaastiKorttiostoKelvotonMaksuLounaidenMaaraEiMuutu() {
        kortti.otaRahaa(900); //kortilla 100, alussa 1000
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(0, kassapaate.maukkaitaLounaitaMyyty());
        assertEquals(100, kortti.saldo());
        assertEquals(false, kassapaate.syoEdullisesti(kortti));
    }
    
    @Test 
    //kassassa oleva rahamäärä ei muutu kortilla ostettaessa
    public void syoEdullisestiKorttiostoEiVaikutaKassaan() {
        kassapaate.syoEdullisesti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());     
    }
    
    @Test 
    //kassassa oleva rahamäärä ei muutu kortilla ostettaessa
    public void syoMaukkaastiKorttiostoEiVaikutaKassaan() {
        kassapaate.syoMaukkaasti(kortti);
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
    @Test 
    //kortille rahaa ladattaessa kortin saldo muuttuu ja kassassa oleva rahamäärä kasvaa ladatulla summalla
    public void kortilleLataaminenKasvattaaSaldoajaRahaaKassassa() {
        kassapaate.lataaRahaaKortille(kortti, 200);
        assertEquals(1200, kortti.saldo());
        assertEquals(100200, kassapaate.kassassaRahaa());
    }
    
    @Test
    //ladattaessa kortille rahaa kelvottomalla summalla saldolle eikä summalle kassassa tapahdu mitään
    public void KortilleLataaminenKelvottomallaSummaEiVaikutaSaldoonTaiKassaan() {
        kassapaate.lataaRahaaKortille(kortti, -200);
        assertEquals(1000, kortti.saldo());
        assertEquals(100000, kassapaate.kassassaRahaa());
    }
    
}
