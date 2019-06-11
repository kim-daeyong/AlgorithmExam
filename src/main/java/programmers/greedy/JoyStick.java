package programmers.greedy;

public class JoyStick {

    /*
    조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동
예를 들어 아래의 방법으로 JAZ를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
입출력 예
name	return
JEROEN	56
JAN	    23




    // 방법 1. 비교 digit을 만들어 앞으로 가는게 빠를지 비교하고?

     */

//    class Solution {
//        public int solution(String name) {
//            int answer = 0;
//            return answer;
//
//
//
//        }
//    }


    int solution(String name) {
        int answer = 0;

        //비교할 string 생성
        String make = "";
        for (int i = 0; i < name.length(); i++) {
            make += "A";
        }

        int now = 0;
        while (make != name) {
            int i = 0;
            int temp1 = 0;
            int temp2 = 0;
            int j, k;
            //오른쪽으로 찾는다
            for (k = 0; k < name.length(); k++) {
                int idx = (now + k) % name.length();
                if (make.charAt(idx) != name.charAt(idx)) {
                    if ((idx - now )< 0) {
                        temp1 = name.length() - now + idx;
                        break;
                    }
                    else {
                        temp1= idx - now;
                        break;
                    }
                }
            }

            //왼쪽으로 찾는다
            for (j = 0; j < name.length(); j++) {
                int idx = (now - j + name.length()) % name.length();
                if (make.charAt(idx) != name.charAt(idx)) {
                    if ((now - idx) < 0) {
                        temp2 += name.length() - idx + now;
                        break;
                    }
                    else {
                        temp2 += now - idx;
                        break;
                    }
                }
            }

            //비교해서 최소값을 찾는다
            if (temp1 <= temp2) {
                i = (now + k) % name.length();
                answer += temp1;
            }
            else {
                i = (now - j + name.length()) % name.length();
                answer += temp2;
            }

            //상하로 움직이는거 더함
            now = i;
            if (name.charAt(i) - 'A' < 13) {
                answer += name.charAt(i) - 'A';
//                make.charAt(i) = name.charAt(i);
            }
            else {
                answer += 'Z' - name.charAt(i) + 1;
//                make.charAt(i) = name.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        String name = "ABABAAAAAAABA";

//        solution(name);

    }
}

/*


class Solution {
public int solution(String name){
        int answer = 0, n = name.length(),
                leftOrRight = name.length() - 1;
        for(int i = 0; i < n; i++){
            int next = i + 1;
            char target = name.charAt(i);
            if(target <= 'N') answer += target - 'A';
            else answer += 'Z' - target + 1;
            while(next < n && name.charAt(next) == 'A') next++;
            leftOrRight = Math.min(leftOrRight, i + n - next + Math.min(i, n - next));
        }
        answer += leftOrRight;
        return answer;
    }
}

//대회 코드인데 처음 A가 아닌걸 찾아서 구하는 것 같다.


 */
