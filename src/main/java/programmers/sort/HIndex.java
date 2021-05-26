package programmers.sort;

import java.util.Arrays;

public class HIndex {
    
    public static void main(String[] args) {
        // [3, 0, 6, 1, 5]	3

        int[] citations = {3,0,6,1,5};
        int result = solution(citations);
        System.out.println(result);
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int h =  citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;

    }
}