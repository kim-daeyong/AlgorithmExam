package Basic.sort;

public class Bubble {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1]; a[idx1] = a[idx2]; a[idx2] = t;
    }

    // 두개를 비교해서 정리

    // 버블 정렬
    static void bubbleSort1(int[] a, int n) {
        for (int i = 0; i < n - 1; i++)
            for (int j = n - 1; j > i; j--)
                if (a[j - 1] > a[j])
                    swap(a, j - 1, j);
    }
    // 버블 정렬(버전 2)
    static void bubbleSort2(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;							// 패스의 교환 횟수를 기록합니다.
            for (int j = n - 1; j > i; j--)
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                }
            if (exchg == 0) break;					// 교환이 이루어지지 않으면 종료합니다.
        }
    }

    // 버블 정렬(버전 3)
    static void bubbleSort3(int[] a, int n) {
        int k = 0;								// a[k]보다 앞쪽은 정렬을 마친 상태
        while (k < n - 1) {
            int last = n - 1;					// 마지막으로 요소를 교환한 위치
            for (int j = n - 1; j > k; j--)
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            k = last;
        }
    }

}
