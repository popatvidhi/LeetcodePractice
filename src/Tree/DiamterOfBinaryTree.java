package Tree;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class DiamterOfBinaryTree {

    public static void main(String[] args) {
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTreeFromArray(input);

        printTree(root);
        int res = diameterOfBinaryTree(root);
        System.out.println("\n Result " + res);
    }

    public static int res = 0;
    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root){
        if(root == null)
            return -1;
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, 2+left+right);

        return 1+Math.max(left,right);
    }
}
