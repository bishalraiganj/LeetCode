package Adhikary.X;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String... args)
    {

        String[] firstTest = findOccurences("alice is a good girl she is a good student","a","good");
        System.out.println(Arrays.toString(firstTest));

        String[] secondTest = findOccurences("we will we will rock you","we","will");
        System.out.println(Arrays.toString(secondTest));







    }

    public static String[] findOccurences(String text,String first,String second)
    {

        String[] s = text.split(" ");

        List<String> result = new ArrayList<>();
        int i=0;
        for(String word : s) {
            if (word.equals(first) && (i+1<s.length)&&(s[i+1].equals(second))&&(i+2<s.length))
            {


                    result.add(s[i + 2]);
            }
            i++;
        }

        return result.toArray(new String[0]);






    }

}
