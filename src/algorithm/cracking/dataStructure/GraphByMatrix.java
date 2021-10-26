package algorithm.cracking.dataStructure;

import java.util.Arrays;

/**
 * 인접행렬로 구현하는 그래프
 * 
 * 노드의 개수가 n 개라고 할때, n*n 의 인접행렬이 필요하다.
 * (i, j) 가 간선이라고 할때, M[i][j] 에 1로 업데이트 해준다.
 * 
 * + insert(matrix, u, v)
 * + findPath(matrix, u, v)
 * + degreeOfVertex(matrix, u)
 * 
 */
public class GraphByMatrix {
 
    // 0  -  3
    // |  \  |
    // 1  -  2
    public static void main(String[] args) {
        int n = 4;
        int[][] m = new int[n][n]; // 인접행렬 선언
        insert(m, 0, 3);
        insert(m, 0, 2);
        insert(m, 0, 1);

        insert(m, 3, 0);
        insert(m, 3, 2);

        insert(m, 1, 0);
        insert(m, 1, 2);

        insert(m, 2, 0);
        insert(m, 2, 3);
        insert(m, 2, 1);

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("(2, 0) has Path : " + hasPath(m, 2, 0));
        System.out.println("(1, 3) has Path : " + hasPath(m, 1, 3));

        System.out.println(Arrays.toString(degreeOfVertex(m, 0)));
    }

    public static void insert(int[][] m, int u, int v) {
        int n = m.length;
        if(u > n - 1 || v > n -1) throw new ArrayIndexOutOfBoundsException("정점의 번호가 유효하지 않습니다.");
        m[u][v] = 1;
    }

    // path 의 유무 탐색 (O(1))
    public static boolean hasPath(int[][] m, int u, int v) {
        return m[u][v] == 1;
    }

    // 정점 u에 대한 모든 인접한 노드 (degree) -> O(N)
    public static int[] degreeOfVertex(int[][] m, int u) {
        int[] adjacent = new int[m.length];
        int index = 0;
        for(int i=0; i<m.length; i++) {
            if(m[u][i] == 1) {
                adjacent[index++] = i;
            }
        }
        return adjacent;
    }

}
