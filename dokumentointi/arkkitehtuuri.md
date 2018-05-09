## Arkkitehtuurikuvaus ##

#### Rakenne ####

Ohjelman rakenne muodostuu neljästä pakkauksesta seuraavasti:

- pakkaus fi.daniela.gui sisältää JavaFX:llä toteutetun graafisen käyttöliittymän
- pakkaus fi.daniela.logics sisältää sovelluslogiikan
- pakkaus fi.daniela.dao sisältää pysyväistallennuksesta vastaavan toteutuksen
- pakkaus fi.daniela.main sisältää luokan Main

Ohjelman pakkausrakenne kaaviona:

![pakkauskaavio 2](https://user-images.githubusercontent.com/36673150/39534835-30c6f176-4e3b-11e8-8ab8-927c89b8e9aa.jpg)

#### Käyttöliittymä ####

Käyttöliittymä sisältää yhden näkymän, pelinäkymän. Käyttöliittymä on rakennettu pakkauksen fi.daniela.gui luokkaan GamePanel. Käyttöliittymäluokka on pyritty eristämään toiminnoiltaan kokonaan sovelluslogiikasta vastaavan pakkauksen fi.daniela.logics luokista.

#### Sovelluslogiikka ####

![luokkakaavio](https://user-images.githubusercontent.com/36673150/39197906-61d66bf0-47ee-11e8-990c-33fbfbeed084.png)

#### Tietojen pysyväistallennus ####

Tietojen pysyväistallennus on toteutettu tietokantaa käyttämällä. Pakkaus fi.daniela.dao huolehtii ohjelman pysyväistallennuksesta. 

Pakkauksen luokat Dao, Database ja ScoreDao noudattavat Data Access Object -suunnittelumallia.

#### Päätoiminnallisuuksia ####

#### Ohjelman rakenteeseen jääneet heikkoudet ####

Käyttöliittymä: Pakkauksen fi.daniela.gui luokka GamePanel jäi rakenteltaan hieman vaikealukuiseksi. Luokka sisältää turhan paljon asioita, ja luokka olisikin ehkä ollut syytä jakaa lyhyempiin ja selkeämpiin luokkiin.
