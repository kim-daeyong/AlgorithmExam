package leetcode;

public class DivTwoInte {
    public static void main(String[] args) {
        int dividend = -2147483648;
        // int dividend = -1;
        int divisor = -1;

        int result = divide(dividend, divisor);
        System.out.println(result);
    }

    public static int divide(int dividend, int divisor) {
        int result = 0;
        if(dividend == 0){
            return 0;
        }
        result = dividend/divisor;
        if(dividend < 0 && divisor < 0 && (result == -2147483648 || result == 2147483647)){
           if(dividend == -2147483648){
               result = 2147483647;
           }else{
               result = -2147483648;
           }
        }
        return result;
    }
    
}