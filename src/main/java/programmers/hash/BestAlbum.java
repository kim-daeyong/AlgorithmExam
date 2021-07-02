package programmers.hash;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BestAlbum {
    
    public static void main(String[] args) {
        
        // ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        // list.sort(Entry.comparingByValue(Comparator.reverseOrder())); 2.5ms

        list.sort((s1, s2)->s2.getValue().compareTo(s1.getValue())); // 1.5ms

        List<Integer> result = new ArrayList<>();

        for(int j = 0; j < list.size(); j++) {
            HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
            for(int k = 0; k<genres.length; k++) {
               if(list.get(j).getKey().equals(genres[k])) {
                   hs.put(k, plays[k]);
               }
            }
           List<Integer> keyLists = new ArrayList<>(hs.keySet());
           keyLists.sort((s1, s2)->hs.get(s2).compareTo(hs.get(s1)));
           int l = 0;
           for (Integer c : keyLists) {
               if(l>1) {
                   break;
               }
               result.add(c);
               l++;
           }
        }

        // answer = result.stream().mapToInt(i->i).toArray(); 6ms 대
        answer = new int[result.size()]; // 2.5ms대
        int index = 0;
        for (Integer num : result) {
            answer[index] = num;
            index++;
        }

        return answer;
    }

}