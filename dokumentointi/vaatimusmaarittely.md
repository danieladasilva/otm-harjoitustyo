## Vaatimusmäärittely ##


#### Sovelluksen tarkoitus ####

Brick Breaker Game (yksinkertainen versio) on peli, jossa pelaajan tarkoituksena on rikkoa tiilistä muodostettu seinämä pomppivan pallon ja liikutettavan alustan avulla. Alusta liikkuu vaakatasossa peli-ikkunan alareunassa. Tiilet rikkoutuvat pallon osumasta ja peli päättyy voittoon, kun kaikki tiilet on rikottu. Peli päättyy hävioon pallon osuessa "lattiaan". Pallon osuminen lattiaan yritetään estää alustan avulla. Peli pitää myös kirjaa pelaajien pisteistä.

#### Käyttäjät ####

Sovellus sisältää ainoastaan yhden käyttäjätyypin, pelaajan.

#### Käyttöliittymäluonnos ####

Sovellus koostuu ainoastaan yhdestä näkymästä, pelinäkymästä. Pelin päättyessä ilmestyy näkymään ilmoitus voitosta/häviöstä tekstinä. Pelin aloittaminen uudestaan enter-näppäimellä poistaa tekstit ja näyttää jälleen pelkän pelinäkymän.

#### Toiminnallisuudet ####

- pelinäkymä sisältää taustan, reunat, tiiliseinämän, pallon, tämänhetkiset pisteet ja tiedon parhaasta pistetuloksesta sekä liikutettavan laudan.

- sovellus tallentaa kaikki pelaajan saavuttamat pisteet tietokantaan (paras pistetulos näytetään pelinäkymän vasemmassa yläreunassa, sen hetkinen pistetilanne näytetään pelinäkymän oikessa yläreunassa)

- pelin päättyessä voittoon/häviöön ilmoitetaan siitä pelaajalle tekstimuodossa

- pelin ohjaaminen tapahtuu näppäimistön avulla seuraavasti:
    - peli käynnistetään nuoli- tai välilyöntinäppäimen avulla
    - lautaa liikutetaan nuolinäppäimillä
    - pelin pysäyttäminen/uudelleen käynnistäminen onnistuu välilyöntinäppäimellä 
    - pelin päättyessä voidaan uusi peli käynnistää enter-painiketta painamalla


#### Jatkokehitysideoita ##

