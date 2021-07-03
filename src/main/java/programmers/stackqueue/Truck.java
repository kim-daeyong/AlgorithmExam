package programmers.stackqueue;

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
        
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        return answer;
    }
}