package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    //kortin saldo alussa oikein
    public void saldoAlussaOikein() {
        assertEquals("saldo: 10", "saldo: " + kortti.saldo());
    }
    
    @Test
    //rahan lataaminen kasvattaa saldoa oikein
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
    
    @Test
    //saldo vähenee oikein, jos rahaa on tarpeeksi
    public void saldoVaheneeOikeinJosTarpeeksiRahaa() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.5", kortti.toString());
    }
    
    @Test
    //saldo ei muutu, jos rahaa ei ole tarpeeksi
    public void saldoEiMuutuJosEiTarpeeksi() {
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    //metodi palauttaa true, jos rahat riittivät
    public void palauttaaFalseJosKateEiRiita() {
        assertEquals(false, kortti.otaRahaa(20));
    }
    
    @Test 
    //metodi palauttaa false, jos rahat eivät riitä
    public void palauttaaTrueJosKateRiittaa() {
        assertEquals(true, kortti.otaRahaa(5));
    }
    
    
}
