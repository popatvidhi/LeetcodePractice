package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
     this.val = val;
     this.left = left;
     this.right = right;
    }

  public static void printTree(TreeNode root) {
   if (root == null) {
    return;
   }

   Queue<TreeNode> queue = new LinkedList<>();
   queue.add(root);

   while (!queue.isEmpty()) {
   TreeNode current = queue.poll();
   System.out.print(current.val + " ");

    if (current.left != null) {
     queue.add(current.left);
    }

    if (current.right != null) {
     queue.add(current.right);
    }
   }
 }

  public static TreeNode buildTreeFromArray(Integer[] arr) {
   if (arr == null || arr.length == 0) {
    return null;
   }

   Queue<TreeNode> queue = new LinkedList<>();
   TreeNode root = new TreeNode(arr[0]);
   queue.add(root);

   int index = 1;

   while (!queue.isEmpty() && index < arr.length) {
    TreeNode current = queue.poll();

    Integer leftVal = arr[index++];
    if (leftVal != null) {
     current.left = new TreeNode(leftVal);
     queue.add(current.left);
    }

    if (index < arr.length) {
     Integer rightVal = arr[index++];
     if (rightVal != null) {
      current.right = new TreeNode(rightVal);
      queue.add(current.right);
     }
    }
   }
   return root;
  }
}

