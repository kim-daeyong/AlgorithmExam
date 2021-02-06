package leetcode;

import java.util.Stack;

/*
Input: path = "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.

Input: path = "/a/./b/../../c/"
Output: "/c"

Input: path = "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.

result
Runtime: 10 ms
Memory Usage: 39 MB
*/


public class Simplepath {
    
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        String[] temp = path.split("/");
        Stack<String> stack = new Stack<String>();
        String result = "";
        for (int i = 1 ; i <  temp.length; i++) {
            if (temp[i].equals(null) || temp[i].equals("")) {
                continue;
            }
            if (temp[i].equals("..") && stack.size() > 0) {
                stack.pop();
                continue;
            }
            if (temp[i].equals(".") || temp[i].equals("..")) {
                continue;
            }
            stack.push(temp[i]);
        }
        int s = stack.size();
        for(int j = 0; j < s; j ++){
            if (j > 0) {
                result = stack.pop() + "/" + result;
                continue;
            }
            result = stack.pop() + result;
        }
        return "/" + result;
    }
}
