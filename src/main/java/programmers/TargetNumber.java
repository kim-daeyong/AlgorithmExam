package programmers;

public class TargetNumber {


    /*

    n개의 음이 아닌 정수가 있습니다.
    이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
    예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

   사용할 수 있는 숫자가 담긴 배열 numbers,
   타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를
   return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.


입출력 예
numbers	target	return
[1, 1, 1, 1, 1]	3	5


DFS 깊이탐색 DFS 문제는 Stack 또는 재귀를 통해 풀이가 가능하다한다,
여긴 재귀 활

     */

    /*

    public class Solution {
        public int solution(int[] numbers, int target) {
            return DFS(numbers, target, 0, 0);
        }

        public int DFS(int[] numbers, int target, int index, int num) {
            if(index == numbers.length) {
                return num == target ? 1 : 0;
            } else {
                return DFS(numbers, target, index + 1, num + numbers[index])
                        + DFS(numbers, target, index + 1, num - numbers[index]);
            }
        }

        public static void main(String[] args) {
            int[] arr = new int[20];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = 1;
            }
            int target = 3;


        }
    }

    dfs를 통해 깊이 우선 탐색을 한다.

- 연산과정을 하나의 트리로 생각해 볼때, '+'연산은 왼쪽 자식노드로 '-'연산은 오른쪽 자식노드로 내려가는 과정을 재귀메소드를 이용하여, 코드로 표현하였다.





class Solution {
    static int ANSWER = 0;
    public int solution(int[] numbers, int target) {
        dfs(target,numbers,0);
        return ANSWER;
    }
    public void dfs(int target, int [] numbers, int k){
        if(k == numbers.length){
            int sum=0;
            for(int i=0;i<numbers.length;i++){
                sum += numbers[i];
            }
            if(sum == target)
                ANSWER++;
            return;
        }
        else{
            numbers[k]*=1;
            dfs(target,numbers,k+1);

            numbers[k]*=-1;
            dfs(target,numbers,k+1);
        }
    }
}*/

    class Solution {
        public int solution(int[] numbers, int target) {
            int answer = 0;
            dfs(numbers, target, 0);
            return answer;
        }

        public void dfs(int[] numbers, int target, int n){
            for(int i =0; i<=numbers.length; i++){



                }

            }
        }


}
