package programmers;

public class cryptogram {

    /*
암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었습니다.
예를 들어 browoanoommnaon이라는 암호문은 다음과 같은 순서로 해독할 수 있습니다.
1. "browoanoommnaon"
2. "browoannaon"
3. "browoaaon"
4. "browoon"
5. "brown"
임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성해주세요.
 */
    public class Cryptogram {
        class Solution {
            public String solution(String cryptogram) {
                StringBuilder str = new StringBuilder(cryptogram);
                String answer = "";
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    if (i != length - 1) {
                        if (str.charAt(i) == str.charAt(i + 1)) {
                            str.deleteCharAt(i);
                            str.deleteCharAt(i);
                            length -= 2;
                            i = 0;
                        }
                    }
                }
                answer = str.toString();
                return answer;
            }
        }
    }
}
