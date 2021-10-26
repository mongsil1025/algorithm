package algorithm.cracking.Algorithm;

import java.util.List;
import java.util.Stack;

import algorithm.cracking.dataStructure.GraphByMatrix;
import algorithm.cracking.dataStructure.GraphByList.Graph;

/**
 * 깊이 우선 탐색은 정점의 자식들을 먼저 탐색하는 방식이다.
 * 
 * 1) visited 플래그로 재귀호출하는 방법과
 *  - visited[MAX_VERTICES] 의 공간이 필요하다. S.C O(n) 
 * 2) stack 을 활용한 재귀호출 방법이 있다.
 * 
 * 또한, 그래프가 인접행렬 또는 인접리스트인지에 따라 구현방법이 조금씩 다르다.
 * 
 */
public class DFS {

    // 인접행렬의 DFS 순회
    static int MAX_VERTICES = 10;
    static boolean[] visited = new boolean[MAX_VERTICES];

    public static void dfs(int[][] m, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int i=0; i<MAX_VERTICES; i++) {
            if(m[v][i] == 1 && !visited[i]) { // 자식이 unvisited라면 바로 재귀호출
                dfs(m, i);
            }
        }
    }

    // 인접리스트의 DFS 순회
    public static void dfs(Graph<Integer> g, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        List<Integer> adjacents = g.hashMap.get(v);
        for(Integer w : adjacents) {
            if(!visited[w]) {
                dfs(g, w);
            }
        }
    }

    // 인접행렬의 DFS 순회 - 스택 사용
    public static void dfs_stack(int[][] m, int start) {
        Stack<Integer> need_visit = new Stack<>();
        boolean[] visited = new boolean[MAX_VERTICES];
        
        need_visit.add(start);

        while(!need_visit.isEmpty()) {
            int v = need_visit.pop();
            if(!visited[v]) {
                visited[v] = true;
                System.out.print(v + " ");

                for(int i=0; i<m.length; i++) {
                    if(!visited[i] && m[v][i] == 1) {
                        need_visit.add(i);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 1. 인접행렬 테스트
        // 0 {1, 2, 4}
        // 1 {0, 2}
        // 2 {1, 0, 3, 4}
        // 3 {2, 4}
        // 4 {2, 3, 0}
        int[][] graph = new int[MAX_VERTICES][MAX_VERTICES];
        GraphByMatrix.insert(graph, 0, 1);
        GraphByMatrix.insert(graph, 0, 2);
        GraphByMatrix.insert(graph, 0, 4);

        GraphByMatrix.insert(graph, 1, 0);
        GraphByMatrix.insert(graph, 1, 2);

        GraphByMatrix.insert(graph, 2, 1);
        GraphByMatrix.insert(graph, 2, 0);
        GraphByMatrix.insert(graph, 2, 3);
        GraphByMatrix.insert(graph, 2, 4);

        GraphByMatrix.insert(graph, 3, 2);
        GraphByMatrix.insert(graph, 3, 4);

        GraphByMatrix.insert(graph, 4, 2);
        GraphByMatrix.insert(graph, 4, 3);
        GraphByMatrix.insert(graph, 4, 0);

        dfs(graph, 0);
        System.out.println();
        visited = new boolean[MAX_VERTICES];

        dfs_stack(graph, 0);

        System.out.println();
        visited = new boolean[MAX_VERTICES];


        // 2. 인접리스트 테스트
        Graph<Integer> graphList = new Graph<>();
        
        graphList.addNodes(0, new Integer[] {1, 2, 4});
        graphList.addNodes(1, new Integer[] {0, 2});
        graphList.addNodes(2, new Integer[] {1, 0, 3, 4});
        graphList.addNodes(3, new Integer[] {2, 4});
        graphList.addNodes(4, new Integer[] {0, 2, 3});

        dfs(graphList, 0);

    }
    
}
