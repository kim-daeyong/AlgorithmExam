package programmers.stackqueue;

import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] result = solution(prices);

        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] >= prices[i]) {
                    answer[i] ++;
                } else {
                    answer[i] ++;
                    break;
                }
            }
        }

        return answer;
    }
}
