package algorithm.codingInterview.datastructure.tree;

import java.util.Scanner;

/**
 * n이 주어졌을 때, 1~n 까지의 숫자를 완전이진트리로 구현하고, 전위/중위/후위 순회로 출력하자
 * 
 * 
 * 
 * @author  sunmin
 * @since   2021.10.04
 */
public class BinaryTreeWth2DArray {
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        int[][] tree = new int[n+1][2];

        int index = 1;
        int node_index = 1;

        while(index < n + 1) {
            tree[node_index][0] = ++ index;
            if(index == n) break;
            tree[node_index][1] = ++ index;
            node_index ++;
        }

        preOrder(tree, 1);
        System.out.println();
        inOrder(tree, 1);
        System.out.println();
        postOrder(tree, 1);
    }

    // Root -> Left -> Right
    public static void preOrder(int[][] tree, int root) {
        System.out.print(root + " "); // current
        if(tree[root][0] != 0) {
            preOrder(tree, tree[root][0]); // left
        }
        if(tree[root][1] != 0) {
            preOrder(tree, tree[root][1]); // right
        }  
    }

    // Left -> Root -> Right
    public static void inOrder(int[][] tree, int root) {
        if(tree[root][0] != 0) {
            inOrder(tree, tree[root][0]);
        }
        System.out.print(root + " ");
        if(tree[root][1] != 0) {
            inOrder(tree, tree[root][1]);
        }
    }

    // Left -> Right -> Root
    public static void postOrder(int[][] tree, int root) {
        if(tree[root][0] != 0) {
            postOrder(tree, tree[root][0]);
        }
        if(tree[root][1] != 0) {
            postOrder(tree, tree[root][1]);
        }
        System.out.print(root + " ");
    }

}
