package algorithm.cracking.dataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 완전 이진 트리
 * 
 * 모든 높이에서 노드가 꽉 차있어야 하며, 마지막 단계는 꽉 차있지 않아도 되지만 왼쪽에서 오른쪽으로 채워져 있어야 한다.
 * 
 * main에서 입력받은 순서대로 이진 트리에 차곡차곡 쌓아서 완전 이진 트리를 만들어보자!
 * 
 */
public class CompleteBinaryTree {
    public static class BtreeNode<T> {
        BtreeNode<T> left;
        BtreeNode<T> right;
        T data;
        public BtreeNode(T data) {
            this.data = data;
            root = this;
        }
        public BtreeNode() {}

        private BtreeNode<T> mostLeftNode;
        private BtreeNode<T> root;

        public void addNode(T data) {
            if(root == null) {
                root = new BtreeNode<T>(data);
                return;
            }

            boolean isInserted = findAndInsert(root, data, true);
            if(!isInserted) {
                isInserted = findAndInsert(root, data, false);
            }
            if(!isInserted) {
                mostLeftNode.left = new BtreeNode<T>(data);
            }
        }
        public boolean findAndInsert(BtreeNode<T> node, T data, boolean isLeft) {
            if(node.left == null && node.right == null) {
                if(isLeft) this.mostLeftNode = node;
                return false;
            }
            if(node.left != null && node.right != null) { // FULL 이면, left 다시 search
                return findAndInsert(isLeft ? node.left : node.right, data, isLeft);
            } else {
                if(node.left == null) {
                    node.left = new BtreeNode<T>(data);
                } else if(node.right == null) {
                    node.right = new BtreeNode<T>(data);
                }
                return true;
            }
        }
        public void preOrder(BtreeNode<T> node) {
            if(node == null) return;
            System.out.print(node.data + "->");
            preOrder(node.left);
            preOrder(node.right);
        }
        public void levelOrder(BtreeNode<T> node) {
            if(node == null) return;
            Queue<BtreeNode<T>> queue = new LinkedList<>();
            queue.add(node);
            while(!queue.isEmpty()) {
                BtreeNode<T> n = queue.remove();
                System.out.print(n.data + "->");
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
            }            
        }
    }

    public static void main(String[] args) {

        //      A
        //  B       C
        //D   E   F 
        BtreeNode<Character> root = new BtreeNode<Character>('A');
        root.addNode('B');
        root.addNode('C');
        root.addNode('D');
        root.addNode('E');
        root.addNode('F');
        root.levelOrder(root);

    }
}
