package Basic.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

import Basic.Queue;

public class DfsBfs {

    /*
5 4 5
5 4
4 3
4 2
5 1
방문 순서
5 4 3 2 1 
a : [null, [5], [4], [4], [5, 3, 2], [4, 1]]
visit : [false, true, true, true, true, true]

                5
            /       \
        4               1
      /   \
    3       2
    */
    static ArrayList<Integer>[] a;
    static boolean[] visit;
    public static void main(String args[]) {
 
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();   //정점의 수
        int m = sc.nextInt();   //간선의 수
        int start = sc.nextInt();//시작할 정점
 
        a = new ArrayList[n+1];     //인덱스 편의상 n+1를 하고, 0번째 요소는 사용하지 않음
        visit = new boolean[n+1];   //인덱스 편의상 n+1를 하고, 0번째 요소는 사용하지 않음
         
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Integer>();
        }
 
        for (int i=0; i<m; i++) {
            int u = sc.nextInt();   //간선으로 이어진 정점1
            int v = sc.nextInt();   //정점1과 간선으로 이어진 정점2
            //양뱡향일 경우 양쪽다 저장해준다.
            a[u].add(v);
            a[v].add(u);
        }
 
       
        
        System.out.println("방문 순서");
        dfs(start);
         
        System.out.println("");
        System.out.println("a : "+Arrays.toString(a));
        System.out.println("visit : "+Arrays.toString(visit));
    }
     
     
    public static void dfs(int x) {
    
        visit[x] = true;
        System.out.print(x + " ");
         
        for (int y : a[x]) {
            if (visit[y] == false) {
                dfs(y);
            }
        }
    } 

    // dfs, 재귀, 인접 행렬, i 정점부터 시작한다. 
    // public static void dfs2(int i) { 
    //     visit[i] = true; System.out.print(i + " "); 
    //     for(int j=1; j<n+1; j++) { 
    //         if(map[i][j] == 1 && visit[j] == false) { 
    //             dfs(j); 
    //         } 
    //     }
    // }



    // bfs, q사용, 인접행렬, i 정점부터 시작한다.
	// public static void bfs(int i) {
	// 	Queue<Integer> q = new LinkedList<>();
	// 	q.offer(i);
	// 	visit[i] = true;
		
	// 	while(!q.isEmpty()) {
	// 		int temp = q.poll();
	// 		System.out.print(temp + " ");
	// 		for(int j=1; j<n+1; j++) {
	// 			if(map[temp][j] == 1 && visit[j] == false) {
	// 				q.offer(j);
	// 				visit[j] = true;
	// 			}
	// 		}
	// 	}
    // }
    
/*

    public static void dfs(int[][] a, boolean[] c, int v) {
        int n = a.length - 1;

        c[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i <= n; i++) {

            if (a[v][i] == 1 && !c[i]) {
                dfs(a, c, i);
            }

        }

    }

    public static void dfs(int[][] a, boolean[] c, int v, boolean flag) {
		Stack<Integer> stack = new Stack<>();
		int n = a.length - 1;

		stack.push(v);
		c[v] = true;
		System.out.print(v + " ");

		while (!stack.isEmpty()) {
			int vv = stack.peek();

			flag = false;

			for (int i = 1; i <= n; i++) {

				if (a[vv][i] == 1 && !c[i]) {
					stack.push(i);
					System.out.print(i + " ");

					c[i] = true;
					flag = true;
					break;
				}

			}

			if (!flag) {
				stack.pop();
			}

		}

	}

    public static void bfs(int[][] a, boolean[] c, int v) {
        Queue<Integer> q = new LinkedList<>();
        int n = a.length - 1;

        q.add(v);
        c[v] = true;

        while (!q.isEmpty()) {

            v = q.poll();
            System.out.print(v + " ");

            for (int i = 1; i <= n; i++) {

                if (a[v][i] == 1 && !c[i]) {
                    q.add(i);
                    c[i] = true;
                }

            }
        }

    }

        while(!q.isEmpty()) {
        v = q.poll();
        System.out.print(v + " ");

        for (int vv : a[v]) {

            if (!c[vv]) {
                q.add(vv);
                c[vv] = true;
            }

        }

}


-----------------------------------------------------------------

**1. 인접행렬 **: 정점의 개수가 적은 경우에만 사용하는 것을 권장한다. 왜냐하면, 정점n개에 대해 행렬의 크기가 n*n만큼 차지하기 때문에 n의 수가 시간복잡도 O(n^2)가 된다.
2. 인접리스트 : 모든 정점을 탐색하는 최악의 경우를 제외한 나머지 경우 인접행렬보다는 빠른 시간복잡도인 O(n+E)이다. (E는 간선의 개수)
3. 스택 : 1,2번과 달리 재귀호출을 하지 않는 방식으로 구현가능하다.


static int map[][];		    // 정점과 간선을 표현하는 행렬
                                    // 입력1로 예를 들면 map[1][2] == 1
                                    // 사이즈는 n+1로 지정 
static ArrayList<TreeMap<Integer, Integer>> arrayList;	// 인접리스트 표현
static LinkedList<Integer>[] adjList;			// 인접리스트 표현(LinkedList([]))
static boolean[] visited;		
static int n,m,v;			// 정점의 개수, 간선의 개수, 시작 정점
static String answer = "";
    
// 인접행렬로 구현한 DFS (정점의 개수가 작은 경우에만 사용하는걸 권장)
public static void dfs_adjacency_matrix(int v) {
	visited[v] = true;
	answer += v+" ";
	System.out.println(answer);
	for(int i=1;i<m;i++) {
		if(map[v][i] == 1 && !visited[i]) {
			dfs_adjacency_matrix(i);
		}
	}
}

// 인접리스트로 구현한 DFS
public static void dfs_adjacency_list(int v) {
	visited[v] = true;
	answer += v+" ";
	
	TreeMap<Integer, Integer> tmap = arrayList.get(v);
	for(int i : tmap.keySet()) {
		if(!visited[i]) {
			dfs_adjacency_list(i);
		}
	}
	
}

// 스택으로 구현한 DFS
public static void dfs_stack(int v) {
	Stack<Integer> stack = new Stack<Integer>();
	stack.push(v);
	
	while(!stack.isEmpty()) {
		int vv= stack.pop();
		visited[vv] = true;	
		answer += vv+" ";
		
		for(int i=1; i<n+1;i++) {
			if(map[vv][i] == 1 && !visited[i]) {
				stack.push(i);			// stack에 담고 빠져나온다.
				break;
			}
		}
	}
	
}

// 큐로 구현한 BFS (인접행렬)
public static void bfs_queue_adjacency_matrix(int v) {
	Queue<Integer> q = new LinkedList<Integer>();
	q.offer(v);
	visited[v] = true;
	
	while(!q.isEmpty()) {
		int vv = q.poll();
		answer += vv+" ";
		
		for(int i=1; i<n+1 ; i++) {
			if(map[vv][i] == 1 && !visited[i]) {
				q.offer(i);			// queu에 담고 계속 진행 map[vv][i~n] 끝까지 탐색
				visited[i] = true;
			}
		}
	}
}

// 큐로 구현하는 BFS (인접리스트)
public static void bfs_queue_adjacency_list(int v){
	Queue<Integer> q = new LinkedList<Integer>();
	visited[v] = true;
	q.add(v);

	while(!q.isEmpty()){
		v = q.poll();
		answer += v +" ";
		
		Iterator<Integer> it = adjList[v].listIterator();
		while(it.hasNext()){
			int w = it.next();
			if(!visited[w]){
				visited[w]=true;
				q.add(w);
			}
		}
	}
}
*/

    
}