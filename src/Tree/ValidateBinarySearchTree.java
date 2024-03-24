package Tree;

public class ValidateBinarySearchTree {

    public static void main(String[] args){
        Integer[] input = {5,1,4,null,null,3,6};
        TreeNode root = TreeNode.buildTreeFromArray(input);
        boolean res = isValidBST(root);
        System.out.println(res);
    }
    public static boolean isValidBST(TreeNode root) {
        return valid(root, Float.MIN_VALUE, Float.MAX_VALUE);
    }
    public static boolean valid(TreeNode node, float left, float right){
        if(node == null)
            return true;
        if(!(node.val < right && node.val > left))
            return false;
        return (valid(node.left, left, node.val) && valid(node.right, node.val, right));
    }
}
