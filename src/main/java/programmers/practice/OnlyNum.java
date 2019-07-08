package programmers.practice;

public class OnlyNum {


    /*

    문제 설명
문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
예를 들어 s가 a234이면 False를 리턴하고 1234라면 True를 리턴하면 됩니다.

제한 사항
s는 길이 1 이상, 길이 8 이하인 문자열입니다.
입출력 예
s	return
a234	false
1234
     */
        public boolean solution(String s) {
                    boolean answer = true;
                    char[] charArr = s.toCharArray();
                    if(charArr.length != 6 && charArr.length != 4) {
                        return false;
                    }
                    for (int i = 0; i < charArr.length; i++) {
                        if (!(charArr[i] >= '0' && charArr[i] <= '9')) {
                            return false;
                        }
                    }
                    return answer;
                }

                /*


                 public boolean solution(String s) {
      if(s.length() == 4 || s.length() == 6){
          try{
              int x = Integer.parseInt(s);
              return true;
          } catch(NumberFormatException e){
              return false;
          }
      }
      else return false;
  }



  public boolean solution(String s) {
        if (s.length() == 4 || s.length() == 6) return s.matches("(^[0-9]*$)");
        return false;
  }



       int length = s.length();
        if (length != 4 && length != 6)
            return false;
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            if (c < '0' || c > '9')
                return false;

        }
        return true;
  }

                 */
}
