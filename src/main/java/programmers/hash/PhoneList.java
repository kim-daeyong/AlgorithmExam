package programmers.hash;

import java.util.Arrays;

public class PhoneList {
    
    public static void main(String[] args) {
        // ["119", "97674223", "1195524421"]	false

        // String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book = {"123","456","789"};
        boolean result = solution(phone_book);
        System.out.println(result);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);

        System.out.println(Arrays.toString(phone_book));
        for (int j = 0; j < phone_book.length - 1; j++) {
            if (phone_book[j + 1].startsWith(phone_book[j])) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}