package Tree;

import java.util.*;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class ZigZagLevelOrder {

    public static void main(String[] args) {
        Integer[] p = {3,9,20,null,null,15,7};
        TreeNode pTree = buildTreeFromArray(p);
        printTree(pTree);
        System.out.println();
        List<List<Integer>> res = zigzagLevelOrder(pTree);
        for (List<Integer> l1 : res) {
            for (Integer n : l1) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        boolean direction = false;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            List<Integer> local = new ArrayList<>();
            int size = qu.size();
            for(int i = 0; i < size; i++){
                TreeNode node = qu.poll();
                local.add(node.val);
                if(node.left != null)
                    qu.offer(node.left);
                if(node.right != null)
                    qu.offer(node.right);
                if(direction && i == size - 1){
                    Collections.reverse(local);
                }
            }
            res.add(local);
            direction = !direction;
        }
        return res;

    }

}
