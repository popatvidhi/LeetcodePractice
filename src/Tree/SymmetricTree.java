package Tree;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class SymmetricTree {
    public static void main(String[] args) {
        Integer[] p = {1,2,2,3,4,4,3};
        TreeNode pTree = buildTreeFromArray(p);

        printTree(pTree);
        System.out.println();
        boolean res = isSymmetric(pTree);
        System.out.println("\nResult " + res);
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricHelp(root.left, root.right) || root == null;
    }
    public static boolean isSymmetricHelp(TreeNode lTree, TreeNode rTree){
        if(lTree == null || rTree==null)
            return lTree == rTree;
        if(lTree.val != rTree.val)
            return false;
        return isSymmetricHelp(lTree.left, rTree.right) && isSymmetricHelp(lTree.right, rTree.left);
    }
}
