package thisiscote;

public class NumCardGame {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int[] result = new int[n];
        int[][] array = {{3,1,2},{4,1,4},{2,2,2}};
        // result = 2 각 행의 제일 작은수중 제일 큰 수
        int max = 0;
        for (int i = 0; i<n ; i++){
            int min = array[i][0];
            for(int j = 0; j<m; j++){
                min = Math.min(array[i][j],min);
                result[i] = min;
            }
        }
        for (int i = 0; i<n ; i++){
            if(i == n-1){
                break;
            }else{
                max = Math.max(result[i], result[i+1]);
        
            }
        }
        System.out.println(max);
    }
}