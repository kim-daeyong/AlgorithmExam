package programmers;

public class ThreeSixNine {
    /*
배달이가 좋아하는 369게임(배달이는 아재입니다.)을 하고자 합니다.
놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 합니다.
숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지
횟수를 return 하도록 solution 메서드를 완성해주세요.
number	result
13	4
33	14
 */
        public int solution(int number) {
            int answer = 0;
            for(int i=1; i <= number; i++){
                String str= String.valueOf(i);
                boolean bol = false;
                for(int j=0; j<str.length(); j++){
                    char cha = str.charAt(j);
                    if(cha == '3' || cha =='6' || cha == '9'){
                        answer++;
                        bol = true;
                    }
                }

            }
            return answer;
        }

}
