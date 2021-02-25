package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestWord {
    public static void main(String[] args) {
        // String s = "abpcplea"; 
        // List<String> d = List.of("ale","apple","monkey","plea");

        String s = "bab"; 
        List<String> d = List.of("ba","ab","a","b");
        
        String result = findLongestWord(s, d);
        System.out.println(result);
    }
    // public static String findLongestWord(String s, List<String> d) {
    //     int count = 0;
    //     List<Integer> list = new ArrayList<>();
    //     for (String str : d){
    //         for (char cha: s.toCharArray()) {
    //             for (char c: str.toCharArray()) {
    //                 if (cha == c) {
    //                         count++;
    //                 }
    //             }
    //         }
    //         list.add(count);
    //         count = 0;
    //     }
    //     for(int a : list){
            
    //     }
    //     System.out.println(list.indexOf(Collections.max(list)));
    //     return d.get(list.indexOf(Collections.max(list)));
    // }

    
    public static boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
    public static String findLongestWord(String s, List < String > d) {
        String max_str = "";
        for (String str: d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }

}