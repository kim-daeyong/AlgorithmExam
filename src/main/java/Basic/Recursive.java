//package Basic;
//
//import com.sun.org.apache.xerces.internal.util.IntStack;
//
//public class Recursive {
//
//    static int factorial(int n) {
//        if (n > 0)
//            return n * factorial(n - 1);
//        else
//            return 1;
//    }
//
//
//
//    // 3을 입력하면 3*factorial(2)를 반환한다, 이때 factorial(2)를 구해야해서 다시 호출한다.
//    // 호출하다 마지막  factorial(0)을 수행하기위해 메서드가 호출되는데 이는 매개변수 n에 전달받은 값이 0 이므로 1을 반환한다.
//
//
//
//    // 직접 재귀 - 자신과 같은 메서드를 호출
//    // 간접 재귀 - 메서드 a가 b 를 호출
//
//
//
//    // 유클리드 호제법으로 최대공약수 구하기
//
//        // 정수 x, y의 최대공약수를 구하여 반환합니다.
//        static int euclidGCD(int x, int y) {
//            if (y == 0)
//                return x;
//            else
//                return euclidGCD(y, x % y);
//        }
//
//        /*
//        큰값을 작은 값으로 나누었을때 나누어떨어지는 가장 작은 값이 최대 공약수.
//        나누어지지않으면 작은 값에 대해 나누어 떨어질때까지 같은과정을 재귀 반복
//         */
//        // 최대공약수는 y가 0 이면 x이고 0이 아니면 euclidGCD(y, x % y)로 구한다.
//
//
//    //  재귀
//    static void recur(int n) {
//        if (n > 0) {
//            recur(n - 1);
//            System.out.println(n);
//            recur(n - 2);
//        }
//    }
///*
//하향식 분석
//3 입력
//recur(3) 실행 > 4출력 > recur(2) 실행
//
//상향식 분석
//re(0) > 1 출력 > re(-1)을 실행 > 0과 -1은 출력내용 없음, 그래서 1만 출력 >
//re(2) > re(1) 실행 > 2 출력 > re(0) 실행
// */
//
//
//    // 꼬리 재귀를 제거. - 메서드의 꼬리에서 재귀 호출하는 메서드 recur(n-2)를 n 의 값을 n-2 로 업데이트하고 메서드 시작지점으로
//    static void recur(int n) {
//        while (n > 0) {
//            recur(n - 1);
//            System.out.println(n);
//            n = n - 2;
//        }
//    }
//
//    // 재귀의 제거 - n의 값을 n-1로 업데이트하고 메서드 시작지점으로 돌아간다, 현재 n의 값을 잠시 저장한다, 저장했던 n을 다시 꺼내 출력
//    // 스택을 이용하여 비재귀적을 구현
//    static void recur(int n) {
//        IntStack s = new IntStack(n);
//
//        while (true) {
//            if (n > 0) {
//                s.push(n);						// n의 값을 푸시
//                n = n - 1;
//                continue;
//            }
//            if (s.isEmpty() != true) {			// 스택이 비어 있지 않다면
//                n = s.pop();					// 저장하고 있던 스택의 값을 팝
//                System.out.println(n);
//                n = n - 2;
//                continue;
//            }
//            break;
//        }
//    }
//
//    /*
//    n 값에 4를 스택에 푸시
//    n값을 하나 줄여 3으로 만든다
//    continue문에 의해 while문의 처음으로 돌아간다.
//    스탯에서 팝한 값 1을 n으로 꺼낸다
//    n 값 1 출력
//    n 값을 2 줄여 -1로 만든다.
//    continue 문에 의해 while 문의 처음으로 돌아간다.
//
//     */
//
//
//}
