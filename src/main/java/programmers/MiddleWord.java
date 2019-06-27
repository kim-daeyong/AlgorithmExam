package programmers;


/*

단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.
입출력 예
s	return
abcde	c
qwer	we


 */
public class MiddleWord {

    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 0)
            answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        else
            answer = Character.toString(s.charAt(s.length() / 2));

        return answer;
    }

}

/*
다른사람 코드

    String getMiddle(String word){
      int length = word.length();
      int index = length / 2;
      return (length%2==0) ? word.substring(index-1, index+1) : word.substring(index, index+1);
    }

    3항연산자로 훨씬 간결하게 되어있다.

 */