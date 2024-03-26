package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class AverageLevelsInBinaryTree {

    public static void main(String[] args){
        Integer[] p = {3,9,20,null,null,15,7};
        TreeNode pTree = buildTreeFromArray(p);
        printTree(pTree);
        System.out.println();
        List<Double> res = averageOfLevels(pTree);
        for (Double l1 : res) {
            System.out.print(l1 + " ");
        }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if(root == null){
            return null;
        }
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            double local = 0f;
            for(int i = 0; i < size; i++){
                TreeNode temp = qu.poll();
                local = local + Double.valueOf(temp.val);
                if(temp.left != null){
                    qu.offer(temp.left);
                }
                if(temp.right != null){
                    qu.offer(temp.right);
                }
            }
            res.add(local/size);
        }
        return res;
    }
}
