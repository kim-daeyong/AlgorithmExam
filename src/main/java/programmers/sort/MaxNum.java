package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxNum {
    public static void main(String[] args) {

        // [6, 10, 2]	"6210"
        // [3, 30, 34, 5, 9]	"9534330"
        int[] numbers = {3, 30, 34, 5, 9};
        String result = solution(numbers);
        System.out.println(result);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        for(Integer num : numbers){
            list.add(String.valueOf(num));
        }
        Collections.sort(list, (a, b) -> (b + a).compareTo(a + b));
        if(list.get(0).equals("0")) {
			return "0";
		}
        StringBuilder sb = new StringBuilder(); // 테스트 1 〉	통과 (252.72ms, 90.3MB)
        list.stream().forEach(n -> sb.append(n));
        answer = sb.toString();
        // for (String str : list) {  // 테스트 1 〉	통과 (1823.76ms, 359MB)
        //     answer += str;
        // }
        return answer;
    }
}