package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
public class DataExporter {
    public void salveaza(List<String> date, String numeFisier){
        try(Workbook workbook = new XSSFWorkbook()){
            Sheet sheet = workbook.createSheet("Meniu Extras");
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Nr.");
                header.createCell(1).setCellValue("Meniu");
            for(int i = 0; i < date.size(); i++){
                Row row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(i + 1 +" |");
                row.createCell(1).setCellValue(date.get(i));

            }
            try (FileOutputStream out = new FileOutputStream(numeFisier)) {
                workbook.write(out);
            }

            System.out.println("Gata! Fișierul " + numeFisier + " a fost salvat cu succes.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void newExcel(List<String> date, String numeFisier){
        File folder = new File("Output");
        if(!folder.exists()){
            folder.mkdir();
        }
        String cale = "Output" + File.separator + numeFisier;
        salveaza(date, cale);

    }
}
