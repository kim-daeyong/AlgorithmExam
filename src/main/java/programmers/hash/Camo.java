package programmers.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Camo {

    public static void main(String[] args) {
        
        // [["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]	5
        // [["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]	3
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result = solution(clothes);
        System.out.println(result);

    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i ++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        Set<String> set = map.keySet();

        for (String key : set) {
            answer *= map.get(key) + 1;
        }
        return answer - 1;
    }
    
}