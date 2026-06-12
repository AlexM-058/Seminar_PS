package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Eroare: Trebuie să oferiți numele fișierului din Program Arguments (ex: meniu_ulbs.xlsx)");
            return;
        }

        String numeFisier = args[0];


        String url = "https://ulbsibiu.ro/";

        System.out.println("Extragem meniul de pe: " + url);

        DataExtraction extractor = new DataExtraction();
        List<String> listaMeniu = extractor.extrageMeniu(url);

        if (listaMeniu.isEmpty()) {
            System.out.println("Nu s-au găsit linii de meniu!");
        } else {
            System.out.println("Am găsit " + listaMeniu.size() + " elemente. Salvăm...");
            DataExporter exporter = new DataExporter();
            exporter.salveaza(listaMeniu, numeFisier);
        }
    }
}