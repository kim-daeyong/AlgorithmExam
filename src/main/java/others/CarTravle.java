package others;

import java.util.Arrays;
import java.util.Collections;

public class CarTravle {
    public static void main(String[] args) {
        int[] P = {1,4,1};
        int[] S = {1,5,1};

        int result = solution(P, S);
        System.out.println(result);
    }

    public static int solution(int[] P, int[] S) {
        int result = 0;
        int temp = 0;
        Integer[] s = Arrays.stream(S).boxed().toArray( Integer[]::new );
        Arrays.sort(P);
        Arrays.sort(s, Collections.reverseOrder());
        Integer[] copy = s.clone();

        for (int i = 0; i < P.length; i++){
            if (s[temp] != 0 && P[i] <= s[temp]) {
                s[temp] = s[temp] - P[i];
            }
            else if (s[temp] != 0 && P[i] > s[temp]){
                int a = P[i] - s[temp];
                s[temp+1] = s[temp+1] - a;
                s[temp] = 0;
            }
            if(s[temp] == 0){
                temp ++;
            }
        }
        for (int j = 0; j <s.length; j++) {
            if(s[j] != copy[j]){
                result ++;
            }
        }
        return result;
    }
}