package programmers.stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Truck {

    /*

    예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

        경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
        0	        []              	[]          	[7,4,5,6]
        1~2     	[]              	[7]	            [4,5,6]
        3       	[7]	                [4]          	[5,6]
        4	        [7]	                [4,5]          	[6]
        5	        [7,4]	            [5]	            [6]
        6~7	        [7,4,5]	            [6]	            []
        8	        [7,4,5,6]	        []           	[]

    */
    public static void main(String[] args) {
        
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        int result = solution(bridge_length, weight, truck_weights);

        System.out.println(result);

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {

        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        int currentWeight = 0;
        for (int i = 0; i < truck_weights.length; i++) {
            if (bridge.size() == bridge_length && bridge.peek() != 0) {
                currentWeight -= bridge.poll();
                i --;
                continue;
            } else {
                if(bridge.size() > 0 && bridge.peek() == 0) {
                    bridge.poll();
                }
                if (bridge.size() < bridge_length && currentWeight + truck_weights[i] <= weight) {
                    currentWeight += truck_weights[i];
                    bridge.offer(truck_weights[i]);
                } else if (bridge.size() < bridge_length && currentWeight + truck_weights[i] > weight){
                    bridge.offer(0);
                    i --;
                }
            }
            answer ++;
        }
        
        return answer + bridge_length;
    }
}
    //     int answer = 0;
    //     Queue<Integer> bridge = new LinkedList<>();
    //     if (getSumWeight(truck_weights) <= weight) {
    //         return truck_weights.length + bridge_length;
    //     }
    //     for (int i = 0; i < truck_weights.length; i++) {
    //         if (bridge.size() == bridge_length && bridge.peek() != 0) {
    //             bridge.poll();
    //             i --;
    //         } else {
    //             if(bridge.size() > 0 && bridge.peek() == 0) {
    //                 bridge.poll();
    //             }
    //             if (bridge.size() < bridge_length && getCurrentWeight(bridge) + truck_weights[i] <= weight) {
    //                 bridge.add(truck_weights[i]);
    //             } else if (bridge.size() < bridge_length && getCurrentWeight(bridge) + truck_weights[i] > weight){
    //                 bridge.add(0);
    //                 i --;
    //             }
    //         }
    //         answer ++;
    //     }
        
    //     return answer - 1;
    // }

    // public static int getCurrentWeight(Queue<Integer> bridge) {
    //     return  bridge.stream().reduce(0, Integer::sum);
    // }

    // public static int getSumWeight(int[] truck_weights) {
    //     return  Arrays.stream(truck_weights).reduce(0, Integer::sum);
    // }

// }
