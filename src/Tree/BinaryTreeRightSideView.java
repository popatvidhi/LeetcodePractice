package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class BinaryTreeRightSideView {

    public static void main(String[] args){
        Integer[] p = {1,2,3,null,5,null,4};
        TreeNode pTree = buildTreeFromArray(p);
        //printTree(pTree);
        System.out.println();
        List<Integer> res = rightSideView(pTree);
        for (Integer l1 : res) {
            System.out.print(l1 + " ");
        }
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int size = qu.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = qu.poll();
                if(temp.left != null){
                    qu.offer(temp.left);
                }
                if(temp.right != null){
                    qu.offer(temp.right);
                }
                if(i == size -1){
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}
