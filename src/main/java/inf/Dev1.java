package inf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Dev1 {
    public static void main(String[] args){

    int answer = 0;
    boolean flag = false;

    int[] s1 = {3,1,2,4,6,7,8,9,10};
    int[] s3 = {1,2,3,4,6,7,8,9};

//        for(int i = 0; i < s1.length ; i++) {
//            for (int j = 0; j < s3.length; j++) {
//                if (s1[i] == s1[j]) {
//                    System.out.println(s1[i]);
//                }
//            }
//        }

        for(Integer i : s1)
        {
            if(Arrays.binarySearch(s3, i) < 0)
               answer=i;
        }

//        Set<Integer> numbers = new HashSet<Integer>();
//        for (int num : s3) {
//            numbers.add(num);
//        }
//        for (int num : s1) {
//            if (numbers.contains(num)) {
//                answer=num;
//            }
//        }
        System.out.println(answer);
    }

}
