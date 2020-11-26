# Käyttöohje

Lataa sovelluksen uusin versio [releases-listasta](https://github.com/H4m5t3r/Lukuvinkkikirjasto/releases). Valitse tiedosto Lukuvinkkikirjasto.jar, ja lataa se koneellesi. 

Ohjelmaa käytetään komentoriviltä. Ohjelma on englanninkielinen.

## Ohjelman käynnistäminen
Ohjelma käynnistetään komennolla 
```
java -jar Lukuvinkkikirjasto.jar
```
Ohjelma luo käynnistämisen yhteydessä käynnistyshakemistoon tietokantatiedoston, jos sitä ei vielä ollut olemassa. Tätä tiedostoa ei tule poistaa, jos haluaa vielä käyttää käytön aikana tallentamiaan tietoja. Jos tiedot saa hävittää, niin tietokantatiedoston voi poistaa. Jos tietokantatiedoston on poistanut, niin ohjelma luo seuraavalla käynnistyskerralla uuden tietokantatiedoston.

## Aloitus
Sovellus avautuu näkymään, jossa luetellaan toiminnot, joita ohjelmassa on:

Here are the available commands:  
exit - closes the application  
new  - add a new reading tip  
list - lists all reading tips  

## Uuden lukuvinkin lisääminen
Toimintolistauksessa komennolla "new" pääsee lisäämään uuden lukuvinkin. Lukuvinkille annetaan otsikko ja kuvaus ohjelman kysyessä niitä. Lukuvinkki tallentuu automaattisesti, kun sille on annettu kaikki tiedot.  

## Lukuvinkkien selaaminen
Toimintolistauksessa komennolla "list" tulostuu lista kaikista tallennetuista lukuvinkeistä. 

## Ohjelman sulkeminen
Ohjelma suljetaan toimintolistauksessa komennolla "exit". 
