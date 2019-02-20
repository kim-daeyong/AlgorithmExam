import java.util.Scanner;

public class ABSUM{

            public static void main(String[] args){
                Scanner sc = new Scanner(System.in);

                int a = 0;
                int b = 0;
                int sum= 0;
                a= sc.nextInt();
                b= sc.nextInt();
                if(0<a&&b<10){
                    sum = a + b;
                    System.out.println(sum);
                }

            }



        }
