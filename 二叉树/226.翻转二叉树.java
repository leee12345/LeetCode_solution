/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 *
 * https://leetcode.cn/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (79.86%)
 * Likes:    1758
 * Dislikes: 0
 * Total Accepted:    789.7K
 * Total Submissions: 988.1K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目范围在 [0, 100] 内
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
 * 递归法
 * 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }
    private void swap(TreeNode root){
        TreeNode tmp = root.left;
        root.left=root.right;
        root.right=tmp;
    }

}
*/

//BFS
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){ return null;}
        ArrayDeque<TreeNode> deque= new ArrayDeque<>();
        deque.offer(root);
        while(!deque.isEmpty()){
            int size=deque.size();
            while(size-- >0){
                TreeNode node= deque.poll();
                swap(node);
                if(node.left!=null) deque.offer(node.left);
                if(node.right!=null) deque.offer(node.right);
            }
        }
        return root;
    }
    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
    }

}
// @lc code=end

