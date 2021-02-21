package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KWeakRow {
    public static void main(String[] args) {
        int[][] array = {
        {1,1,0,0,0},
        {1,1,1,1,0},
        {1,0,0,0,0},
        {1,1,0,0,0},
        {1,1,1,1,1}};

        int k = 2;

        int[] result = kWeakestRows(array, k);
        
		for(Integer key : result) {
			System.out.println("key : " + key);
        }
        
        System.out.println(result);
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < mat.length; i++){
            int count = 0;
            for(int num : mat[i]){
                if (num == 1){
                    count ++;
                }
            }
            map.put(i, count);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> (map.get(o1).compareTo(map.get(o2))));
        int[] result = new int[k];
		for(int j = 0; j < k; j++) {
            result[j] = list.get(j);
        }

        return result;
    }

    //메모리 너무 먹음
}