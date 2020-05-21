# Algorithmen und Datenstrukturen Tools

Eine vermutlich wachsende Sammlung an Tools für Algorithmen und Datenstrukturen.

Die Tools/Programme generieren Schritt für Schritt Lösungen zu verschiedenen Problemen.

Vorschläge/Ideen, was euch helfen würde gerne an [kuni1021@hs-karlsruhe.de](mailto:kuni1021@hs-karlsruhe.de).

## Installation

Einfach die .jar Datei für das Tool, das du willst herunterladen.

Den Sourcecode zu jeder .jar findest du im jeweiligen Ordner in src.

Natürlich könnt ihr euch auch den Sourcecode downloaden und anschauen/verändern.

Allerdings ist der Code NICHT für die ausführung in Eclipse/IntelliJ oder andere IDEs optimiert/gemacht.

Die Tools sind darauf ausgelegt im Terminal bzw. der Konsole/CMD, oder wie ihr es nennt, ausgeführt zu werden.

Hauptausgelegt ist die Funktionalität für Windows, da dieses Betriebssystem einfach am verbreitesten ist.

Trotzdem sollte der Code eigentlich auch auf MacOS oder Linux Betriebssystemen laufen.

## Anleitung

**Generell**

1. CMD/Terminal öffnen
2. Zum Speicherort der .jar Datei navigieren 
(mit `cd %USERPROFILE%/Downloads` kommt ihr bei Windows zum Beispiel zu eurem Downloadordner, %USERPROFILE% müsst ihr NICHT ersetzen)
3. Die .jar Datei ausführen mit `java -jar [TOOLNAME].jar`
4. Für weitere Schritte siehe unter der jeweiligen Toolanleitung hier drunter...

**Auswahlproblem**

**WICHTIG:** Das Tool gibt euch zwar Musterlösungen, so wie es *P* will, allerdings müsst ihr zuerst den Algorithmus verstehen :)

Das Tool bringt hauptsächlich zum üben etwas, da ihr euch damit Lösungen zu eigenen Beispielaufgaben generieren könnt.

In den Vorlesungsfolien findet ihr das Auswahlproblem mitsamt 3-Wege-Partitionierung bei 03-suchen (Folie 27).

Das Auswahlproblem sucht nach dem k kleinsten Element in einem unsortierten Array.

Beispiel:

[ 2, 4, 1, 8, 6, 2, 5 ]

--> Welches Zahl ist die 3. kleinste?

---

Um den Algorithmus ***auswaehlen*** aus *P*'s Folien auszuführen müsst ihr zuerst -aus in das Programm eingeben.

Dann fragt das Programm nach dem Array. Dieses darf nur Zahlen von 0 bis 9 enthalten. (Reicht normal für die Aufgaben von *P*)

Die einzelnen Werte für das Array trennt ihr einfach durch jeweils ein Leerzeichen. (Nach dem letzten Wert kein Leerzeichen)

Danach will das Programm wissen, welchen Wert k hat, also das wievielt kleinste Element ihr sucht.

Danach gibt euch das Programm zunächst den Aufrufbaum von auswaehlen auf.

Darunter findet ihr für jeden Aufruf des in ***auswaehlen*** genutzen Algorithmus ***Partitionieren*** Schritt für Schritt den Ablauf und die Erklärung zu jedem Schritt.

Ganz unten ist dann noch das Ergebnis von ***auswaehlen***.


---

Wenn ihr nur die 3-Wege-Partitionierung, also ***Partitionieren*** ausführen wollt, gebt ihr nach starten des Programms -part ein.

Danach fragt euch das Programm wieder nach dem Array. 

Nachdem ihr ENTER drückt, führt das Programm dann einmal ***Partitionieren*** aus und gibt wieder Schritt für Schritt den Ablauf aus.


## Lizenz

Dieses Projekt wurde mit der MIT Lizenz nach Github veröffentlicht. Siehe [Lizenz Datei](./LICENSE.md) für Lizenzrechte und -limitierungen.