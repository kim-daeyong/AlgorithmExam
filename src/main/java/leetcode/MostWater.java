package leetcode;

public class MostWater {
    
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        // int[] height = {1,1};
        int result = maxArea(height);
        System.out.println(result);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int up = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = 0;
            for(int j = i+1; j < height.length; j++) {
                temp = height[i] * height[j];
            }
            if (max < temp) {
                max = temp;
            }
            if (up < height[i]) {
                up = height[i];
            }
        }
        int a = max / up;

        if (a < up && a != 1 || height.length == 2) {
            max = a * a;
        }
        return max;
    }
}