# Brick Breaker Game

Brick Breaker Game on peli, jossa pelaajan tarkoituksena on rikkoa tiilistä muodostettu seinämä pomppivan pallon ja liikutettavan alustan avulla. Alusta liikkuu vaakatasossa peli-ikkunan alareunassa. Tiilet rikkoutuvat pallon osumasta ja peli päättyy voittoon, kun kaikki tiilet on rikottu. Peli päättyy hävioon pallon osuessa "lattiaan". Pallon osuminen lattiaan yritetään estää alustan avulla. 

## Dokumentaatio

[vaatimusmaarittely](https://github.com/danieladasilva/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[työaikakirjanpito](https://github.com/danieladasilva/otm-harjoitustyo/blob/master/dokumentointi/työaikakirjanpito.md)

[arkkitehtuurikuvaus](https://github.com/danieladasilva/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Releaset

[viikko 5](https://github.com/danieladasilva/otm-harjoitustyo/releases)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla
```
mvn test
```
Testikattavuusraportti luodaan komennolla
```
mvn test jacoco:report
```
### Checkstyle

Tiedostoon [checkstylme.xml](https://github.com/danieladasilva/otm-harjoitustyo/blob/master/BrickBreakerGame/checkstyle.xml) määrittelemät tarkistukset suoritetaan komennolla

```
 mvn jxr:jxr checkstyle:checkstyle
```

Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto _target/site/checkstyle.html_

### Suoritettavan jarin generointi

Komento

```
mvn package
```

generoi hakemistoon _target_ suoritettavan jar-tiedoston _BrickBreaker.jar_
