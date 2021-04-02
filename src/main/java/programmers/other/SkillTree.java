package programmers.other;
public class SkillTree {

    // "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        int result = solution(skill, skill_trees);

        System.out.println(result);

    }

    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String temp : skill_trees) {
            for (char str : temp.toCharArray()) {
                String word = String.valueOf(str);
                if (!skill.contains(word)){
                    temp = temp.replace(word,  "");
                }
            }
            if (skill.indexOf(temp) == 0){
                answer++;
            }
        }
        
        return answer;
    }
}


/*

        int answer = 0;
        for (String temp : skill_trees) {
            int index = -10;
            int count = 1;
            for (char str : temp.toCharArray()) {
                if (index == -10) {
                    index = temp.indexOf(str);
                } else if (index < temp.indexOf(str, index)) {
                    count++;
                    index = temp.indexOf(str, index);
                } else {
                    continue;
                }
            }
            if (count == skill.length()) {
                answer ++;
            }
        }
        
        return answer;

*/