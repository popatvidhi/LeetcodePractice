package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class MaximumDepthofTree {
    public static void main(String[] args) {
        Integer[] input = {3, 9, 20, null, null, 15, 7};
        Integer[] inputBFS = {0,2,4,1,null,3,-1,5,1,null,6,null,8};
        TreeNode root = buildTreeFromArray(input);
        TreeNode rootBFS = buildTreeFromArray(inputBFS);

        System.out.print("Level-order traversal: ");
        printTree(root);
        int resRecursiveDFS = maxDepthRecursiveDFS(root);
        System.out.println("\n Recursive DFS " + resRecursiveDFS);
        int resIterativeDFS = maxDepthIterativeDFS(root);
        System.out.println(" Iterative DFS " + resIterativeDFS);
        int resIterativeBFS = maxDepthIterativeBFS(rootBFS);
        System.out.println(" Iterative BFS "+ resIterativeBFS);
    }

    public static int maxDepthRecursiveDFS(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepthRecursiveDFS(root.left), maxDepthRecursiveDFS(root.right));
    }

    public static int maxDepthIterativeDFS(TreeNode root) {
        if(root == null)
            return 0;
        int depth = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        stack.push(root);
        depthStack.push(1);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            int currentDepth = depthStack.pop();
            depth = Math.max(currentDepth, depth);
            if(node.right != null){
                stack.push(node.right);
                depthStack.push(currentDepth + 1);
            }
            if(node.left != null){
                stack.push(node.left);
                depthStack.push(currentDepth + 1);
            }
        }
        return depth;
    }

    public static int maxDepthIterativeBFS(TreeNode root) {
        if(root == null)
            return 0;

        int level = 0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            for(int i = 0; i < qu.size(); i++){
                TreeNode node = qu.poll();
                if(node.left != null)
                    qu.offer(node.left);
                if(node.right != null)
                    qu.offer(node.right);
            }
            level++;
        }
        return level;
    }
}
