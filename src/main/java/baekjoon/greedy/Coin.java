package baekjoon.greedy;

import java.util.Scanner;

public class Coin {


    public static void main(String[] args) {
//   컴파일에러

        Scanner sc = new Scanner(System.in);
        int i, N = sc.nextInt(), K = sc.nextInt();
        int arr[] = new int[N];
        int answer=0;

        for (i = 0; i < N; i++) arr[i] = sc.nextInt();

        for(i=N-1; i>=0; i--) {

                answer += K / arr[i];
                K %= arr[i];


        }
        System.out.println(answer);
    }
}


