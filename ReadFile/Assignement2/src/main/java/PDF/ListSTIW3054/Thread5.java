package PDF.ListSTIW3054;

import PDF.ReadPDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.File;
import java.io.IOException;

public class Thread5 extends ReadPDF implements Runnable {

    String[] lines;

    File file = new File("C:\\Users\\USER\\Desktop\\Sem 4\\realtime\\Issue\\ReadFile\\A182 Draft Stud.pdf");
    PDDocument document;
    PDFTextStripper textStripper;

    //Get the information by using the line number
//    String getLine(int n){
//        return lines[n];
//    }

    public void run() {
        try {
            textStripper = new PDFTextStripper();
            document = PDDocument.load(file);
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            lines = text.split(System.getProperty("line.separator"));
            System.out.println();

            for(int i=0;i<lines.length;i++){
                if(lines[i].contains("STIW3054")){
                    System.out.printf("Thread-5 : Information of STIW 3054 Real-Time Programming :\n%s",lines[i]);
                }
            }
            document.close();

            Thread.sleep(2000);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
