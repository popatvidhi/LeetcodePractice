package Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {

    public static void main(String[] args){
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode res = buildTree(postorder, inorder);
        TreeNode res1 = buildTreeMapSol(inorder, postorder);
        printTree(res);
        printTree(res1);
    }
    //O(n^2) time
    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        if(postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0){
            return null;
        }
        return buildTreeHelper(inorder, postorder);
    }
    private static TreeNode buildTreeHelper(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int idx = indexOf(inorder, root.val);

        root.right = buildTreeHelper(Arrays.copyOfRange(inorder, idx + 1, inorder.length),
                Arrays.copyOfRange(postorder, idx, postorder.length - 1));
        root.left = buildTreeHelper(Arrays.copyOfRange(inorder, 0, idx),
                Arrays.copyOfRange(postorder, 0, idx));

        return root;
    }

    private static int indexOf(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1; // Element not found
    }
    //O(n) time
    public static TreeNode buildTreeMapSol(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(0, inorder.length - 1, postorder.length - 1, postorder, inorder, map);
    }

    private static TreeNode buildTree(int l, int r, int index, int[] postorder, int[] inorder, Map<Integer, Integer> map) {
        if (l > r) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int inIndex = map.get(root.val);
        root.right = buildTree(inIndex + 1, r, index - 1, postorder, inorder, map);
        root.left = buildTree(l, inIndex - 1, index - (r - inIndex) - 1, postorder, inorder, map);
        return root;
    }
}
