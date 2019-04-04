package PDF.TotalDateOfExam;

import PDF.ReadPDF;

import java.util.Calendar;
import java.util.Date;

public class Thread2 extends ReadPDF implements Runnable {

    public void run() {
        try {
            System.out.println("");

            Calendar fdays = Calendar.getInstance();
            Calendar ldays = Calendar.getInstance();


            fdays.set(2019, 5, 25);
            ldays.set(2019, 6, 20);

            Date Fdays = fdays.getTime();
            Date Ldays = ldays.getTime();

            long FirstDays = Fdays.getTime();
            long LastDays = Ldays.getTime();

            long diffTime = LastDays - FirstDays;

            long diffDays = (diffTime / (1000 * 60 * 60 * 24)) - 7;

            System.out.println("Thread-2 : Total days of exam : " + diffDays + " days");

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
