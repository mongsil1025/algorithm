package algorithm.cracking.dataStructure;

/**
 * 이진 트리는 각 노드가 최대 두 개의 자식을 갖는 트리를 말한다.
 * 
 * Traversal Type은 세 가지가 있다.
 *  - inorder
 *  - preorder
 *  - postorder
 * 
 * 이진 트리를 구현해 보자 (완전이진트리 아님)
 * 
 */
public class BinaryTree {
    public static class BtreeNode<T> {
        BtreeNode<T> left;
        BtreeNode<T> right;
        T data;
        public BtreeNode(T data) {
            this.data = data;
        }
        public BtreeNode(BtreeNode<T> left, T data, BtreeNode<T> right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }
        public void preOrder(BtreeNode<T> node) {
            if(node == null) return;
            System.out.print(node.data + "->");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {

        //      8
        //  4       10
        //2   6         20

        BtreeNode<Integer> n1 = new BtreeNode<Integer>(2);
        BtreeNode<Integer> n2 = new BtreeNode<Integer>(6);
        BtreeNode<Integer> n3 = new BtreeNode<Integer>(n1, 4, n2);

        BtreeNode<Integer> n4 = new BtreeNode<Integer>(20);
        BtreeNode<Integer> n5 = new BtreeNode<Integer>(null, 10, n4);
        BtreeNode<Integer> root = new BtreeNode<Integer>(n3, 8, n5);

        root.preOrder(root);

    }

    
}
