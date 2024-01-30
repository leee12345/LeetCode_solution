/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 *
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (76.51%)
 * Likes:    808
 * Dislikes: 0
 * Total Accepted:    314K
 * Total Submissions: 410K
 * Testcase Example:  '[3,1,4,null,2]\n1'
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数为 n 。
 * 1 
 * 0 
 * 
 * 
 * 
 * 
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
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
 * 中序遍历 二叉搜索树中序遍历后得到递增的数组，第k个就是第k小的元素
 * 时间 O(H+k)
 * 空间 O(H)
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null||!stack.isEmpty()){   
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            k--;
            if(k==0){
                break;
            }
            root=root.right;
        }
        return root.val;
    }
}
// @lc code=end

