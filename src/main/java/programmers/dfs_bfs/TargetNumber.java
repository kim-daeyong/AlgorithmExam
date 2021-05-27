package programmers.dfs_bfs;

public class TargetNumber {
    public static void main(String[] args) {
        //[1, 1, 1, 1, 1]	3	5
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int result = solution(numbers, target);
        System.out.println(result);
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(0, 0, numbers, target);
        return answer;
    }

    public static int dfs(int index, int sum, int[] numbers, int target) {

        if (index == numbers.length) {
            return target == sum ? 1 : 0;
        }

        int result = 0;
        int a1 = sum + numbers[index];
        int a2 = sum - numbers[index];
        int s1 = a1 + a2;
        System.out.println("plus " + index + " :   " + a1);
        int c1 = dfs(index+1, sum + numbers[index], numbers, target);
        System.out.println("minus " + index + " :  " + a2);
        int c2 = dfs(index+1, sum - numbers[index], numbers, target);
        result = c1 + c2;
        System.out.println(result);
        return result;

    }
}