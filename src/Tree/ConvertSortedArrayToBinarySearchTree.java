package Tree;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        int[] p = {-10,-3,0,5,9};
        TreeNode res = sortedArrayToBST(p);
        printTree(res);
    }

    private static TreeNode createTree(int nums[], int l, int r){
        if(l > r)
            return null;
        int mid = (l+r)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums,l,mid-1);
        root.right = createTree(nums, mid+1, r);
        return root;
    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length-1);
    }
}
