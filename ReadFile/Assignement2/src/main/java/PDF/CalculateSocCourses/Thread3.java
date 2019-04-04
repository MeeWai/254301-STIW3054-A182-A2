package PDF.CalculateSocCourses;

import PDF.ReadPDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class Thread3 extends ReadPDF implements Runnable {

   private String [] courses;
    public Thread3(String []courses){
        this.courses=courses;
    }

    public void run() {
        try {
            File file = new File("C:\\Users\\USER\\Desktop\\Sem 4\\realtime\\Issue\\ReadFile\\A182 Draft Stud.pdf");
            PDDocument document;
            document = PDDocument.load(file);

            PDFTextStripper stripper = new PDFTextStripper();

            String text = stripper.getText(document);

            String[] lines = text.split(System.getProperty("line.separator"));

            System.out.println();

            for (int i = 0; i < lines.length; i++) {
                if (lines[i].contains("STIA1") || lines[i].contains("STIA2") || lines[i].contains("STID") ||
                        lines[i].contains("STIJ") || lines[i].contains("STIK1") || lines[i].contains("STIK2") || lines[i].contains("STIN") || lines[i].contains("STIW")
                        || lines[i].contains("STQM") || lines[i].contains("STQS")) {
                       System.out.println("Thread-3 : "+lines[i]);
                }
            }


            document.close();

            Thread.sleep(2000);

        }catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    }


