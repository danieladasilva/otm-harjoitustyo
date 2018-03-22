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
    
    @Test //Daniela
    public void SaldoAlussaOikein() {
        assertEquals("saldo: 10", "saldo: " + kortti.saldo());
    }
    
    @Test //Daniela
    public void LataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
    
    @Test //Daniela
    public void SaldoVaheneeOikeinJosTarpeeksiRahaa() {
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.5", kortti.toString());
    }
    
    @Test //Daniela
    public void SaldoVaheneeOikeinJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }
}
