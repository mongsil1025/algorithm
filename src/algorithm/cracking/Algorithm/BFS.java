package algorithm.cracking.Algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import algorithm.cracking.dataStructure.GraphByMatrix;
import algorithm.cracking.dataStructure.GraphByList.Graph;

/**
 * 너비우선탐색은 시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨여져 있는 정점을 나중에 방문하는 방법이다.
 * 
 * 큐를 활용해서 인접한 노드들을 넣어준다.
 * 
 * Description : 
 *  - BFS는 최단경로를 찾는데 유용하다.
 * 
 */
public class BFS {

    static int MAX_VERTICES = 10;
    static boolean[] visited = new boolean[MAX_VERTICES];

    public static void bfs(int[][] m, int v) {
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);
        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            int u = queue.remove();
            for(int i=0; i<MAX_VERTICES; i++) {
                if(m[u][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    System.out.print(i + " ");
                    queue.add(i);
                }
            }
        }
    }

    public static void bfs(Graph<Integer> g, int v) {
        Queue<Integer> queue = new LinkedList<>();

        visited[v] = true;
        queue.add(v);
        System.out.print(v + " ");

        while(!queue.isEmpty()) {
            int u = queue.remove();
            List<Integer> adjacents = g.hashMap.get(u);
            for(Integer w : adjacents) {
                if(!visited[w]) {
                    visited[w] = true;
                    System.out.print(w + " ");
                    queue.add(w);
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

        bfs(graph, 0);
        System.out.println();
        visited = new boolean[MAX_VERTICES];

        // 2. 인접리스트 테스트
        Graph<Integer> graphList = new Graph<>();
        
        graphList.addNodes(0, new Integer[] {1, 2, 4});
        graphList.addNodes(1, new Integer[] {0, 2});
        graphList.addNodes(2, new Integer[] {1, 0, 3, 4});
        graphList.addNodes(3, new Integer[] {2, 4});
        graphList.addNodes(4, new Integer[] {0, 2, 3});

        bfs(graphList, 0);

    }
    
}
