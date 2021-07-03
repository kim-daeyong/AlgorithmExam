package programmers.stackqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class MethodDev {
    public static void main(String[] args) {
        // int[] progresses = {95, 90, 99, 99, 80, 99};
        // int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] result = solution(progresses, speeds);

        System.out.println(Arrays.toString(result));

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] result = new int[progresses.length];
        List<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack();

        while(checkArray(progresses)) {
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                    result[i] += 1;
                }
            }
        }
        
        for (int k = 0 ; k < result.length; k++) {
            if (stack.size() == 0) {
                stack.add(result[k]);
                continue;
            }
            int check = stack.pop();
            if (result[k] <= check) {
                stack.add(result[k]);
                stack.add(check);
            } else {
                stack.add(check);
                list.add(stack.size());
                stack.clear();
                stack.add(result[k]);
            }
        }
        list.add(stack.size());
        int[] answer = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            answer[j] = list.get(j);
        }
        return answer;
    }

    public static boolean checkArray(int[] array) {
        boolean result = false;
        for (int num : array) {
            if (num < 100) {
                result = true;
            }
        }
        return result;
    }
}


/*
다른사람

1. 


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}




2. 

class Solution {

    int progressesCount;
    int[] needDays; 

    ArrayList<Integer> workCountStorage;

    public int[] solution(int[] progresses, int[] speeds) {

        //Init
        progressesCount = progresses.length;
        needDays = new int[progressesCount];
        workCountStorage = new ArrayList<>();


        //필요한 작업일 계산
        this.calcNeedDays(progresses, speeds);

        //this.viewAll(needDays, 0);


        //동시에 진행된 프로세스 계산
        for(int step=0; step<progressesCount;)
        {
            int stepNeedDay = needDays[step];

            //날짜 동시에 경과
            for(int remainStep=step; remainStep<progressesCount; remainStep++)
            {
                needDays[remainStep] -= stepNeedDay;
            }

            //this.viewAll(needDays, step);

            //완료한 작업까지의 갯수
            int workCount = 1;
            for(;step+workCount<progressesCount; workCount++)
            {
                if(needDays[step+workCount] > 0)
                {
                    break;
                }
            }

            System.out.println("workCount:"+workCount);

            //완료한 작업 갯수 저장
            workCountStorage.add(workCount);

            //작업 갯수만큼 step 증가
            step += workCount;    

        }

        //int[] answer = {};
        int[] answer = Solution.convertIntegers(workCountStorage);
        return answer;
    }

    private void calcNeedDays(int[] progresses, int[] speeds)
    {
        for(int i=0; i<progressesCount; i++)
        {
            double remainProgress = 100 - progresses[i];
            double fNeedDay = remainProgress / speeds[i];

            needDays[i] = (int)Math.ceil(fNeedDay);
        }
    }

    public static int[] convertIntegers(ArrayList<Integer> integers)
    {
        int size = integers.size();
        int[] ret = new int[size];
        for (int i=0; i<size; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    private void viewAll(int[] array, int startIdx)
    {
        System.out.print("viewAll:");

        int arrayCount = array.length;
        for(int i=startIdx; i<arrayCount; i++)
        {
            System.out.print(array[i]+",");
        }

        System.out.println();
    }
}

*/