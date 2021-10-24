package algorithm.codingInterview.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 깊이의 리스트
 * 
 * 이진 트리가 주어졌을 때, 같은 깊이에 있는 노드를 연결리스트로 연결해주는 알고리즘
 * 
 * 질문 : Complete Binary Tree 임을 보장하는가? 안에 data 는 자료형이 무엇인가?
 */
public class DepthList {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode next; // LinkedList 반환할 자료구조
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
        public TreeNode() {}
        public List<Integer> printNextList() {
            List<Integer> result = new ArrayList<>();
            result.add(data);
            TreeNode n = next;
            while(n != null) {
                result.add(n.data);
                n = n.next;
            }
            return result;
        }
    }
    // tree
    //          1
    //      4       5
    //   3     2  1 
    
    // output :
    // 1
    // 4 5
    // 3 2 1

    // preOrder Traversal
    public static void main(String[] args) {
        // 트리 생성
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(1);

        n1.left = n2; n1.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6;
        
        // 트리의 연결리스트 만들기
        makeNextLink(n1);
        // 출력
        printLinkedList(n1);
    }

    public static void makeNextLink(TreeNode node) {
        if(node.left == null) return;

        node.left.next = node.right;
        if(node.next != null && node.right != null) {
            node.right.next = node.next.left;
        }

        if(node.left != null) {
            makeNextLink(node.left);
        }
        if(node.right != null) {
            makeNextLink(node.right);
        }
    }

    public static void printLinkedList(TreeNode node) {
        while(node != null) {
            List<Integer> list = node.printNextList();
            System.out.println(list);
            node = node.left;
        }
    }
}
