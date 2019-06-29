package programmers.practice;

import java.util.Arrays;

public class FindKim {

    /*

    문제 설명
String형 배열 seoul의 element중 Kim의 위치 x를 찾아, 김서방은 x에 있다는 String을 반환하는 함수, solution을 완성하세요. seoul에 Kim은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.

제한 사항
seoul은 길이 1 이상, 1000 이하인 배열입니다.
seoul의 원소는 길이 1 이상, 20 이하인 문자열입니다.
Kim은 반드시 seoul 안에 포함되어 있습니다.
입출력 예
seoul	return
[Jane, Kim]	김서방은 1에 있다


     */

    public String solution(String[] seoul) {
        String answer = "";

        int find = Arrays.asList(seoul).indexOf("Kim");
        answer = "김서방은 "+find+"에 있다";

        for(int i=0; i<seoul.length; i++) {
//            answer = "김서방은 "+seoul[i].indexOf("Kim")+x+" 에 있다.";  // 처음했던것 당연히 안된다 0 이 나옴

            //if를 써서
//            if(seoul[i] == "Kim"){
//                int findKim = i;
//
//            }

        }
        return answer;
    }

    public static void main(String[] args) {
        FindKim kim = new FindKim();
        String[] names = {"Queen", "Tod","Kim"};
        System.out.println(kim.solution(names));
    }
}
