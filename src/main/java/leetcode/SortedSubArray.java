package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortedSubArray {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        int result = findUnsortedSubarray(nums);
        System.out.println(result);
    }

    public static int findUnsortedSubarray(int[] nums) {
        int result = 0;
        List<Integer> list = new ArrayList<>();
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);
        for (int i = 0; i < nums.length; i++) {
            if(temp[i] != nums[i]){
                list.add(i);
            }
        }
        list.stream().forEach(i-> System.out.println(i));
        if(list.size() != 0){
            int max = Collections.max(list);
            int min = Collections.min(list);
            // System.out.println(max);
            // System.out.println(min);
            result = max-min+1;
        }
        return result;
    }
}