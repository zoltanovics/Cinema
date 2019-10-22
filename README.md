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
- féláron: a jegy ára feleződik, a felhasználó akkor kapja meg, ha az admin adott neki hozzásférést (nem online zajló játékok során kaphatja meg)
- gyerek jegy: a jegy ára a normál jegy 25 százaléka
- csoportos: az összes jegy ára a jegyek összegének árának a 75 százaléka, csak akkor elérhető, ha a felhasználó minimum 20 jegyet vesz