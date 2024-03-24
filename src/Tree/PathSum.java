package Tree;

import static Tree.TreeNode.buildTreeFromArray;

public class PathSum {

    public static void main(String args[]){
        Integer[] p = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode pTree = buildTreeFromArray(p);
        int target = 22;
        System.out.println(hasPathSum(pTree, target));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }
    private static boolean dfs(TreeNode root, int targetSum, int currSum){
        if(root == null){
            return false;
        }
        currSum += root.val;
        if(root.left == null && root.right == null){
            return currSum == targetSum;
        }
        return dfs(root.left, targetSum, currSum) || dfs(root.right, targetSum, currSum);
    }
}
