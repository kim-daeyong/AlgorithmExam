package thisiscote;

import java.util.ArrayList;
import java.util.Collections;

public class AreaOfIsland {
	 private static int[] X = {-1,0,1,0}; // X축의 상하좌우 이동을 위한 배열 
	 private static int[] Y = {0,1,0,-1}; // Y축의 상하좌우 이동을 위한 배열 (x,y 짝만 맞추어주면 상하좌우든 하좌우상 이든 순서 상관x)
	 private static int cnt=1;
	 
	 
	 public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<Integer>(); //각 영역의 넓이를 저장할 ArrayList 생성
		AreaOfIsland b = new AreaOfIsland(); 
		int[][] map = {{1,1,1,0,1},
					   {1,1,0,0,1},
					   {1,0,1,1,0},
					   {0,0,1,1,1},
					   {0,0,1,1,1}};
		boolean[][] check = new boolean[map.length][map[0].length]; //방문한 곳을 체크하기 위한 배열 행렬 생성
		
		for(int i=0; i<map.length; i++) {
			//System.out.println("다음 찾기 시작");
			//(0,0) 부터 탐색 시작 후 1을 만나면 넓이 구하기 시작
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == 1) {
					b.dfs(i,j,check,map);
					arr.add(cnt);
					cnt = 1;
				}
			// 아닌경우 continue
				else
					continue;
			}
        }
        Collections.sort(arr);
        int arrsize = arr.size();

        System.out.println("arr : "+ arr);
        System.out.println(arrsize);
	}
	 
	 public void dfs(int x, int y, boolean[][] check,int[][] map) {
		 
		//  System.out.println(x+","+y);
        check[x][y] = true;
		 map[x][y] = 0;
		 
		 for(int i=0; i<4; i++) {
			 int nextX = x + X[i];
			 int nextY = y + Y[i];
			//상,하,좌,우 이동 중 범위가 넘어서는 경우 continue
			if(nextX <0 || nextY<0 || nextX>=check.length || nextY>=check.length) {continue;}
			//방문한곳은 continue
			if(check[nextX][nextY]){continue;}
			//0은 벽이라서 이동할 경로가 벽이면 continue
			if(map[nextX][nextY] == 0) {check[nextX][nextY] = true; continue;}
			
			dfs(nextX,nextY,check,map);
			cnt++;
		 }
	 }
}