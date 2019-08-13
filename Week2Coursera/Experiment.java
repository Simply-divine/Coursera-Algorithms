package Week2Coursera;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

import java.io.File;
import java.util.Comparator;
import java.util.Random;

class Experiment {
    public static void main(String[] args) {
      //  File directory= new File(args[0]);
      //  File[] files=directory.listFiles();
        System.out.println(20>>>1);
//       // Insertion.sort();
//        for (int i = 0; i <files.length ; i++) {
//            System.out.println(files[i].getName());
//        }
        Random random=new Random(-200);

        int n=10000;
        int m=n-1;
        for (int i= 0;i<100;i++) {
            long r=random.nextLong()-50;
            System.out.println(r);
            long u = r >>> 1;
   //         r = u % n;
            while (u + m - (r = u % n) < 0L) {
                u = random.nextLong() >>> 1;
                System.out.println("u="+u);
     //           System.exit(0);
            }
            System.out.println("r="+r);
        }

    }
    
}