/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 *
 * https://leetcode.cn/problems/path-sum-iii/description/
 *
 * algorithms
 * Medium (48.91%)
 * Likes:    1786
 * Dislikes: 0
 * Total Accepted:    267.3K
 * Total Submissions: 548.4K
 * Testcase Example:  '[10,5,-3,3,2,null,11,3,-2,null,1]\n8'
 *
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [0,1000]
 * -10^9  
 * -1000  
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
 * 深度优先搜索
 * 时间复杂度O(N2)
 * 空间复杂度O(N)
 * 
 * 
 class Solution {
    public int pathSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        long ts=(long) targetSum;

        int ret = rootSum(root, ts);
        ret += pathSum(root.left, ts);
        ret += pathSum(root.right, ts);
        return ret;
    }

    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        long val = (long) root.val;
        if (val == targetSum) {
            ret++;
        } 
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}
*/
import java.util.*;
/***
 * 前缀和
 * 时间复杂度O(N)
 * 空间复杂度O(N)
 *  其N坠和为从根结点到当前节点的路径上的所有结点的和
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> prefix = new HashMap<Long,Integer>();
        prefix.put(0L,1);
        return dfs(root,prefix,0,targetSum);
    }

    public int dfs(TreeNode root,Map<Long,Integer> prefix,long curr, int targetSum){
        if(root==null){
            return 0;
        }
        int ret=0;
        curr+=root.val;

        ret=prefix.getOrDefault(curr-targetSum,0);
        prefix.put(curr,prefix.getOrDefault(curr, 0)+1);
        ret+=dfs(root.left,prefix,curr,targetSum);
        ret+=dfs(root.right,prefix,curr,targetSum);
        prefix.put(curr,prefix.getOrDefault(curr, 0)-1);
        return ret;

    }

}

// @lc code=end

