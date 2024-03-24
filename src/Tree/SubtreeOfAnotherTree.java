package Tree;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Integer[] input1 = {3,4,5,1,2};
        Integer[] input2 = {4,1,2};
        TreeNode root = buildTreeFromArray(input1);
        TreeNode subRoot = buildTreeFromArray(input2);

        printTree(root);
        printTree(subRoot);
        boolean res = isSubtree(root, subRoot);
        System.out.println(res);
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null)
            return true;
        if(root == null && subRoot != null)
            return false;
        if(isSameTree(root, subRoot))
            return true;
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));

    }
    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null){
            return true;
        }
        if(s != null && t != null && s.val == t.val){
            return (isSameTree(s.left, t.left) && isSameTree(s.right, t.right));

        }
        return false;
    }
}
