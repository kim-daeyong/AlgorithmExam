package others;


public class ReverseNum {
    public static void main(String[] args) {
        int a = 54321;
        int b = 10011;
        int c = 1;
        int d = 0;
        int e = 12312345;
        int f = 11001;

        solution(f);
    }

    public static void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 == 0) {
                enable_print = 1;
            }
            else if (enable_print == 1) {
                System.out.print(N % 10);
            }
            else System.out.print(N % 10);
            N = N / 10;
        }
    }
}