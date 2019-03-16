package programmers;

public class Frog {

    /*
문제 설명
어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었습니다.
청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였습니다.
엄마 말씀 word가 매개변수로 주어질 때, 아래 청개구리 사전을 참고해 반대로 변환하여
return 하도록 solution 메서드를 완성해주세요.
입출력 예
word	result
I love you	R olev blf
 */
    public class Chung {
        public String solution(String word) {
            String result = "";

            char[] carray = word.toCharArray();
            for(int i = 0; i < carray.length; i++) {
                if(Character.isUpperCase(carray[i])) {
                    int asc = (int)carray[i];
                    int newAsc = 155 - asc;
                    Character.toString((char) newAsc);
                    carray[i] = (char)newAsc;
                }else if(Character.isLowerCase(carray[i])) {
                    int asc = (int)carray[i];
                    int newAsc = 219 - asc;
                    Character.toString((char) newAsc);
                    carray[i] = (char)newAsc;
                }
            }
            result = new String(carray);
            return result;
        }
    }
}
