package Basic;

public class Queue {

    // FIFO - 처음 들어간게 처음 나온다.

    private int max; //큐의 용량
    private  int front; // 첫번때 요소의 커서
    private  int rear; // 마지막 요서 커서
    private int num; //현재 데이터 수
    private int[] que ; //큐 본체;

    // 큐 비어있음
    public class EmptyIntQueueException extends RuntimeException{

    }
    public class OverFlowIntQueueException extends RuntimeException{


    }

    //생성자
    public Queue(int capacity){
        num = front = rear = 0;
        max = capacity;
        try{
            que = new int[max]; // 큐 본체용 배열을 생성
        }
        catch (OutOfMemoryError e){ // 생성할 수 없음

            max = 0;
        }
    }

    /*
    Queue - 큐를 관리하는 클래스
    front  첫번때 요소를 저장하는 인덱스맨
    rear 가장 맨 마지막에 넣은 요소나 하나위의 인덱스를 저장하는 필드


     */

}
