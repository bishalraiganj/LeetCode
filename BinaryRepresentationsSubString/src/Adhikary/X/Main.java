package Adhikary.X;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args)
    {



    }

    public static boolean queryString(String s, int n)
    {
        boolean status = false;
        if(s.length()<=1000&&s.length()>=1&&n>=1&&n<=Math.pow(10,9)) {
            for (int i = 1; i <= n; i++) {

                double x = Math.log(i)/Math.log(2);
                double due=i;
                int curr = (int) Math.floor(Math.log(due)/Math.log(2));
                List<Integer> binaryArr = new ArrayList<Integer> ();
                if(x>1&&i!=2||i!=1)
                {
                    while(curr>1)
                    {
                        due = i-(Math.pow(2,curr));
                        binaryArr.add(curr,1);

                    }
                    if(due==1)
                    {
                        binaryArr.add(0,1);
                    }
                    if(due==2)
                    {
                        binaryArr.add(1,2);
                    }


                }


            }
        }





    }


}
