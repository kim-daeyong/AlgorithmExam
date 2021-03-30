package programmers.hash;

import java.util.Arrays;

public class NoComplete {


    /*
    수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.

마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

     */

    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            String temp = "";
            Arrays.sort(participant);
            Arrays.sort(completion);
            for (int i=0; i < completion.length; i++){
                if (!participant[i].equals(completion[i])){
                    return temp = participant[i];
                }
            }
            if(!temp.equals("")){
                answer = temp;
            }else{
                answer = participant[participant.length-1];
            }
            return answer;
    
    }
}

/*
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String answer = "";

        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i]))
                map.replace(completion[i], map.get(completion[i]) + 1);
            else
                map.put(completion[i], 1);
        }

        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                if (map.get(participant[i]) > 1)
                    map.replace(participant[i], map.get(participant[i]) - 1);
                else
                    map.remove(participant[i]);
            } else {
                return participant[i];
            }
        }

        return answer;
    }
}
 */



    /*
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }



     */
}
