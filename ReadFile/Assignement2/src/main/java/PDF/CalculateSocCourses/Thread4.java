package PDF.CalculateSocCourses;

import PDF.ReadPDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class Thread4 extends ReadPDF implements Runnable {


    private File file = new File("C:\\Users\\USER\\Desktop\\Sem 4\\realtime\\Issue\\ReadFile\\A182 Draft Stud.pdf");
    private int count = 0;

    public void run() {
        try {

            PDDocument document = PDDocument.load(file);
            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);

            String[] lines = text.split(" ");

            System.out.println();

            for (int i = 0; i < lines.length; i++) {
                if (lines[i].contains("STIA1") || lines[i].contains("STIA2") || lines[i].contains("STID") ||
                        lines[i].contains("STIJ") || lines[i].contains("STIK1") || lines[i].contains("STIK2") || lines[i].contains("STIN") || lines[i].contains("STIW")
                        || lines[i].contains("STQM") || lines[i].contains("STQS")) {
                    count++;
                }
            }

            System.out.println("Thread-4 : Total courses of SOC : " + count);

            document.close();

            Thread.sleep(2000);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

