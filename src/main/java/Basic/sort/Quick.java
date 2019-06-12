package Basic.sort;

import com.sun.org.apache.xerces.internal.util.IntStack;

public class Quick {
    //가장 빠른 알고리즘중 하나
    // 배열을 나누는 기준을 정해(피벗) 나눠서 비교한다.
    // 각 그룹에 대해 피벗 설정과 그룹나눔을 반복하며 모든 그룹이 1명이 되면 정렬을 마친다.
    // 피벗보다 작은것, 큰것으로 나누고 이걸 반복함
    // 배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];  a[idx1] = a[idx2];  a[idx2] = t;
    }

    // 퀵 정렬
    static void quickSort(int[] a, int left, int right) {
        int pl = left;					// 왼쪽 커서
        int pr = right;					// 오른쪽 커서
        int x = a[(pl + pr) / 2];		// 피벗

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr)  quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }
    // 퀵 정렬(배열을  나누는 과정을 출력합니다)2
    static void quickSort2(int[] a, int left, int right) {
        int pl = left;					// 왼쪽 커서
        int pr = right;					// 오른쪽 커서
        int x = a[(pl + pr) / 2];		// 피벗

        System.out.printf("a[%d]~a[%d]：{", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d , ", a[i]);
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr)  quickSort(a, left, pr);
        if (pl < right) quickSort(a, pl, right);
    }
/*
    // 비재귀적인 퀵정렬
    static void quickSort3(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1); // 나눌 범위의 왼쪽 끝요소의 인덱스를 저장하는 스택
        IntStack rstack = new IntStack(right - left + 1); //          오른쪽      //

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left  = lstack.pop();		// 왼쪽 커서
            int pr = right = rstack.pop();		// 오른쪽 커서
            int x = a[(left + right) / 2];		// 피벗

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);


            // 스택의 용량
            if (left < pr) {
                lstack.push(left);				// 왼쪽 그룹 범위의
                rstack.push(pr);				// 인덱스를 푸시합니다.
            }
            if (pl < right) {
                lstack.push(pl);				// 오른쪽 그룹 범위의
                rstack.push(right);				// 인덱스를 푸시합니다.
            }
        }
    }
    */
}
