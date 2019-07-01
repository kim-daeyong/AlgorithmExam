package programmers.practice;

public class Twozeroonesix {

    /*

    문제 설명
2016년 1월 1일은 금요일입니다.
2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT

입니다. 예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건
2016년은 윤년입니다.
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
입출력 예
a	b	result
5	24	TUE


     */
    public String solution(int a, int b) {
        String answer = "";

        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int sum = 0;

        for(int i = 0; i<a-1; i++){
            sum += month[i];
        }

        sum = sum+b-1;

        answer = day[(sum%7)];

        return answer;
    }

    // 이번건 고민 좀 했다.. 처음 문제를 어떻게 해결해야할지 너무 고민했다.
    /*
배열에 요일과 해당 달의 일수를 저장해주고(day가 fri인 이유는 처음 시작 날이 금욜 이기 때문)
입력받은 달(a)의 값에 해당하는 달의 전까지 더해주고(b로 해당날짜를 입력받기에)
b를 더해주고(날짜), -1 을 해준다(해당 날에 맞는 요일을 맞추기위해)
이를 day 배열에 맞는 값을 찾아 넣어준다


     */

   /*
        // 캘린더를 사용한 답안
        public String getDayName(int month, int day)
    {
        Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
                        .setDate(2016, month - 1, day).build();
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
    }




    // 흠

        public String getDayName(int a, int b)
    {
      String answer = "";
      switch(a) {
        case 1:
          if(b % 7 == 1)
            answer = "FRI";
          else if(b % 7 == 2)
            answer = "SAT";
          else if(b % 7 == 3)
            answer = "SUN";
          else if(b % 7 == 4)
            answer = "MON";
          else if(b % 7 == 5)
            answer = "TUE";
          else if(b % 7 == 6)
            answer = "WED";
          else
            answer = "THU";
          break;
        case 2:
          if(b % 7 == 1)
            answer = "MON";
          else if(b % 7 == 2)
            answer = "TUE";
          else if(b % 7 == 3)
            answer = "WED";
          else if(b % 7 == 4)
            answer = "THU";
          else if(b % 7 == 5)
            answer = "FRI";
          else if(b % 7 == 6)
            answer = "SAT";
          else
            answer = "SUN";
          break;
        case 3:
          if(b % 7 == 1)
            answer = "TUE";
          else if(b % 7 == 2)
            answer = "WED";
          else if(b % 7 == 3)
            answer = "THU";
          else if(b % 7 == 4)
            answer = "FRI";
          else if(b % 7 == 5)
            answer = "SAT";
          else if(b % 7 == 6)
            answer = "SUN";
          else
            answer = "MON";
          break;
        case 4:
          if(b % 7 == 1)
            answer = "THU";
          else if(b % 7 == 2)
            answer = "FRI";
          else if(b % 7 == 3)
            answer = "SAT";
          else if(b % 7 == 4)
            answer = "SUN";
          else if(b % 7 == 5)
            answer = "MON";
          else if(b % 7 == 6)
            answer = "TUE";
          else
            answer = "WED";
          break;
        case 5:
            if(b % 7 == 1)
            answer = "SUN";
          else if(b % 7 == 2)
            answer = "MON";
          else if(b % 7 == 3)
            answer = "TUE";
          else if(b % 7 == 4)
            answer = "WED";
          else if(b % 7 == 5)
            answer = "THU";
          else if(b % 7 == 6)
            answer = "FRI";
          else
            answer = "SAT";
          break;
        case 6:
            if(b % 7 == 1)
            answer = "WED";
          else if(b % 7 == 2)
            answer = "THU";
          else if(b % 7 == 3)
            answer = "FRI";
          else if(b % 7 == 4)
            answer = "SAT";
          else if(b % 7 == 5)
            answer = "SUN";
          else if(b % 7 == 6)
            answer = "MON";
          else
            answer = "TUE";
          break;
        case 7:
            if(b % 7 == 1)
            answer = "FRI";
          else if(b % 7 == 2)
            answer = "SAT";
          else if(b % 7 == 3)
            answer = "SUN";
          else if(b % 7 == 4)
            answer = "MON";
          else if(b % 7 == 5)
            answer = "TUE";
          else if(b % 7 == 6)
            answer = "WED";
          else
            answer = "THU";
          break;
        case 8:
            if(b % 7 == 1)
            answer = "MON";
          else if(b % 7 == 2)
            answer = "TUE";
          else if(b % 7 == 3)
            answer = "WED";
          else if(b % 7 == 4)
            answer = "THU";
          else if(b % 7 == 5)
            answer = "FRI";
          else if(b % 7 == 6)
            answer = "SAT";
          else
            answer = "SUN";
          break;
        case 9:
            if(b % 7 == 1)
            answer = "THU";
          else if(b % 7 == 2)
            answer = "FRI";
          else if(b % 7 == 3)
            answer = "SAT";
          else if(b % 7 == 4)
            answer = "SUN";
          else if(b % 7 == 5)
            answer = "MON";
          else if(b % 7 == 6)
            answer = "TUE";
          else
            answer = "WED";
          break;
        case 10:
            if(b % 7 == 1)
            answer = "SAT";
          else if(b % 7 == 2)
            answer = "SUN";
          else if(b % 7 == 3)
            answer = "MON";
          else if(b % 7 == 4)
            answer = "TUE";
          else if(b % 7 == 5)
            answer = "WED";
          else if(b % 7 == 6)
            answer = "THU";
          else
            answer = "FRI";
          break;
        case 11:
            if(b % 7 == 1)
            answer = "TUE";
          else if(b % 7 == 2)
            answer = "WED";
          else if(b % 7 == 3)
            answer = "THU";
          else if(b % 7 == 4)
            answer = "FRI";
          else if(b % 7 == 5)
            answer = "SAT";
          else if(b % 7 == 6)
            answer = "SUN";
          else
            answer = "MON";
          break;
        case 12:
            if(b % 7 == 1)
            answer = "THU";
          else if(b % 7 == 2)
            answer = "FRI";
          else if(b % 7 == 3)
            answer = "SAT";
          else if(b % 7 == 4)
            answer = "SUN";
          else if(b % 7 == 5)
            answer = "MON";
          else if(b % 7 == 6)
            answer = "TUE";
          else
            answer = "WED";
          break;
        }
        return answer;
    }

     */
}
