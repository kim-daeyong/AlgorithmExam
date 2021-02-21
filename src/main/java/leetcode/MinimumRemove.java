package leetcode;

public class MinimumRemove {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        String result = minRemoveToMakeValid(s);

        System.out.println(result);

    }

    public static String minRemoveToMakeValid(String s) {
        int completeCount = 0;
        int closeCount = 0;
        String result = "";
        for (char c: s.toCharArray()) {
            if (c == ')') {
                closeCount++;
            }
        }
        
        for (char c: s.toCharArray()) {
            if (c == '(') {
                if (completeCount == closeCount) {
                    continue;
                }
                completeCount++;
            } else if (c == ')') {
                closeCount--;
                if (completeCount == 0) {
                    continue;
                }
                completeCount--;
            } 
                result += c;
                System.out.println(result);
        }
        return result;
    }
}