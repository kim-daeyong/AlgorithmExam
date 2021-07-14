package programmers.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {
        // int[] priorities = {2, 1, 3, 2};
        int[] priorities = {1, 1, 9, 1, 1, 1};	
        int location = 0;	
        int result = solution(priorities, location);

        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < priorities.length; i++) {
            queue.offer(priorities[i]);
        }

        while(!queue.isEmpty()) {
            for (int j = 0; j < priorities.length; j++) {
                int a = queue.peek();
                int b = priorities[j];
                if (queue.peek() == priorities[j]) {
                    queue.poll();
                    answer++;
                    if (j == location) {
                        queue.clear();
                        break;
                    }
                }
            }
        }

        return answer;
    }

    ///////////////

    public int solutionexam(int[] priorities, int location) {
        int answer = 0;
        int l = location;

        Queue<Integer> que = new LinkedList<Integer>();
        for(int i : priorities){
            que.add(i);
        }

        Arrays.sort(priorities);
        int size = priorities.length-1;



        while(!que.isEmpty()){
            Integer i = que.poll();
            if(i == priorities[size - answer]){
                answer++;
                l--;
                if(l <0)
                    break;
            }else{
                que.add(i);
                l--;
                if(l<0)
                    l=que.size()-1;
            }
        }

        return answer;
    }

    public int solution3(int[] priorities, int location) {
        List<Integer> list = new ArrayList<>();
        for (int priority : priorities) {
          list.add(priority);
        }
    
        int turn = 1;
        while (!list.isEmpty()) {
          final Integer j = list.get(0);
          if (list.stream().anyMatch(v -> j < v)) {
            list.add(list.remove(0));
          } else {
            if (location == 0) {
              return turn;
            }
            list.remove(0);
            turn++;
          }
    
          if (location > 0) {
            location--;
          } else {
            location = list.size() - 1;
          }
        }
    
        throw new IllegalArgumentException();
      }

}
