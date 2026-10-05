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
    int preIndex=0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {        
          return build(preorder, postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] preorder, int[] postorder, int left, int right) {
        if (preIndex >= preorder.length || left > right) return null;

        TreeNode root = new TreeNode(preorder[preIndex++]);

        if (left == right) return root;

        int index = left;

        while (postorder[index] != preorder[preIndex]) {
            index++;
        }

        root.left = build(preorder, postorder, left, index);
        root.right = build(preorder, postorder, index + 1, right - 1);

        return root;
    }
}