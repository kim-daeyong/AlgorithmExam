package programmers.practice;

public class SumDivisor {
    /*
    문제 설명
자연수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수, solution을 완성해주세요.

제한 사항
n은 0 이상 3000이하인 자연수입니다.
입출력 예
n	return
12	28
5	6

     */

    public int solution(int n) {
        int answer = 0;

        for(int i = 1; i<=n; i++){
            if((n%i)==0){
                answer += i;
            }
        }
        return answer;
    }

}

/*

    public int sumDivisor(int num) {
        int answer = 0;
            for(int i = 1; i <= num/2; i++){
        if(num%i == 0) answer += i;
      }
        return answer+num;
 */
