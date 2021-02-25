package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ScoreOfPar {
    public static void main(String[] args) {
        
        String s = "(()())";
        String S = "(()(()))";
        int result = scoreOfParentheses(S);
        System.out.println(result);
    }

    public static int scoreOfParentheses(String S) {
        int count = 0;
        char[] array = S.toCharArray();
        int result = 0;
        List<Integer> indexs = new ArrayList<>();
        // for(char c : array) {
        //     if(c == ')') {
        //         count ++;
        //     }
        // }

        // for(char c : array) {
        //     if(c == '(') {
        //         result ++;
        //     }

        //     if(count == result) {
        //         break;
        //     }
        // }

        for(int i = 0; i < S.length(); i++) {
            if(array[i] == '(') {
                indexs.add(i);
            }
        }
        for(int j = 0; j < indexs.size(); j++) {
            if(array[j] - array[j+1] == 1) {
                
            }
            if(array[j] - array[j+1] == 2) {

            }
        }
        return result;
    }
}