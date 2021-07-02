package programmers.exhaustivesearch;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;

        int[] result = solution(brown, yellow);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int brown, int yellow) {
        // int[] answer = new int[2];
        // int sum = brown + yellow;

        // for (int i = 1; i < sum / 2; i ++) {
        //     for (int j = 1; j < sum / 2; j++) {
        //         if (i * j == sum && (i == j || i > j)) {
        //             answer[0] = i;
        //             answer[1] = j;
        //             return answer;      
        //         }
        //     }
        // }
        // return answer;

        int[] answer = new int[2];

        // 10. 2
        
        //가로 최대 = ?
        //세로 최대 = ?
        //가로 >= 세로
        
        //둘레 = 2*n + 2*(m-2) == brown -> m + n = (brown + 4)/2
        
        //yellow = (n-2) * (m-2)
        
        //둘레
        int size = (brown+4) / 2;
        //세로
        int m = 3;
        //가로
        int n = size - m;
        
        while (n >= 3 && n >= m) {
            if ((n-2) * (m-2) == yellow) {
                answer[0] = n;
                answer[1] = m;
                break;
            }
            n--;
            m++;
        }
        
        return answer;
    }


}