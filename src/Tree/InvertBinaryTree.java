package Tree;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class InvertBinaryTree {

    public static void main(String[] args) {
        Integer[] p = {4,2,7,1,3,6,9};
        TreeNode pTree = buildTreeFromArray(p);
        printTree(pTree);
        System.out.println();
        TreeNode res = invertTree(pTree);
        printTree(res);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
