# Cinema

## Rövid ismertető:
A webalkalmazás egy mozi online foglalórendszerét valósítja meg. Foglalhatunk helyet filmekre regisztrált felhasználóként, adminként a foglalásokat tudjuk kezelni. Bejelentkezés nélkül meg tudjuk tekinteni a heti műsortervet.

## Szerepkörök:
 - regisztrálatlan felhasználó (ROLE_GUEST): látja a filmek adatait, mikor és hol vannak a vetítések, regisztrálhat az oldalra
 - regisztrált felhasználó (ROLE_USER): regisztráció utáni felhasználó, aki belépve látja a filmek adatait, jegyet vehet a vetítésekre, e során be tudja váltani a kuponjait, törölheti a foglalását
 - admin felhasználó (ROLE_ADMIN): látja a filmek és vetítések adatait, látja a jegyeket és kuponokat, valamint ezeket törölheti, újat adhat hozzá és változtathatja

## Funkcionális követelmények:
- legyen lehetőség regisztrációra a regisztrálatlan fehasználóknak
- regisztrálást követően a felhasználó be tudjon lépni, illetve ki tudjon jelentkezni
- legyen lehetőség a regisztárlt illetve admin felhasználóknak jelszóváltoztatásra
- legyen lehetőség jegyet foglalni regisztrált felhasználóként
- legyen lehetőség foglalás törlésére regisztrált felhasználóként
### SQL táblák:
![database_plan](https://github.com/zoltanovics/Cinema/blob/master/adatbazis_terv.png)

## Nem funkcionális követelmények:
 - a regisztrálatlan felhasználók nem férnek hozzá a regisztrált felhasználók és adminok adataihoz, a jegyek és kuponok rejtve vannak előle
 - a regisztrált felhasználók nem tudnak hozzáférni mások adataihoz, nem tudnak kupont kiutalni magunknak vagy másoknak, foglalásnál nem látják más néző neveit
 - méret arányos megjelenítés böngészőben a jobb átláthatóság érdekében
 - a filmek rendelkeznek műfajjal illetve leírással a jobb felhasználói élményért

## Szakterületi fogalomjegyzék:
 - user: olyan tábla, ami a regisztrált felhasználókat tárolja.
 - movie: olyan tábla, melyben a filmek vannak tárolva leírással és műfajjal
 - ticket: olyan tábla, melyben a felhasználó és a vetítés adatai vannak.
 - coupon: olyan tábla, ahol a kupon és a leírása van.
 - projection: olyan tábla, ahol a vetítések időpontja és adatai vannak.
 - room: olyan tábla, mely a termeket és a méretüket tárolja.

### Filmműfajok:
 - akciófilm: hagyományosan megtalálhatók robbanások, ökölharcok, lövöldözések, lovas és/vagy autós üldözések, agresszív jelenetek, nem megengedett 12 éven aluliak számára
 - fantasy: mítikus, képzeletbeli helyszíneken játszódó hősi kalandokat mesél el, emberfeletti, kitalált vagy földöntúli figurák főszereplésével, adott esetben mitológiai alakok feldolgozásával
 - horror: félelem- és borzalomérzetet kiváltó jelenetekkel van tele, adott eseben komikus vagy természet feletti helyzeteket dolgoz fel, nem megengedett 18 éven aluliak számára
 - romantikus: a kibontakozó vagy megújuló szerelmet két ember kapcsolatán keresztül mutatja be
 - vígjáték: a világot és szereplőket komikus helyzeteken keresztül mutatja be, ezzel a nézőt nevetésre ösztönözve
 - animációs film: a megjelenítés az animáció eszközével történik, változó témájú 
 
### Kuponfajták:
- diák: a jegy ára feleződik, a felhasználó akkor kapja meg, ha az admin adott neki hozzásférést (nem online zajló játékok során kaphatja meg)
- gyerek: a jegy ára a normál jegy 25 százaléka

## Használati eset diagram:
![use_case_diagram](https://github.com/zoltanovics/Cinema/blob/master/dia.jpg)

## Implementáció:

### Fejlesztőkörnyezet:

#### Felhasznált eszközök:
- [Git](https://git-scm.com/) verziókezelő
- [Github](https://github.com/) a projekt közzétételéhez
- [Angular](https://angular.io/) keretrendszer
- [Spring Boot](https://spring.io/projects/spring-boot) keretrendszer
- [Node.js](https://nodejs.org/en/) Javascript környezet
- [H2 adatbázis](https://www.h2database.com/html/main.html)

#### Fejlesztőkörnyezet felállítása:
1. [Git](https://git-scm.com/) verziókezelő telepítése
 [Github](https://github.com/)-on való regisztráció ajánlott
2. [Node.js](https://nodejs.org/en/) környezet telepítése
3. Projekt klónozása lokális gépre: `git clone https://github.com/zoltanovics/Cinema.git`
4. Kliens klónozása a gépre: `git clone https://github.com/zoltanovics/cinema-client.git`
5. [H2 adatbázis](https://www.h2database.com/html/main.html) letöltése
6. Projekt fordítása és futtatása (Netbeansből)
7. A kliens mappájában függőségek telepítése `npm install`
8. App indítása `npm start`

### Könyvtárstrúktúra:
- `mvn`: Maven általgenerált wrapper
- `cinema-client`: kliens helye
- `src`: forrás fájlok
 - `main` : fő forrás mappa
   - `resources` : app által felhasznált egyéb fájlok 
   - `java/hu/elte/cinema` :  gyökér mappa
     - `repositories` : repozitorik
     - `entites` : entitek
     - `controlles` : kontrollerek
 - `test/java/hu/elte/cinema` :generált teszt
 
## Felhasználói dokumentáció:
- Telepítés: lásd Fejlesztőkörnyezet felállítása
- Indítás: az npm start kiadása után töltsd be a böngészőben az oldalt
### Regisztráció, bejelentkezés:
A jobb felső sarokba lévő `Regisztráció` gombra kattintva egy űrlap kitöltése után tudunk tagokká válni, és lehetőségünk van helyet foglalni vagy jegyet venni. A regisztrációhoz név, emailcím és jelszó kell. Ha már regisztrált felhasználók vagyunk a `Regisztráció` melletti `Bejelentkezés` gombbal tudunk bejelentkezni. 
### Műfajokra szűrés, filmek böngészése:
A `Filmek` oldalon található fülek segítségével fogunk tudni a különböző műfajú filmekre rászűrni. Alapértelmezetten az összes filmet kilistázó `Minden` fül van kiválasztva, mellette lesznek a különboző típusok.
### Szobák megtekintése:
A `Filmek` oldat mellett ki tudjuk választani a `Szobák` oldalt, ahol a mozi különböző termei lesznek kilistázva mérettel együtt. Ezeket módosítani, hozzáadni csak az adminoknak lesz lehetőségük.
### Vetítések:
A `Filmek` mellett ki tudjuk választani a `Vetítések` oldalt, ahol a különboző filmekkel összekapcsolt időpontok lesznek kilistázva. Ezekre kattintva megkapjuk a részleteket, melyek tartalmazni fogják a szabad helyeket is. Itt lesz lehetőség a regisztrált felhasználóknak venni jegyet vagy helyet foglalni az adott dátumra.
### Kuponok szerkesztése:
Csak az adminok számára látható a `Kuponok` oldal, melyen a kuponok lesznek kilistázva. Ezek szerkeszthetőek, törölhetőek lesznek, és hozzá is lehet majd adni új kupont. 
