package Tree;

import java.util.Arrays;

import static Tree.TreeNode.printTree;

public class ConstructBinaryTreeFromInorderAndPreOrderTraversal {

    public static void main(String[] args){
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode res = buildTree(preorder, inorder);
        printTree(res);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int mid = -1;
        for ( int i = 0; i < inorder.length; i++){
            if(inorder[i] == preorder[0]){
                mid = i;
                break;
            }
        }

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return root;
    }
}
