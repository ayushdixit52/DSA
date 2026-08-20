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
    public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    public boolean helper(TreeNode node,Integer l,Integer r){
        if(node==null) {
            return true;
        }
        if(l!=null && node.val<=l){
            return false;
        }
        if(r!=null && node.val>=r){
            return false;
        }
        boolean left=helper(node.left,l,node.val);
        boolean right=helper(node.right,node.val,r);
        return left && right;
    }
}