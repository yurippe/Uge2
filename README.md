#Spørsmål
Bruger du i dit program anonyme klasser og hjælpemetoder?
 - Knapperne dannes med en hjælpe metode, der danner objektet, tooltip
   og påsætter en ActionListener.
   
 - Vi bruger anonyme klasser, hvilket ville betyde redundant kode,
   hvis dette ikke var placeret i en hjælpemetode.

Hvilke forskellige interfaces bruger dit program?
 - Icon
    - squareIcon og CompositeIcon er begge icons.
 
 - ActionListener
    - Knapperne i SquareWindow er dannet af anonyme klasser med
	  ActionListener interfacet.

Bruger dit program andre mønstre end composite?
 - Både SquareIcon og CompositeIcon implementerer icon interfacet, og
   et CompositeIcon er i SquareWindow holder styr på alle de tilføjede
   icons. Hermed følger den præcis Composite Mønstret.

#UML Diagram
![UML](img/uml.png?raw=true)

   
#To run:
 - Go to the bin folder (On linux `cd bin`)
 - On windows, run Oppgave1.bat or Oppgave2.bat
 - On linux run `java Oppgave1.Main` or `java Oppgave2.ParkingTest`
