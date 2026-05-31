package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
public class DataExtraction {

    List<String> extrageMeniu(String url) {
        List<String> liniiMeniu = new ArrayList<>();

        try{
           HttpClient client = HttpClient.newHttpClient();
           HttpRequest request = HttpRequest.newBuilder()
                   .uri(URI.create(url))
                   .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String html = response.body();

            String[] bucatiHtml = html.split("<a ");

            for (String bucata : bucatiHtml) {

                int inceput = bucata.indexOf(">");
                int sfarsit = bucata.indexOf("</a>");

                if (inceput != -1 && sfarsit != -1  && inceput < sfarsit) {
                    String linie = bucata.substring(inceput + 1, sfarsit).trim();

                    if(!linie.isEmpty() && !linie.contains("<") && linie.length() < 35){

                    liniiMeniu.add(linie);
                    }
                }

            }


        } catch (Exception e) {
            System.out.println("Eroare la extragerea: " + e.getMessage());
        }

        return liniiMeniu;
    }
}
