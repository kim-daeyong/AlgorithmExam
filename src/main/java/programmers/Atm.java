package programmers;

public class Atm {

    /*
계좌에 들어있는 돈 일부를 은행에서 출금하고자 합니다. 돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받습니다.
돈의 액수 money가 매개변수로 주어질 때,
오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
각 몇 개로 변환되는지 금액이 큰 순서대로 배열에 담아 return 하도록 solution 메서드를 완성해주세요.
입출력 예
money	result
50237	[1, 0, 0, 0, 0, 2, 0, 3, 7]
15000	[0, 1, 1, 0, 0, 0, 0, 0, 0]
 */
    public class Baemin1 {
        public int[] solution(int money) {
            int[] moneyArr = {50000,10000,5000,1000,500,100,50,10,1};
            int[] answer = new int[moneyArr.length];
            for(int i=0; i<moneyArr.length; i++){
                if((money / moneyArr[i]) > 0){
                    answer[i] = money / moneyArr[i];
                }
                money %= moneyArr[i];
            }
            return answer;
        }
    }
}
