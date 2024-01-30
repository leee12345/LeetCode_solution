/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (66.36%)
 * Likes:    1019
 * Dislikes: 0
 * Total Accepted:    355.4K
 * Total Submissions: 534.9K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: []
 * 输出: []
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [0,100]
 * -100  
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



/**
 * dfs
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 * 先访问右子树，存储每个深度访问的第一个结点
 * 
class Solution {
    int maxHight=0;
    List<Integer> res= new ArrayList<Integer>();

    public List<Integer> rightSideView(TreeNode root) {
       dfs(root,1);
       return res;
    }
    public void dfs(TreeNode root, int high){
        if(root==null) return;
        if(maxHight<high){
            res.add(root.val);
            maxHight=high;
        }
        dfs(root.right,high+1);//先访问右子树
        dfs(root.left,high+1);

    }
}
 */



/***
 * bfs
 * 层次遍历
 * 时间 O(n)
 * 空间 O(n)
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node= queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(i==size-1){//当前层的最后一个 也就是最右节点
                    res.add(node.val);
                }
            }
        }
        return res;
    
    }
   
}
// @lc code=end

