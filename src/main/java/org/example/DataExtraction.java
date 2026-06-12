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
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .referrer("https://ulbsibiu.ro/")
                    .timeout(15_000)
                    .get();
          Elements elemente = doc.select("#primary-menu > li > a.nav-link");

              for(Element e : elemente){
                  String line = e.text().trim();
                  if(!line.isEmpty())
                      liniiMeniu.add(line);
              }


        } catch (Exception e) {
            System.out.println("Eroare la extragerea: " + e.getMessage());
        }

        return liniiMeniu;
    }
}
