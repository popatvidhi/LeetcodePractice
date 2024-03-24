package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        Integer[] p = {3,9,20,null,null,15,7};
        TreeNode pTree = buildTreeFromArray(p);
        printTree(pTree);
        System.out.println();
        List<List<Integer>> res = levelOrder(pTree);
        for (List<Integer> l1 : res) {
            for (Integer n : l1) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return null;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            List<Integer> local = new ArrayList<>();
            int size = qu.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = qu.poll();
                local.add(tmp.val);
                if(tmp.left != null){
                    qu.offer(tmp.left);
                }
                if(tmp.right != null){
                    qu.offer(tmp.right);
                }
            }
            res.add(local);
        }
        return res;
    }
}
