package programmers.exhaustivesearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeTest {

    public static void main(String[] args) {
        
        int[] answers = {1,2,3,4,5};
        int[] answers2 = {1,3,2,4,2};
        int[] result = solution(answers);

        System.out.println(Arrays.toString(result));
    }

    // 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
    // 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ... %tester[0].length
    // 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

    public static int[] solution(int[] answers) {
        int[] result = new int[3];
        
        int[][] tester = {{1, 2, 3, 4, 5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == tester[0][i%tester[0].length]) {result[0]++;}
            if(answers[i] == tester[1][i%tester[1].length]) {result[1]++;}
            if(answers[i] == tester[2][i%tester[2].length]) {result[2]++;}
        }

        int max = Arrays.stream(result).max().getAsInt();
        List<Integer> list = new ArrayList<>();

        for (int k = 0; k < result.length; k++) {
            if (result[k] == max) {
                list.add(k+1);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    /* 다른사람
        public int[] solution(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }

    */
    
}