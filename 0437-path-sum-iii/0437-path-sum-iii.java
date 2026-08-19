/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return sum(root,sum)+pathSum(root.left,sum)+pathSum(root.right,sum);
    }
    private int sum(TreeNode node,long sum){
        if(node==null) return 0;
        return (node.val==sum?1:0)+sum(node.left,sum-node.val)+sum(node.right,sum-node.val);
    }
}