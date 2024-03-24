package Tree;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class SameTree {

    public static void main(String[] args) {
        Integer[] p = {3, 9, 20, null, null, 15, 7};
        Integer[] q = {3, 9, 20, null, null, 15, 7};
        TreeNode pTree = buildTreeFromArray(p);
        TreeNode qTree = buildTreeFromArray(q);

        printTree(pTree);
        System.out.println();
        printTree(qTree);
        boolean res = isSameTree(pTree, qTree);
        System.out.println("\nResult " + res);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
