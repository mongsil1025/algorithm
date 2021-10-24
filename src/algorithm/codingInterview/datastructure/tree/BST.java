package algorithm.codingInterview.datastructure.tree;

public class BST {
    public static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean checkBst(TreeNode node) {
        if(node == null) return true;
        
        if(node.left == null || node.right == null) return true;
        if(node.data < node.left.data || node.data > node.right.data) {
            return false;
        } else {
            return checkBst(node.left) && checkBst(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(20);
        TreeNode n2 = new TreeNode(10);
        TreeNode n3 = new TreeNode(25);
        TreeNode n4 = new TreeNode(30);

        n1.left = n2;
        n2.right = n3;
        n1.right = n4;

        System.out.println(checkBst(n1));
    }
}
