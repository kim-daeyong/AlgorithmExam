package Basic.sort;

public class Merge {


    // 병합정렬

    // 앞부분과 뒷부분으로 나누어 각각 정렬한 다음 병
    // 정렬을 마친 배열 a, b를 병합하여 배열 c에 저장합니다.
    static void merge(int[] a, int na, int[] b, int nb, int[] c) {
        int pa = 0;
        int pb = 0;
        int pc = 0;

        while (pa < na && pb < nb)	// 작은 값을 저장합니다.
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];

        while (pa < na)				// a에 남아 있는 요소를 복사합니다.
            c[pc++] = a[pa++];

        while (pb < nb)				// b에 남아 있는요소를 복사합니다.
            c[pc++] = b[pb++];
    }


    static int[] buff;	// 작업용 배열

    // a[left] ~ a[right]를 재귀적으로 병합 정렬
    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(a, left, center);			// 배열의 앞부분을 병합 정렬합니다.
            __mergeSort(a, center + 1, right);		// 배열의 뒷부분을 병합 정렬합니다.

            for (i = left; i <= center; i++)
                buff[p++] = a[i];

            while (i <= right && j < p)
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];

            while (j < p)
                a[k++] = buff[j++];
        }
    }

    // 병합 정렬
    static void mergeSort(int[] a, int n) {
        buff = new int[n];				// 작업용 배열을 생성합니다.

        __mergeSort(a, 0, n - 1);		// 배열 전체를 병합 정렬합니다.

        buff = null;					// 작업용 배열을 해제합니다.
    }

}
