package algorithm.cracking.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 아무 특성도 없는 Tree 를 구현해보자
 * 
 * - 트리는 하나의 루트 노드를 갖는다.
 * - 루트 노드는 0개 이상의 자식 노드를 갖고 있다.
 * - 그 자식 노드 또한 0개 이상의 자식 노드를 갖고 있고, 반복적으로 정의된다.
 * - cycle 이 없다.
 * - 어떤 자료형으로도 표현 가능하다.
 * - 부모 노드로의 link가 있을 수도 있고 없을 수도 있다.
 * 
 */
public class AbnormalTree {
    public static class TreeNode<T> {
        T data;
        List<TreeNode<T>> children; // 0개 이상 가질 수 있다.

        int DEFAULT_CAPACITY_CHILDEREN_SIZE = 10;

        public TreeNode(T data) {
            this.data = data;
            this.children = new ArrayList<>();
        }

        int size;
        public void addChild(TreeNode<T> data) {
            if(size == DEFAULT_CAPACITY_CHILDEREN_SIZE) throw new IndexOutOfBoundsException();
            children.add(data);
        }

        public void print(TreeNode<T> node) {
            System.out.print(node.data);
            if(node.children.size() > 0) {
                System.out.print("[");
                for(int i=0; i<node.children.size(); i++) {
                    print(node.children.get(i));
                    if(i < node.children.size() - 1) {
                        System.out.print(",");
                    }
                }
                System.out.print("]");
            }
        }
    }

    public static void main(String[] args) {
        TreeNode<Character> root = new TreeNode<Character>('A');
        root.addChild(new TreeNode<Character>('B'));
        TreeNode<Character> c = new TreeNode<Character>('C');
        c.addChild(new TreeNode<Character>('c'));
        c.addChild(new TreeNode<Character>('a'));
        c.addChild(new TreeNode<Character>('t'));
        root.addChild(c);
        root.addChild(new TreeNode<Character>('D'));

        root.print(root);
    }
}
