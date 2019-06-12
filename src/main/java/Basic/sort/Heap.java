package Basic.sort;

public class Heap {

    // 힙정렬
    // 선택정렬을 응용한 알고리즘, 힙의 특성을 이용해서 정렬
    // 힙은 부모의 값이 자식의 값보다 항상 크다는 조건을 만족하는 완전 이진트리
    // 가장 큰 값이 루트에 위치
    // 루트를 ㄷ꺼낸다, 마지막 요소를 루트로 이동, 자기보다 큰 값을 가지는 자식 요소와 자리를 바꾸며 아래쪽으로 내려가는 작업 반복
    // 이때 값이 작거나 잎에 다다르면 작업이 종료된다.

    /*
    알고리즘

변수 i의 값을 n-1로 초기화한다.
a[0] 과 a[i]를 바꾼다.
a[0].a[1],..., a[i-1]을 힙으로 만든다
i의 값을 1씩 줄여 0이 되면 끝난다, 아니면 2로 돌아간다.



     */

    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // a[left] ~ a[right]를 힙으로 만듭니다.
    static void downHeap(int[] a, int left, int right) {
        int temp = a[left];				// 루트
        int child;						// 큰 값을 가진 노드
        int parent;						// 부모

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;							// 왼쪽 자식
            int cr = cl + 1;									// 오른쪽 자식
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;	// 큰 값을 가진 노드를 자식에 대입
            if (temp >= a[child])
                break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    // 힙 정렬
    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--)	// a[i] ~ a[n-1]를 힙으로 만들기
            downHeap(a, i, n - 1);

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);				// 가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
            downHeap(a, 0, i - 1);		// a[0] ~ a[i-1]을 힙으로 만듭니다.
        }
    }
}
