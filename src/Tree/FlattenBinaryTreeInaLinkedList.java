package Tree;

import LinkedList.ListNode;

import java.util.List;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class FlattenBinaryTreeInaLinkedList {

    public static void main(String args[]){
        Integer[] p = {1,2,5,3,4,null,6};
        TreeNode pTree = buildTreeFromArray(p);
        printTree(pTree);
        System.out.println();
        flatten(pTree);
        printTree(pTree);
    }

    public static void flatten(TreeNode root) {
        dfs(root);
    }
    public static TreeNode dfs(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode leftTail = dfs(root.left);
        TreeNode rightTail = dfs(root.right);

        if(leftTail != null){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        TreeNode last = new TreeNode();
        if(rightTail != null){
            last = rightTail;
        }else if(leftTail != null){
            last = leftTail;
        }else{
            last = root;
        }
        return last;
    }
}
