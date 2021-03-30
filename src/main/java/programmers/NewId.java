package programmers;

public class NewId {
    public static void main(String[] args) {
        String id = "...!@BaT#*..y.abcdefghijklm";
        String id2 = "z-+.^.";
        String id3 = "=.=";
        String result = solution(id3);

        System.out.println(result);

    }

    public static String solution(String new_id) {
        String answer = "";
        
        new_id = new_id.toLowerCase();
        StringBuilder id = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                id.append(c);
            }
        }
        new_id = id.toString().replace("..", ".");
        while (new_id.contains("..")) {
            new_id = new_id.replace("..", ".");
        }

        if (new_id.indexOf(".") == 0) {
            new_id = new_id.substring(1, new_id.length());
        }

        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
        }

        if (new_id.lastIndexOf(".") + 1 == new_id.length() && new_id.length() > 1) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        if (new_id.equals("")) {
            new_id = "a";
        }
        if (new_id.length() <= 2  && new_id.length() >= 1) {
            while (new_id.length() < 3) {
                new_id = new_id + new_id.substring(new_id.length() -1 , new_id.length());
            }
        }
        answer = new_id;
        return answer;


        // 다른사람의 정규식 풀이 
        
        // String answer = new_id.toLowerCase(); // 1단계

        // answer = answer.replaceAll("[^-_.a-z0-9]", ""); // 2단계
        // answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        // answer = answer.replaceAll("^[.]|[.]$", "");    // 4단계
        
        // if (answer.equals("")) {    // 5단계
        //     answer += "a";
        // }

        // if (answer.length() >= 16) {     // 6단계
        //     answer = answer.substring(0, 15);
        //     answer = answer.replaceAll("[.]$","");
        // }

        // if (answer.length() <= 2) {  // 7단계
        //     while (answer.length() < 3) {
        //         answer += answer.charAt(answer.length()-1);
        //     }
        // }

        // return answer;
        
    }
}