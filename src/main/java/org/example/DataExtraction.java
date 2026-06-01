package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class DataExtraction {

    List<String> extrageMeniu(String url) {
        List<String> liniiMeniu = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();

            // 1. Căutăm butonul de start al meniului ("Despre")
            for (Element a : doc.select("a")) {
                if (a.text().trim().equalsIgnoreCase("Despre")) {

                    // 2. Odată găsit, luăm lista mamă (ul-ul principal) în care se află
                    Element ulPrincipal = a.closest("ul");

                    if (ulPrincipal != null) {
                        // 3. Secretul: folosim "> li > a" ca să luăm DOAR nivelul principal, fără submeniuri!
                        Elements linkuri = ulPrincipal.select("> li > a");

                        for (Element link : linkuri) {
                            String linie = link.text().trim();

                            if (!linie.isEmpty() && linie.length() < 35) {
                                liniiMeniu.add(linie);
                            }
                        }
                    }
                    // Oprim for-ul, ne-am făcut treaba
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Eroare la extragerea: " + e.getMessage());
        }

        return liniiMeniu;
    }
}