#**SYSTEM ZARZĄDZANIA WINDAMI**

#Opis

- Każda z 16 wind może poruszać się w innym kierunku (lub nie poruszać się wcale). 
- Na jednym piętrze może wsiadać jedna lub więcej osób. 
- Wyboru piętra na które chcemy dojechać dokonujemy po wejściu do windy.
- System wybiera jedną z 16 wind na podstawie odległości do celu, ilości wind w kolejce oraz kierunku jazdy windy. 
- W przypadku gdy windą jedzie więcej osób, piętra są odpowiednio sortowane, np: 
znajdujemy się na 3 piętrze, jedziemy w górę, a musimy odwiedzić piętra 6,5,1,2 i 4. System posortuje liczby w następującą kolejność: 4,5,6,2,1.


#Jak uruchomić aplikację

Jest to zwykła aplikacja "sbt" - w wierszu polecenia wpisujemy kolejno 'sbt', a następie 'run Main' lub otwieramy projekt poprzez dwukrotne kliknięcie na plik 'build.sbt'


 

#Projekt

**ElevatorSys** 
Zawiera 4 podstawowe metody: 
 - `pickup` - przyjmuje zgloszenie  - piętro na które ma udać się winda oraz kierunek w jakim będziemy się poruszać
 - `update` - wykonuje aktualizację dla wybranej windy
 - `status` - zwraca listę aktualnych stanów wind (id windy, piętro na którym się znajduję oraz listę pięter docelowych)
 - `step` - umożliwia przejście kroku symulacji - przesunięcie się każdej z wind.
 
 **ElevatorSysConf** dziedziczy po **ElevatorSys** implementując jej metody.
 
 **Elevator** - klasa opisująca wszystkie czynności związane z poszczególnymi windami.
 Znajduje się tu implementacja metod takich jak: wykonywanie kroku symulacji przez windę, sortowanie pięter docelowych, dodawanie kolejnego piętra po dotarciu na miejsce zgłoszenia, czy koszt dotarcia danej windy na miejsce zgłoszenia.
 
 **ElevatorConf** zawiera opis stanu w jakim znajduje się winda - czy aktualnie przemieszcza się w górę, w dół, czy może stoi w miejscu.
 
 **Main** - umożliwia manualną komunikację z programem.
