package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Tree.TreeNode.buildTreeFromArray;
import static Tree.TreeNode.printTree;

public class MaximumWidthOfBinaryTree {

    public static void main(String[] args) {
        Integer[] p = {1,3,2,5,null,null,9,6,null,7};
        TreeNode pTree = buildTreeFromArray(p);
        printTree(pTree);
        System.out.println();
        int res = widthOfBinaryTree(pTree);
        System.out.print(res);
    }

    public static int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<Pair> qu = new LinkedList<>();
        qu.add(new Pair(root, 1));
        while(!qu.isEmpty()){
            int size = qu.size();
            int start = 0, end = 0;
            for(int i = 0; i < size; i++){
                Pair p = qu.poll();
                if(i == 0){
                    start = p.num;
                }
                if(i == size - 1){
                    end = p.num;
                }
                if(p.node.left != null){
                    qu.add(new Pair(p.node.left, 2 * p.num));
                }
                if(p.node.right != null){
                    qu.add(new Pair(p.node.right, 2 * p.num + 1));
                }
            }
            res = Math.max(res, end - start + 1);

        }
        return res;
    }
    static class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }
}
