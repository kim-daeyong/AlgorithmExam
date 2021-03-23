package leetcode;

import java.util.ArrayList;
import java.util.List;

public class DistributeCandies {
    public static void main(String[] args) {
        int[] candyType = {1,1,2,2,3,3};
        // int[] candyType = {6,6,6,6};
        // int[] candyType = {1,1,2,3};
        // int[] candyType = {1,0,1,0,1,0,1,0};
        // int[] candyType = {1,1,1,1,2,2,2,3,3,3};
        int result = distributeCandies(candyType);
        System.out.println(result);
    }

    public static int distributeCandies(int[] candyType) {
        int result = 1;
        List<Integer> list = new ArrayList<>();
        list.add(candyType[0]);
        for (int i = 0; i < candyType.length; i++) {
            if (i == candyType.length-1 || result == candyType.length / 2){
                break;
            }
            if (candyType[i] != candyType[i+1]) {
                list.add(candyType[i+1]);
            }
            if (i > 0 && compareCandy(list, candyType[i], i)) {
                result ++;
            }
        }
        System.out.println(list.size());
        return result;
    }

    public static boolean compareCandy(List<Integer> list, int candy, int i) {
        boolean result = false;
        if (candy != list.get(i-1)){
            result = true;
        }
        return result;
    }
}