package algorithm.cracking.dataStructure;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * 이진 탐색트리의 정의는 다음과 같다.
 * 
 * - 모든 노드의 키는 유일하다. (중복된 값이 없다)
 * - 왼쪽 서브 트리의 키 < 루트 키
 * - 오른쪽 서브 트리의 키 > 루트 키
 * - 왼쪽과 오른쪽 서브 트리도 이진 탐색 트리다
 * 
 * insert(int data)
 * search(int data)
 * delete(int data)
 * getSuccessor() -> parent Node 를 가지고 있는다.
 * print()
 * 
 * - 노드의 삭제 로직은 정말 복잡하다.
 *  - 삭제할 노드가 단말 노드일 경우
 *  - 삭제할 노드가 왼쪽 서브트리 or 오른쪽 서브트리 하나만 가질 경우
 *  - 삭제노드가 2개의 서브트리를 모두 가질 경우
 *      - successor 를 find 해서 replace 해야 한다.
 *          - successor는 이렇게 구한다.
 *              - n이 오른쪽 서브트리를 가질 경우, 오른쪽 서브트리에서 맨 왼쪽 노드가 successor다.
 *              - n이 오른쪽 서브트리를 안가질 경우, left는 모두 순회한 것이므로 순회하지 않은 parent 가 successor이다. * 
 */
public class BinarySearchTree {
    public static class BtreeNode {
        BtreeNode left;
        BtreeNode right;
        BtreeNode parent;
        int data;
        public BtreeNode(int data) {
            this.data = data;
        }
        BtreeNode root;

        public void insert(int data) {
            if(root == null) {
                root = new BtreeNode(data);
                return;
            }
            searchAndInsert(root, data);
        }
    
        private BtreeNode searchAndInsert(BtreeNode n, int data) {
            if(n == null) {
                return null;
            }
            // Found
            if(n.data == data) {return n;}
    
            // Not Found, continue searching
            if(data < n.data) {
                // left
                BtreeNode node = searchAndInsert(n.left, data);
                if(node == null) {
                    n.left = new BtreeNode(data);
                    n.left.parent = n;
                    return n;
                } else {
                    return node;   
                }
            } else {
                // right
                BtreeNode node = searchAndInsert(n.right, data);
                if(node == null) {
                    n.right = new BtreeNode(data);
                    n.right.parent = n;
                    return n;
                } else {
                    return node;
                }
            }        
        }

        public BtreeNode search(BtreeNode node, int data) {
            if(node == null) {
                return null;
            }

            if(node.data == data) {
                return node;
            } else if(data < node.data) {
                return search(node.left, data);
            } else {
                return search(node.right, data);
            }
        }
    
        public void levelTraversal(BtreeNode node) {
            Queue<BtreeNode> queue = new LinkedList<>();
            queue.add(node);
            while(!queue.isEmpty()){
                BtreeNode n = queue.remove();
                System.out.print(n.data + "->");
                if(n.left != null) {
                    queue.add(n.left);
                }
                if(n.right != null) {
                    queue.add(n.right);
                }
            }
        }

        public void delete(BtreeNode node, int data) {
            BtreeNode deleteNode = search(node, data);
            if(deleteNode == null) {
                throw new NoSuchElementException("삭제할 노드가 없습니다.");
            }
            // 1. 삭제노드가 단말노드일 경우
            if(deleteNode.left == null && deleteNode.right == null) {
                BtreeNode parent = deleteNode.parent;
                if(parent.left == deleteNode) {
                    parent.left = null;
                } else if(parent.right == deleteNode) {
                    parent.right = null;
                }
            } else if(deleteNode.left == null && deleteNode.right != null) { // 오른쪽 노드 하나만 있을 경우
                deleteNode.parent.right = deleteNode.right;
            } else if(deleteNode.right == null && deleteNode.left != null) { // 왼쪽 노드 하나만 있을 경우
                deleteNode.parent.left = deleteNode.left;
            } else { // 왼쪽 오른쪽 모두 있을 경우
                // successor 찾아서 교체해줘야 한다.

                // 삭제될 노드의 오른쪽 subtree를 저장해둔다.
                BtreeNode rightSubTree = deleteNode.right;

                BtreeNode replaceNode = getSuccNode(deleteNode);

                if(deleteNode == root) {
                    root = deleteNode;
                } else if(deleteNode.parent.left == deleteNode) {
                    deleteNode.parent.left = replaceNode;
                } else {
                    deleteNode.parent.right = replaceNode;
                }
                replaceNode.right = rightSubTree;
                replaceNode.left = deleteNode.left;
            }
        }

        public BtreeNode getSuccNode(BtreeNode node) {

            if(node.right != null) { // 오른쪽 서브트리에서 가장 왼쪽에 있는 노드가 후속자이다.
                return getMostLeftNode(node.right);
            } else {
                // 왼쪽 서브트리는 모두 순회한것이므로 parent 로 올라가야한다.
                // 어떤 parent? left 서브트리에 속한 parent!
                BtreeNode q = node;
                BtreeNode x = q.parent;
                while(x != null && x.left != q) { // node 의 부모노드 중 아직 순회되지 않은 노드 (왼쪽에 있어야 한다)
                    q = x;
                    x = x.parent;
                }
                return x;
            }
        }

        public BtreeNode getMostLeftNode(BtreeNode node) {
            if(node == null) return null;
            while(node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

    //          10
    //      5        15
    //   4     7  13

    // case 1. 정렬된 배열을 BST로 구현하는 것이라면
    // - 배열의 중간값을 시작으로, left/right 로 나누고 분할정복해서 BST 를 만들어간다.
    // case 2. 임의로 들어오는 값들에 대해 BST로 구현하는 것이라면
    // - 탐색 과정을 거쳐서 insert를 해야 한다.
    public static void main(String[] args) {
        BtreeNode tree = new BtreeNode(10);
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(4);
        tree.insert(7);
        tree.insert(13);

        // insert Test
        tree.levelTraversal(tree.root);
        System.out.println();

        // search Test
        BtreeNode found = tree.search(tree.root, 15);
        if(found == null) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found");
        }

        // successor        
        BtreeNode successor = tree.getSuccNode(tree.search(tree.root, 4));
        System.out.println(successor.data);

        // delete
        tree.delete(tree.root, 7);
        tree.levelTraversal(tree.root);

    }

}
