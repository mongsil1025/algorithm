package algorithm.codingInterview.datastructure.tree;

import java.util.List;

/**
 * 이진 탐색 트리 구현
 * 
 * 1. root 노드를 포함한 Tree 객체를 만든다.
 *  - add 호출할 때마다, root 로부터 내려오면서 비교하면서 생성한다.
 *  - O(NlogN)
 * 
 * 2. Node 클래스 객체 하나로 만들 수 있다. (문제에서 이미 정렬된 원소를 줬기 때문이다.)
 *  - 분할정복 알고리즘을 이용한다.
 *  - 정렬된 리스트가  있기 때문에, 중간원소를 노드로 만들고, left/right 를 재귀적으로 호출해서 마지막에 합병한다.
 *  - 이 방법은 O(N) 의 시간복잡도를 가진다.
 *  - 또한, 처음에 만들어진 Node를 바로 반환한다. (분할돼서 만들어진 노드는 계속 붙어지기 때문)
 */
public class BinarySearchTreeWithSortedArray {
    static class Node {
        Node left;
        Node right;
        int data;
        public Node(int data) {
            this.data = data;
        }
        public void inorder(Node node) {
            if(node.left != null) {
                inorder(node.left);
            }
            System.out.print(node.data + "->");
            if(node.right != null) {
                inorder(node.right);
            }
        }
    }
    static class Tree {
        Node root;
        public Tree() {}
        // 트리에 노드를 추가한다.
        public void add(Node node, int data) { // O(logN)
            if(node == null) {
                Node n = new Node(data);
                root = n;
                return;
            }
            Node n = new Node(data);
            if(node.data > data) {
                if(node.left == null) {
                    node.left = n;
                } else {
                    add(node.left, data);
                }
            } else {
                if(node.right == null) {
                    node.right = n;
                } else {
                    add(node.right, data);
                }
            }
        }
        // inorder traversal -> 배열과 같은 순서대로 나와야 한다.
        public void inorder(Node node) {
            if(node.left != null) {
                inorder(node.left);
            }
            System.out.print(node.data + "->");
            if(node.right != null) {
                inorder(node.right);
            }
        }
    }
    public static void main(String[] args) {
        // List<Integer> list = Arrays.asList(2, 4, 6, 8, 10, 20);
        // Tree tree = new Tree();

        // // tree 생성
        // addToTree(list, tree);

        // // tree 프린트
        // tree.inorder(tree.root);
        Node tree = createMinimalBST(new int[] {2,4,6,8,10,20});
        tree.inorder(tree);
    }

    public static void addToTree(List<Integer> list, Tree tree) {
        if(list.size() == 0) return;

        int length = list.size();
        int curr = list.get(length/2);
        
        tree.add(tree.root, curr); // O(N)
        addToTree(list.subList(0, length/2), tree); // S.C O(n/2)
        addToTree(list.subList(length/2 + 1, length), tree); // S.C O(n/2)
        
    }

    public static Node createMinimalBST(int[] array) {
        return createMinimalBST(array, 0, array.length - 1);
    }

    public static Node createMinimalBST(int[] array, int start, int end) {
        if(end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(array[mid]);
        node.left = createMinimalBST(array, start, mid - 1);
        node.right = createMinimalBST(array, mid + 1, end);
        return node;
    }
}
