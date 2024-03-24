package Tree;

import java.util.List;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        Integer[] p = {3,9,20,null,null,15,7};
        TreeNode pTree = buildTreeFromArray(p);
        printTree(pTree);
        System.out.println();
        boolean res = isBalanced(pTree);
        System.out.println("\nResult " + res);
    }

    public static boolean isBalanced(TreeNode root) {
        return dfs(root) == -1 ? false : true;
    }
    public static int dfs(TreeNode root){
        if(root == null)
            return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }
}
