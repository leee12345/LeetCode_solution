/*
 * @lc app=leetcode.cn id=104 lang=java
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (77.23%)
 * Likes:    1766
 * Dislikes: 0
 * Total Accepted:    1.2M
 * Total Submissions: 1.5M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树 root ，返回其最大深度。
 * 
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,null,2]
 * 输出：2
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点的数量在 [0, 10^4] 区间内。
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start
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


/***
 * 递归
 * 时间  O(N)
 * 空间  O(height)
 * 
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }else{
            int leftHeight=maxDepth(root.left);
            int rightHeight=maxDepth(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }

    }
}
*/


/***
 * 广度优先搜索
 * 时间  O(N)
 * 空间  O(height)
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode>queue = new LinkedList<TreeNode>();
        int depth=0;
        queue.offer(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            while(len>0){
                TreeNode node=queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                len--;
            }
            depth++;

        }
        return depth;

    }
}
// @lc code=end

