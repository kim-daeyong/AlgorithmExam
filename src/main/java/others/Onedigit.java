package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Onedigit {
    public static void main(String[] args) {
        int a = 1571;

        int length = (int)(Math.log10(a)+1);

        System.out.println("길이 : "+length);

    }

    public int solution(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int num : A){
            int length = (int)(Math.log10(num)+1);
            if (length == 1) {
                list.add(num);
            }
        }
        int result = Collections.max(list);
        return result;
    }
}