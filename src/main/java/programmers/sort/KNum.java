package programmers.sort;

import java.util.Arrays;

public class KNum {
    /*
    문제 설명
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.
입출력 예
array               	commands	                        return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

     */

    //copyOfRange > array에서 from 부터 to 까지 잘라낸다.. 이걸 알기 전 까진 엄청 고생했는데 검색해서 찾아내니 엄청나게 짧아

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i =0; i <commands.length; i++) {
            int[] result = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(result);
            answer[i]=result[commands[i][2]-1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        KNum kNum = new KNum();
//        kNum.solution(array, commands);
        System.out.println(kNum.solution(array, commands));

    }

    /*
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0 ;

        for(int i = 0 ; i < commands.length ; i++)
        {
            int start = commands[i][0];
            int end = commands[i][1];
            int k = commands[i][2];

            int[] tmp = new int[end - start + 1];

            int a = 0;
            for(int j = start - 1 ; j < end ; j++)
                tmp[a++] = array[j];

            Arrays.sort(tmp);
            answer[index++] = tmp[k-1];
        }
        return answer;
    }



    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i= 0; i<commands.length ; i++){
            int start = commands[i][0] == 0 ? 0 : commands[i][0]-1;
            int finish = commands[i][1] == commands[i][0] ? start+1 : commands[i][1] ;
            int pos = commands[i][2]-1;

            int[] tmp = Arrays.copyOfRange(array, start, finish);

            Arrays.sort(tmp);

            answer[i] = tmp[pos];
        }

        return answer;
    }


    정렬까지..

        public int[] solution(int[] array, int[][] commands) {
        int n = 0;
        int[] ret = new int[commands.length];

        while(n < commands.length){
            int m = commands[n][1] - commands[n][0] + 1;

            if(m == 1){
                ret[n] = array[commands[n++][0]-1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for(int i = commands[n][0]-1; i < commands[n][1]; i++)
                a[j++] = array[i];

            sort(a, 0, m-1);

            ret[n] = a[commands[n++][2]-1];
        }

        return ret;
    }

    void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }


     */
}
