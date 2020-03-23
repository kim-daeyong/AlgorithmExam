package inf;

import java.util.*;

public class Dev2 {

    public static void main(String[] args) {

        String s2 = "cookie";
        String s1 = "cookoie";

        String result = "";
        String preStr = "";
        String nextStr = "";

        boolean answer = true;

        String[] arr1=s1.split("");

        String[] arr2=s2.split("");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

//        if (Arrays.equals()) {
//            answer=false;
//        }
//
//
//        Set<String> strs1 = new HashSet<String>();
//        Set<String> strs2 = new HashSet<String>();
//        for (String str : arr1) {
//            strs1.add(str);
//        }
//        for (String str : arr2) {
//            strs2.add(str);
//        }
//        if(strs1.size()!=strs2.size()){
//            answer=false;
//        }else{
//            for (String str : arr2) {
//                if (!arr1.equals(str)) {
//                    answer=false;
//                }
//            }
//        }

        List<Integer> list = dupl(s1);
        List<Integer> list1 = dupl(s2);
        if(list.size()!=list1.size()){
            answer = false;
        }

        System.out.println(list.size());
        System.out.println(list1.size());

        System.out.println(answer);
    }

    public static List<Integer> dupl(String s1) {

        String result = "";
        String preStr = "";
        String nextStr = "";
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= s1.length(); i++) {
            if (i == s1.length()) {
                nextStr = s1.substring(i);
            } else {
                nextStr = s1.substring(i, i + 1);
            }

            if (nextStr.equals(preStr)) {
                count++;
            } else {
                if (!preStr.equals("")) {
//                    result = result + preStr + String.valueOf(count+1);
                    list.add((count + 1));
                    count = 0;
                }
            }

            preStr = nextStr;
        }
    return list;
    }
}
