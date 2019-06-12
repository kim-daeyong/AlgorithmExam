package Basic.sort;

public class Fsort {

    // 도수정렬
    // 요소의 대소관계를 판단하지않고 빠르게 정렬

    // 도수 정렬(0 이상 max 이하의 값을 입력합니다）
    static void fSort(int[] a, int n, int max) {
        int[] f = new int[max + 1];		// 누적 도수
        int[] b = new int[n];			// 작업용 목적 배열

        for (int i = 0;     i < n;    i++) f[a[i]]++;				// 1단계
        for (int i = 1;     i <= max; i++) f[i] += f[i - 1];		// 2단계
        for (int i = n - 1; i >= 0;   i--) b[--f[a[i]]] = a[i];		// 3단계
        for (int i = 0;     i < n;    i++) a[i] = b[i];				// 4단계
    }

}
