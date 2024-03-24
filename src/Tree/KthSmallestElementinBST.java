package Tree;

import java.util.Stack;

public class KthSmallestElementinBST {

    public static void main(String[] args){
        Integer[] input = {5,3,6,2,4,null,null,1};
        TreeNode root = TreeNode.buildTreeFromArray(input);
        int res = kthSmallest(root, 3);
        System.out.println(res);
    }

    public static int kthSmallest(TreeNode root, int k) {
        int n = 0;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !st.empty()){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            n++;
            if(n == k)
                return curr.val;
            curr = curr.right;
        }
        return -1;
    }
}
