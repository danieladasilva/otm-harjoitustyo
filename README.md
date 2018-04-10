# Brick Breaker Game

Brick Breaker Game on peli, jossa pelaajan tarkoituksena on rikkoa tiilistä muodostettu seinämä pomppivan pallon ja liikutettavan alustan avulla. Alusta liikkuu vaakatasossa peli-ikkunan alareunassa. Tiilet rikkoutuvat pallon osumasta ja peli päättyy voittoon, kun kaikki tiilet on rikottu. Peli päättyy hävioon pallon osuessa "lattiaan". Pallon osuminen lattiaan yritetään estää alustan avulla. 

## Dokumentaatio

[vaatimusmaarittely](https://github.com/danieladasilva/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[tyoaikakirjanpito](https://github.com/danieladasilva/otm-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)


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
