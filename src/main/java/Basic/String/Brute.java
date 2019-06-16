package Basic.String;

import java.util.Scanner;

public class Brute {

    /*
    브루트 포스 - 문자열에서 다른 문자열이 들어있는지 조사하고 그 위치 찾아내기
    한칸씩 이동하며 조사
    일치하지않아 다음으로 넘어가면 조사했던 결과를 버리고 처음부터 조사함
     */
        // 브루트-포스법으로 문자열을 검색하는 메서드
        static int bfMatch(String txt, String pat) {
            int pt = 0;        // txt 커서
            int pp = 0;        // pat 커서

            while (pt != txt.length() && pp != pat.length()) {
                if (txt.charAt(pt) == pat.charAt(pp)) {
                    pt++;
                    pp++;
                } else {
                    pt = pt - pp + 1;
                    pp = 0;
                }
            }
            if (pp == pat.length())            // 검색 성공!
                return pt - pp;
            return -1;                        // 검색 실패!
        }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트：");
        String s1 = stdIn.next(); 					// 텍스트용 문자열

        System.out.print("패턴：");
        String s2 = stdIn.next();					// 패턴용 문자열

        int idx = bfMatch(s1, s2);					// 문자열 s1에서 문자열 s2를 검색
        // 일치하는 문자 바로 앞까지의 길이를 구합니다.
        int len = 0;
        for (int i = 0; i < idx; i++)
            len += s1.substring(i, i + 1).getBytes().length;
        len += s2.length();

        int idx1 = s1.indexOf(s2);					// 문자열 s1에서 s2를 검색
        int idx2 = s1.lastIndexOf(s2);				// 문자열 s1에서 s2를 검색

        // 찾아낸 문자열의 바로 앞까지의 문자 개수를 구합니다.
        int len1 = 0;
        for (int i = 0; i < idx1; i++)
            len1 += s1.substring(i, i + 1).getBytes().length;
        len1 += s2.length();

        int len2 = 0;
        for (int i = 0; i < idx2; i++)
            len2 += s1.substring(i, i + 1).getBytes().length;
        len2 += s2.length();

    }

}
