package PDF;

import PDF.CalculateCourses.Thread1;
import PDF.CalculateSocCourses.Thread3;
import PDF.CalculateSocCourses.Thread4;
import PDF.ListSTIW3054.Thread5;
import PDF.TotalDateOfExam.Thread2;


public class ReadPDF {

    private static String[] courses;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Thread1());
        t1.start();
        t1.join();

        Thread t2=new Thread(new Thread2());
        t2.start();
        t2.join();

        Thread t3 = new Thread(new Thread4());
        t3.start();
        t3.join();

        Thread t4 = new Thread(new Thread3(courses));
        t4.start();
        t4.join();

        Thread t5 = new Thread(new Thread5());
        t5.start();
        t5.join();


    }


}
