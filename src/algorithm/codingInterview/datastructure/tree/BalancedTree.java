package algorithm.codingInterview.datastructure.tree;

public class BalancedTree {
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int d) {
            this.data = d;
        }
    }

    public static int getHeight(TreeNode node) {
        if(node == null) return -1; 

        // left랑 right 의 height를 체크를 하면서 균형잡히지 않은게 있다면 즉시 반환한다.
        int left = getHeight(node.left);
        if(left == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int right = getHeight(node.right);
        if(right == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if(Math.abs(left - right) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(left, right) + 1;
        }
        // 이 재귀에서 사실 > 1인게 있으면 바로 리턴해줘도 될듯하다
    }

    public static boolean isBalanced(TreeNode node) {
        return getHeight(node) != Integer.MIN_VALUE;
    }
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(6);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n1.right = n5;

        long before = System.currentTimeMillis();

        System.out.println(isBalanced(n1));

        long after = System.currentTimeMillis();
        long time = after - before;
        System.out.println("Time Spent : " + time);

    }
}
