package programmers.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TravelPath {

    static boolean[] visit;
    static List<String> list;
    public static void main(String[] args) {
        // [["ICN", "JFK"], ["HND", "IAD"], ["JFK", "HND"]]	       / ["ICN", "JFK", "HND", "IAD"]

        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] result = solution(tickets);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];
        list = new ArrayList<>();
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(",");
    }

    public static void dfs(int index, String start, String result, String[][] tickets) {
        if (index == tickets.length) {
            list.add(result);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visit[i] && start.equals(tickets[i][0])) {
                visit[i] = true;
                dfs(index + 1, tickets[i][1], result + "," + tickets[i][1], tickets);
                visit[i] = false;
            }
        }
    }

}