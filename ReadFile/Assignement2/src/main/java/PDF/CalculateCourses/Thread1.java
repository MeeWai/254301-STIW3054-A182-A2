package PDF.CalculateCourses;

import PDF.ReadPDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class Thread1 extends ReadPDF implements Runnable {


    public void run() {

        try {
            int count = 0;
            File file = new File("C:\\Users\\USER\\Desktop\\Sem 4\\realtime\\Issue\\ReadFile\\A182 Draft Stud.pdf");
            PDDocument document;
            document = PDDocument.load(file);

            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);

            String[] lines = text.split(System.getProperty("line.separator"));

            System.out.println();

            for (int i = 0; i < lines.length; i++) {
                if (lines[i].contains(".")&&!lines[i].contains("BIL.")) {
                    count++;
                }
            }

            System.out.println("Thread-1 : Total courses of UUM : "+count);

            document.close();

            Thread.sleep(2000);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}



