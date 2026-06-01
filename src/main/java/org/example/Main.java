package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu numele dorit pentru fișierul Excel (ex: meniu_ulbs): ");
        String numeFisier = scanner.nextLine().trim();

        // Plasă de siguranță: dacă dă doar Enter din greșeală
        if (numeFisier.isEmpty()) {
            numeFisier = "meniu_default";
            System.out.println("Nu ai introdus un nume. Se va folosi: " + numeFisier);
        }
        if (!numeFisier.endsWith(".xlsx")) {
            numeFisier += ".xlsx";
        }
        String urlFacultate = "https://inginerie.ulbsibiu.ro/";

        System.out.println("Start extragere pentru : " + urlFacultate);

        DataExtraction extraction = new DataExtraction();
        List<String> liniiMeniu = extraction.extrageMeniu(urlFacultate);

        if(liniiMeniu.isEmpty()){
            System.out.println("Nu s-au gasit linii de meniu!");
        } else {
            System.out.println("Am găsit " + liniiMeniu.size() + " elemente. Trecem la salvare...");
            DataExporter exporter = new DataExporter();
            exporter.newExcel(liniiMeniu, numeFisier);
        }
    }


}
