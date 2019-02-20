package island;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island {
    /*
    정사각형으로 이루어져 있는 섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램

    한 정사각형과 가로, 세로 또는 대각선으로 연결되어 있는 사각형은 걸어갈 수 있는 사각형이다.

    두 정사각형이 같은 섬에 있으려면, 한 정사각형에서 다른 정사각형으로 걸어서 갈 수 있는 경로가 있어야 한다. 지도는 바다로 둘러쌓여 있으며, 지도 밖으로 나갈 수 없다.

    입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다. w와 h는 50보다 작거나 같은 양의 정수이다.

    둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.

    입력의 마지막 줄에는 0이 두 개 주어진다.
     */

//섬의 개수 (BFS 버전)
        static int a[][];
        static int dx[] = {-1,-1,-1,0,0,1,1,1};
        static int dy[] = {-1,0,1,-1,1,-1,0,1};
        static int cnt=2;
        static int n,m;


        static void bfs(int x, int y){
            a[x][y]=cnt;
            Queue<Integer> qx=new LinkedList<Integer>();
            Queue<Integer> qy=new LinkedList<Integer>();
            qx.add(x);
            qy.add(y);
            while(!qx.isEmpty() && !qy.isEmpty()){
                x=qx.peek();
                y=qy.peek();
                qx.poll();
                qy.poll();

                for(int i=0;i<8;i++){
                    int cx=x+dx[i];
                    int cy=y+dy[i];
                    if(cx<n && cx>=0 && cy<m && cy>=0){
                        if(a[cx][cy]==1){
                            a[cx][cy]=cnt;
                            qx.add(cx);
                            qy.add(cy);
                        }
                    }
                }
            }

        }

        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            while(true){
                cnt=2;
                m=sc.nextInt();
                n=sc.nextInt();
                if(n==0 && m==0)
                    break;
                a=new int[n][m];
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++)
                        a[i][j]=sc.nextInt();
                }

                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(a[i][j]==1){
                            bfs(i,j);
                            cnt++;
                        }
                    }
                }

                System.out.println(cnt-2);

            }


        }

}
