package back4344;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt();

        for(int i=0; i<c; i++){
         int n = sc.nextInt();
         int total = 0;
         int avg = 0;
         double cnt = 0;
         int[] arr = new int[n];
            for(int j=0; j<n; j++){
                arr[j] = sc.nextInt();
                total += arr[j];
            }

            avg = total/n;

            for(int k=0; k<n; k++){
                if(arr[k]>avg){
                    cnt ++;
                }
            }

            System.out.printf("%.3f", (cnt/n) *100);
            System.out.println("%");
        }
    }
}
