package Adhikary.X;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String... args)
    {

        System.out.println((int)Math.floor(Math.log(1)/Math.log(2)));

        System.out.println(convertToBinary(100534));


    }


    public static String convertToBinary(int n)
    {



        double x = Math.log(n)/Math.log(2);
        double due=n;
        int curr = (int) Math.floor(Math.log(due)/Math.log(2));
        List<Integer> binaryArr = new ArrayList<Integer>(Collections.nCopies(curr+1,0));
        if(x>1)
        {
            while(curr>1)
            {
                due = due-(Math.pow(2,curr));
                binaryArr.set(curr,1);
                curr = (int) Math.floor(Math.log(due)/Math.log(2));


            }
            if(due==1)
            {
                binaryArr.set(0,1);
            }
            if(due==2)
            {
                binaryArr.set(1,1);
            }
            if(due==3)
            {
                binaryArr.set(1,1);
                binaryArr.set(0,1);
            }
//            binaryArr.reversed();

    }

       return binaryArr.stream()


                .collect(()->new ArrayList<>(),(ArrayList<Integer> e1,Integer e2)->e1.add(e2),(e3,e4)->e3.addAll(e4)).reversed().toString();
}
    }
