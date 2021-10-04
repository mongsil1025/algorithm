package algorithm.codingInterview.datastructure.tree;

import java.util.Scanner;

/**
 * n이 주어졌을 때, 1~n 까지의 숫자를 완전이진트리로 구현하고, 전위/중위/후위 순회로 출력하자
 * 클래스를 써서 구현해보자
 * 
 * 
 * @author  sunmin
 * @since   2021.10.04
 */
public class BinaryTreeWthClass {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        public void add(int data, int leftData, int rightData) {
            if(root == null) {
                root = new Node(data);
                if(leftData > 0) {
                    root.left = new Node(leftData);
                }
                if(rightData > 0) {
                    root.right = new Node(rightData);
                }
            } else {
                // 빈 자리를 찾아서 추가한다.
                Node cursor = root;
                findAndInsert(cursor, data, leftData, rightData);
            }
        }

        public void findAndInsert(Node cursor, int data, int leftData, int rightData) {

            if(cursor == null) {
                return;
            }

            if(cursor.data == data) {
                cursor.left = new Node(leftData);
                cursor.right = rightData == 0 ? null : new Node(rightData);
            } else {
                findAndInsert(cursor.left, data, leftData, rightData); // left 탐색
                findAndInsert(cursor.right, data, leftData, rightData); // left 탐색
            }

        }

        public void preOrder(Node cursor) {
            System.out.print(cursor.data + " "); // current
            if(cursor.left != null) {
                preOrder(cursor.left);
            }
            if(cursor.right != null) {
                preOrder(cursor.right); // right
            }  
        }

        public void inOrder(Node cursor) {            
            if(cursor.left != null) {
                inOrder(cursor.left);
            }
            System.out.print(cursor.data + " "); // current
            if(cursor.right != null) {
                inOrder(cursor.right); // right
            }  
        }

        public void postOrder(Node cursor) {            
            if(cursor.left != null) {
                postOrder(cursor.left);
            }
            if(cursor.right != null) {
                postOrder(cursor.right); // right
            }
            System.out.print(cursor.data + " "); // current
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        Tree tree = new Tree();

        int index = 1;
        int node_index = 1;

        while(index < n + 1) {
            int left = ++ index;
            int right = ++ index;
            tree.add(node_index, left, right > n ? 0 : right);
            node_index ++;
        }

        Node cursor = tree.root;
        tree.preOrder(cursor);
        System.out.println();
        tree.inOrder(cursor);
        System.out.println();
        tree.postOrder(cursor);
    }
}
