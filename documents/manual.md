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
exit         - closes the application  
new          - add a new reading tip  
list         - lists all reading tips  
search       - search from tips by header or description
edit header  - edit header of a tip
edit desc    - edit description of a tip
mark as read - mark a reading tip as read
delete       - delete a reading tip


## Uuden lukuvinkin lisääminen
Toimintolistauksessa komennolla "new" pääsee lisäämään uuden lukuvinkin. Lukuvinkille annetaan otsikko ja kuvaus ohjelman kysyessä niitä. Lukuvinkki tallentuu automaattisesti, kun sille on annettu kaikki tiedot.  

## Lukuvinkkien selaaminen
Toimintolistauksessa komennolla "list" pääsee tulostamaan listan tallennetuista lukuvinkeistä. Lisäkomennolla "unread" voi valita tulostettavaksi vain lukemattomat vinkit, ja lisäkomennolla "read" voi valita tulostettavaksi vain luetut vinkit. Millä tahansa muulla syötteellä tai tyhjällä saa tulostettua kaikki lukuvinkit.

## Lukuvinkkien etsiminen
Toimintolistauksessa komennolla "search" pääsee hakemaan annettavalla syötteellä (merkkijono) tallennetuista lukuvinkeistä ne vinkit, joissa annettu syöte esiintyy merkkijonona. Merkkijono voi esiintyä niin otsikossa kuin kuvauksessa, eikä se erottele isoja ja pieniä kirjaimia.  

## Lukuvinkkien muokkaaminen
Toimintolistauksessa komennolla "edit header" pääsee muokkaamaan halutun lukuvinkin otsikkoa. Ohjelma kysyy ensin muokattavan vinkin ID-numeroa, jonka näkee vinkkilistauksessa (komento "list"). Tämän jälkeen vinkille pääsee antamaan uuden otsikon. Muutos tallentuu automaattisesti, kun uuden otsikon on antanut. 

Komennolla "edit desc" pääsee muokkaamaan halutun lukuvinkin kuvausta. Ohjelma kysyy ensin muokattavan vinkin ID-numeroa. Tämän jälkeen vinkille pääsee antamaan uuden kuvauksen. Muutos tallentuu automaattisesti, kun uuden kuvauksen on antanut. 

Komennolla "mark as read" pääsee merkitsemään halutun lukuvinkin luetuksi. Ohjelma kysyy muokattavan vinkin ID-numeroa. Tämän jälkeen ohjelma muuttaa halutun vinkin tilan luetuksi. Muutos tallentuu automaattisesti, kun ID-numeron on antanut. 

Jos muokkaamistoiminnoissa ID-numerona antaa muun kuin numeron, ohjelma pyytää korjaamaan syötteen ja antamaan vain numeroita. Jos annettua ID-numeroa ei ole millään vinkillä, ohjelma ilmoittaa että ID-numeroa ei löydy, ja palaa komentolistaukseen. 

## Lukuvinkkien poistaminen
Toimintolistauksessa komennolla "delete" pääsee poistamaan halutun lukuvinkin. Ohjelma kysyy ensin poistettavan vinkin ID-numeroa. Jos annetulla ID-numerolla löytyy lukuvinkki, ohjelma pyytää varmistamaan poiston komennolla "y". Millä tahansa muulla syötteellä poistumaan poistamistoiminnosta. Jos annettua ID-numeroa ei löydy, ohjelma palaa toimintolistaukseen. 

## Ohjelman sulkeminen
Ohjelma suljetaan toimintolistauksessa komennolla "exit". 
