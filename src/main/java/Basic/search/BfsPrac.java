package Basic.search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/*

5 5 3

5 5 3
5 4
5 2
1 2
3 4
3 1

BFS - 인접리스트
3 1 4 2 5 

  /  2  - 5
1         |
  \  3  - 4


4 5 1 3
1 2
1 3
1 4
2 4
3 4

BFS - 인접행렬
1 2 3 4 

  /  2 \
1   -   4
  \  3 /
*/

public class BfsPrac {
    static int V, E, S;
    static int x, y;
    static ArrayList<Integer> [] graph;
     
    static ArrayList<Integer> bfs;
     
    static boolean [] visit;  //이미 방문한 정점의 정보를 담을 배열
     
    static java.util.Queue<Integer> Q;
     
    static BufferedReader br;
    static BufferedWriter bw;
     
    static StringTokenizer st;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 개수 
        int m = sc.nextInt(); // 간선의 개수 
        int v = sc.nextInt(); // 탐색을 시작할 정점의 번호 
        
        boolean visited[] = new boolean[n + 1]; // 방문 여부를 검사할 배열 

        LinkedList<Integer>[] adjList = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        // 두 정점 사이에 여러 개의 간선이 있을 수 있다.
        // 입력으로 주어지는 간선은 양방향이다.
        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for (int i = 1; i <= n; i++) { 
            Collections.sort(adjList[i]); // 방문 순서를 위해 오름차순 정렬 
        }

        System.out.println("BFS - 인접리스트");
        bfs_list(v, adjList, visited);

        // sc.close();

        // Scanner sc1 = new Scanner(System.in);

		// int n1 = sc1.nextInt(); // 정점의 개수 
		// int m1 = sc1.nextInt(); // 간선의 개수 
		// int v3 = sc1.nextInt(); // 탐색을 시작할 정점의 번호 

        // boolean visited1[] = new boolean[n + 1]; 

        // int[][] adjArray = new int[n1+1][n1+1];

        // // 두 정점 사이에 여러 개의 간선이 있을 수 있다.
        // // 입력으로 주어지는 간선은 양방향이다.
        // for(int i = 0; i < m1; i++) {
        //     int v1 = sc.nextInt();
        //     int v2 = sc.nextInt();

        //     adjArray[v1][v2] = 1;
        //     adjArray[v2][v1] = 1;
        // }

        // System.out.println("BFS - 인접행렬");
        // bfs_array(v3, adjArray, visited1);
    }

    public static void bfs_list(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true; 
        queue.add(v);
    
        while(queue.size() != 0) { 
            v = queue.poll(); 
            System.out.print(v + " ");
    
            Iterator<Integer> iter = adjList[v].listIterator();
            while(iter.hasNext()) { 
                int w = iter.next(); 
                if(!visited[w]) { 
                    visited[w] = true; 
                    queue.add(w); 
                } 
            }
        }
    }


    public static void bfs_array(int v, int[][] adjArray, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        int n = adjArray.length - 1;
    
        q.add(v);
        visited[v] = true;
    
        while (!q.isEmpty()) {
            v = q.poll();
            System.out.print(v + " ");
    
            for (int i = 1; i <= n; i++) {
                if (adjArray[v][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
     
    // public static void main(String[] args) throws IOException {
    //     br = new BufferedReader(new InputStreamReader(System.in));
    //     bw = new BufferedWriter(new OutputStreamWriter(System.out));
         
    //     st = new StringTokenizer(br.readLine());
         
    //     V = Integer.parseInt(st.nextToken());
    //     E = Integer.parseInt(st.nextToken());
    //     S = Integer.parseInt(st.nextToken());
         
    //     graph = new ArrayList[E+1];
        
    //     //각 정점의 간선으로 연결되어있는 정점들에 대한 정보를 담을 리스트를 초기화
    //     for (int i = 1; i <= E; i++) {
    //         graph[i] = new ArrayList<Integer>();
    //     }
        
    //     for (int i = 0; i < E; i++) {
    //         st = new StringTokenizer(br.readLine());
    //         x = Integer.parseInt(st.nextToken());
    //         y = Integer.parseInt(st.nextToken());
            
    //         //방향성이 없는 그래프이기 때문에 연결되는 양쪽에 서로에 대한 정보를 넣어줌
    //         graph[x].add(y);
    //         graph[y].add(x);
    //     }
         
    //     //연결된 간선 정보를 정렬
    //     for (int i=1; i<=E; i++){
    //         Collections.sort(graph[i]);
    //     }
         
    //     bfsSol();
    //     for (int i = 0; i < bfs.size(); i++) {
    //         System.out.print(bfs.get(i)+ " ");
    //     }
    // }
     
    // private static void bfsSol(){
    //     bfs = new ArrayList<Integer>();
    //     visit = new boolean [E +1];
    //     Q = new LinkedList<Integer>();
        
    //     //시작정점을 큐에 넣어줌
    //     Q.add(S);
    //     //시작정점을 방문했다는 정보 저장
    //     visit[S] = true;
        
    //     //큐에 정점이 없어질 때까지 반복
    //     while(!Q.isEmpty()){
    //         //큐에서 정점을 poll해서 이동함
    //         int q = Q.poll();
    //         bfs.add(q);
    //         //이동한 정점에서 연결된 정점들을 큐에 넣어주고 visit배열에 체크
    //         for(int i : graph[q]){
    //             if(!visit[i]){
    //                 Q.add(i);
    //                 visit[i] = true;
    //             }
    //         }
    //     }
         
    // }
}