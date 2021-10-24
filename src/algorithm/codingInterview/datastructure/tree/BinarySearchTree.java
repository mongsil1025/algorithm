package algorithm.codingInterview.datastructure.tree;

/**
 * 이진 트리는 무조건 (left, data, right) 로 짱박아서 insert 하자.
 * findAndInsert 메서드로 노드들을 찾아가면서 왼쪽 오른쪽에 노드 넣기
 */
public class BinarySearchTree {
    static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }

    static class BinaryTree<T> {
        Node<T> root = null;
        public BinaryTree() {}

        public Node<T> createNode(Node<T> left, T data, Node<T> right) {
            Node<T> node = new Node(data);
            node.left = left;
            node.right = right;

            return node;
        }

        public void inOrder(Node<T> node) {
            if(node.left != null) {
                inOrder(node.left);
            }
            System.out.print(node.value + "->");
            if(node.right != null) {
                inOrder(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree<Integer> t = new BinaryTree<>();
        Node<Integer> n1 = t.createNode(null, 3, null);
        Node<Integer> n2 = t.createNode(null, 2, null);
        Node<Integer> n3 = t.createNode(null, 1, null);
        Node<Integer> n4 = t.createNode(n1, 4, n2);
        Node<Integer> n5 = t.createNode(n3, 5, null);
        Node<Integer> n6 = t.createNode(n4, 1, n5);
        t.root = n6;
        t.inOrder(t.root);
        
    }
    

}
