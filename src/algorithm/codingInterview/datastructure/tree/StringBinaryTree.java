package algorithm.codingInterview.datastructure.tree;

import java.util.Scanner;

/**
 * 주어진 문자열을 순서대로 완전이진트리로 넣고 후위순회로 출력하자
 * 
 * Point : 순서대로 2개씩 원소를 추가하므로, 루트노드는 순차적으로만 지정해서 넣어주면 된다.
 * 만약 크기를 비교했어야 했다면, 빈자리를 찾을때, 대소를 비교했어야 했을 것이다.
 * 
 */
public class StringBinaryTree {

    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        public void add(char data, char leftData, char rightData) {
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

        public void findAndInsert(Node cursor, char data, char leftData, char rightData) {

            if(cursor == null) {
                return;
            }

            if(cursor.data == data) {
                cursor.left = new Node(leftData);
                cursor.right = rightData == 0 ? null : new Node(rightData);
            } else {
                findAndInsert(cursor.left, data, leftData, rightData); // left 탐색
                findAndInsert(cursor.right, data, leftData, rightData); // right 탐색
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
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        scanner.close();

        int length = str.length();
        int index = 0;
        int node_index = 0;

        Tree tree = new Tree();

        while(index < length - 1) {
            char left = str.charAt(++index);
            char right;
            if(index + 1 == length) {
                right = 0;
            } else {
                right = str.charAt(++index);
            }
            
            tree.add(str.charAt(node_index), left, right);

            node_index++;
        }

        Node cursor = tree.root;
        tree.postOrder(cursor);

    }
}
