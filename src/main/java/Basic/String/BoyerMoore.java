package Basic.String;

public class BoyerMoore {

    /*
    패턴의 마지막 문자부터 앞쪽으로 검사를 진행하면서 일치하지않는 문자가있으면 앞쪽은 비교를 생략하고 패턴을 단숨에 뒤로 옮김
    abcd > d가 일치안함 > 4칸뒤로 옮김

    일치하면 패턴비교

    패턴문자열의 길이가 n 이라면

    1. 패턴에 들있지않은 문자 만나면 > 패턴을 옮길 크기는 n 이다

    2. 패턴에 들어있는 문자를 만든경우
        - 마지막에 나오는 위치의 인덱스가 k 면 패턴을 옮길 크기는 n - k - 1이다, 들어있다면 마지막인덱스를 기준으로하여 패턴을 (n-k-1) 만큰 옮긴다.
        - 같은 무자가 패턴안에 중복해서 들어있지않다면 패턴을 옮길 크기는 n이다.



     */

    // Boyer-Moore법으로 문자열을 검색
    static int bmMatch(String txt, String pat) {
        int pt;                                // txt 커서
        int pp;                                // pat 커서
        int txtLen = txt.length();            // txt의 문자 개수
        int patLen = pat.length();            // pat의 문자 개수
        int[] skip = new int[Character.MAX_VALUE + 1];    // 건너뛰기 표

        // 건너뛰기 표 만들기
        for (pt = 0; pt <= Character.MAX_VALUE; pt++)
            skip[pt] = patLen;
        for (pt = 0; pt < patLen - 1; pt++)
            skip[pat.charAt(pt)] = patLen - pt - 1;    // pt == patLen - 1
        // 검색
        while (pt < txtLen) {
            pp = patLen - 1;                // pat의 끝 문자에 주목

            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0)
                    return pt;    // 검색 성공
                pp--;
                pt--;
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1;                // 검색 실패
    }
}
