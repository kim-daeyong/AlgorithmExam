package Basic;

public class Stack {

    //스택이란 LIFO로 가장 나중에 넣은 데이터가 가장 먼저 꺼내진다.
    // 자바 스택 예제

    private int max;
    private int ptr;
    private int[] stk;

    //스택이 비어있음
    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException() {};
    }

    //스택이 참
    public class OverflowIntStackException extends RuntimeException{

    }

    // 생성자
    public Stack(int capacity){
        ptr = 0;
        max = capacity;
    try{stk = new int[max];
    }
    catch(OutOfMemoryError e){

        max = 0;
    }

    }
    // 스택 용량 : max
    // 스택포인터 : ptr
    // 스택본체용 배열 : stk

    /*

    push - 스택에 데이터를 넣는것 ,
    pop  - 스택에서 꼭대기에 데이터를 제거하고 그 값을 반환하는 메서드
    peak - 스택 꼭대기에 있는 데이터를 몰래 엿보는 메서드
    indexOf - 스택 본체 배열 stk에 x와 같은 값의 데이터가 포함되어있는지 있다면 어디에 있는지 조사하는 검색 메서드
    clear - 스택에 쌓인 모든 데이터 삭제
    capacity - 스택의 용량 반환
    size - 데이터 수 확인
    IsEmpty - 스택이 비어있는지, 비어있으면 true
    IsFull - 가득 찼는지 , 찼으면 true
    dump - 모든 데이터를 바닥에서 꼭대기 순으로 표시

     */

}
