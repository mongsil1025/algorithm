package algorithm.cracking.dataStructure;

/**
 * 완전 이진 트리는 왼쪽에서 -> 오른쪽으로 무조건 노드가 들어가기 때문에, 간단하게 배열로 표현할 수 도 있다.
 * 
 * 이진 트리의 높이가 k 이면, 최대 2^k-1개의 노드가 있다. 저만큼의 공간을 배열에 할당한다.
 * OR 가변배열을 이용해도 된다.
 * 
 * ❗ 계산을 쉽게 하기 위해서 인덱스는 1부터 시작한다.
 * 노드 i의 부모노드 인덱스 = i/2
 * 노드 i의 왼쪽 자식노드 인덱스 = 2i
 * 노드 i의 오른쪽 자식노드 인덱스 = 2i + 1
 * 
 */
public class CompleteBinaryTreeByArray {

    public static class BtreeNode {
        int treeHeight = 0;
        int[] treeTable = new int[100];
        int index = 1;

        public BtreeNode() {}
        public void addNode(int data) {
            treeTable[index] = data;
            index++;
        }
        public int getLeftNode(int i) {
            return treeTable[2*i];
        }
        public int getRightNode(int i) {
            return treeTable[2*i + 1];
        }
        public void print() {
            for(int i=1; i<treeTable.length; i++) {
                if(treeTable[i] != 0) {
                    System.out.print(treeTable[i] + "->");
                }
            }
        }

    }
    
    public static void main(String[] args) {
        BtreeNode tree = new BtreeNode();
        tree.addNode(1);
        tree.addNode(2);
        tree.addNode(3);
        tree.addNode(4);
        tree.addNode(5);
        tree.print();
        System.out.println();
        System.out.println(tree.getRightNode(2));
    }
}
