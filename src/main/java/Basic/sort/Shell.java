package Basic.sort;

public class Shell {
    // 단순 삽입정렬의 장점을 살리고 단점은 보완
    // 장점 - 정렬을 마쳤거나 정렬을 마친 상태에 가까우면 정렬속도가 빨라진다.
    // 단점 - 삽입할 위치가 멀리 떨어져 있으면 이동해야하는 횟수가 많아진다.

    static void shellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
                    a[j + h] = a[j];
                a[j + h] = tmp;
            }
    }
    // 셸정렬2
    // h 값이 서로 배수가 되지않도록
    static void shellSort2(int[] a, int n) {
        int h;
        for (h = 1; h < n / 9; h = h * 3 + 1)
            ;

        for ( ; h > 0; h /= 3)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
                    a[j + h] = a[j];
                a[j + h] = tmp;
            }
    }

}
