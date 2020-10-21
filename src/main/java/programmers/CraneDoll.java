package programmers;

import java.util.Stack;

public class CraneDoll {
    public static void main(String[] args) {
        
        int answer = 0;
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3,},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i = 0; i<moves.length; i++){
            int move = moves[i];
            for (int j = 0; j<board.length; j++) {
                if (board[j][move-1] != 0) {
                    if (stack.peek() == board[j][move-1]) {
                    stack.pop();
                    answer += 2;
                    } else {
                 stack.push(board[j][move-1]);
                }
                board[j][move-1] = 0;
                break;
              }
            }
        }
        System.out.println(answer);
    }
}