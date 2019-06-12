package Basic.sort;

public class Insert {

    //선택한 요소를 그보다 더 앞쪽의 알맞은 위치에 삽입

    // 단순 삽입 정렬
    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = a[i];
            for (j = i; j > 0 && a[j - 1] > tmp; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }


}
