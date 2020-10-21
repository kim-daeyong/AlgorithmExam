package thisiscote;

import java.util.Arrays;

public class BigNum {
    public static void main(String[] args) {
        int[] array = {2,4,5,4,6};
        int m = 8;
        int k = 3;
        int result = 0;
        Arrays.sort(array);
        int a = array[array.length-1];
        int b = array[array.length-2];

        while(true){
            for(int i = 0; i<=k; i++){
                if(m==0){
                    break;
                }
                result += a;
                m--;
            }
            if(m==0){
                break;
            }
                result += b;
                m--;
        }

        System.out.println(result);
    }
}