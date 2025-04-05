package Adhikary.X;

import java.util.*;

public class Main {

    static Map<String,String> allBinaries=new LinkedHashMap<>();
    public static void main(String... args)
    {

        System.out.println(convertToBinary(9));
        System.out.println("-".repeat(50));

        System.out.println(queryString("110101011011000011011111000000", 8));

        System.out.println(allBinaries.toString());




    }

    public static boolean queryString(String s, int n)
    {
        boolean status = false;
        boolean stringStatus = false;
        for (Character c : s.toCharArray())
        {
            if(!(c=='0'||c=='1')) {
//                stringStatus = true;
//                continue;
                return false;
            }
            stringStatus = true;
        }

        if(stringStatus&&s.length()<=1000&&s.length()>=1&&n>=1&&n<=Math.pow(10,9)) {
            for (int i = 1; i <= n; i++) {

                if(!s.contains(convertToBinary(i)))
                {
//                    allBinaries.put(i+"",convertToBinary(i));
//                    status = true;
//                    continue;
                    return false;
                }




                allBinaries.put(i+"",convertToBinary(i));
                status =true;
            }
        }
        return status;
    }

    public static String convertToBinary(int n)
    {

        if(n==0)
        {
            return "0";
        }
        if(n==1)
        {
            return "1";
        }
        if(n==2)
        {
            return "10";
        }

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
                .map((i)->i+"")
                .collect(()->new ArrayList<>(),(ArrayList<String> e1,String e2)->e1.add(e2),(e3,e4)->e3.addAll(e4)).reversed() // This reversed () method works , because i am using Java 21+ older versions do not return the reversed immutable view of the list
//   Algorithm Written and Designed by Bishal Adhikary :-)
                .stream()
                .reduce("",(s,s1)->s+""+s1);
    }


}
