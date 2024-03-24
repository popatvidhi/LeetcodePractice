package Tree;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class LowestCommentAcenstorinBST {

    public static void main(String[] args){
        Integer[] input = {6,2,8,0,4,7,9,null,null,3,5};
        Integer[] inputp = {2};
        Integer[] inputq = {8};
        TreeNode root = buildTreeFromArray(input);
        TreeNode p = buildTreeFromArray(inputp);
        TreeNode q = buildTreeFromArray(inputq);

//        printTree(root);
//        printTree(p);
//        printTree(q);

        TreeNode res = lowestCommonAncestor(root, p, q);
        printTree(res);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null){
            if(p.val > curr.val && q.val > curr.val)
                curr = curr.right;
            else if(p.val < curr.val && q.val < curr.val)
                curr = curr.left;
            else
                return curr;
        }
        return null;
    }
}
