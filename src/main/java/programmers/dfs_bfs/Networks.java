package programmers.dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class Networks {
    /*
        3	[[1, 1, 0], 
             [1, 1, 0], 
             [0, 0, 1]]	
        2

        3	[[1, 1, 0], 
             [1, 1, 1], 
             [0, 1, 1]]	
        1
    */

    static boolean[] visit;
    static List<Integer> list;
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        visit = new boolean[n];
        list = new ArrayList<>();
        int result = solution(n, computers);

        System.out.println(result);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        for(int i = 0; i < computers.length; i++){
            if(visit[i] == false){
                answer++;
                dfs(i, computers);
            }            
        }
        return answer;
    }

    public static void dfs(int index ,int[][] computers) {
        visit[index] = true;
        for(int i = 0; i < computers.length; i++){
            if(visit[i] == false && computers[index][i] == 1){
                dfs(i, computers);
            }
        }
    }
}