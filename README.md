# Extragere Meniu ULBS - Colocviu Seminar

**Autor:** Alexandru-Matei Tarîta  
**Specializare:** Tehnologia Informației (TI)  
**Curs:** Paradigme de programare / Proiectare Software  

## Descrierea Proiectului
Această aplicație Java a fost dezvoltată pentru a accesa și extrage automat elementele meniului principal de pe site-ul oficial al Universității „Lucian Blaga” din Sibiu (https://ulbsibiu.ro/). Datele extrase sunt ulterior exportate și formatate într-un fișier Excel (`.xlsx`). 

Proiectul respectă în totalitate cerințele colocviului, incluzând preluarea numelui fișierului rezultat direct din argumentele liniei de comandă (Command Line Arguments).

## Tehnologii și Librării Utilizate
Proiectul folosește **Java** și este gestionat prin **Maven**. Dependențele principale sunt:
* **JSoup (v1.20.1):** Utilizat pentru conectarea la URL și parsarea documentului HTML.
* **Apache POI (v5.2.5):** Utilizat pentru crearea și scrierea datelor în formatul `.xlsx`.
* **Apache Log4j2 (v2.23.1):** Necesare pentru gestionarea avertismentelor interne generate de POI (core și api).

## Structura Codului
Proiectul conține 3 clase principale situate în pachetul `org.example`:

1. **`Main.java`**
   * Punctul de intrare în aplicație.
   * Validează și preia numele fișierului Excel din `args[0]`.
   * Coordonează procesul instanțiind clasele de extracție și export.

2. **`DataExtraction.java`**
   * Se conectează la `https://ulbsibiu.ro/` folosind JSoup.
   * Identifică strategic meniul principal (pornind de la nodul "Despre") și extrage exclusiv elementele principale (copiii direcți), ignorând submeniurile.
   * Returnează o listă curată de tip `String` cu intrările găsite.

3. **`DataExporter.java`**
   * Preia lista de String-uri și o randează într-un fișier Excel generat local.
   * Formatează fiecare rând respectând șablonul cerut (ex: `1| Despre`, `2| Admitere`, etc.).

## Instrucțiuni de Rulare (IntelliJ IDEA)
Pentru a rula și testa aplicația corect cu argumente din linia de comandă:

1. Deschideți fereastra **Run/Debug Configurations** din meniul superior (lângă butonul de Play).
2. Adăugați o configurație nouă de tip **Application**.
3. Selectați clasa principală: `org.example.Main`.
4. La secțiunea **Program arguments**, introduceți numele dorit pentru fișierul generat (ex: `meniu_ulbs.xlsx`).
5. Rulați configurația. Fișierul Excel rezultat va fi salvat automat în directorul rădăcină al proiectului.
