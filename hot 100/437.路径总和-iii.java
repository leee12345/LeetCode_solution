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
 * dfs
 * 时间 O(N2)
 * 空间 O(N)
 * 
class Solution {
    public int pathSum(TreeNode root, long targetSum) {
        if(root==null){
            return 0;
        }
        long ts =(long) targetSum;
        int ret=rootSum(root,ts);
        ret+=pathSum(root.left, ts);
        ret+=pathSum(root.right, ts);
        return ret;
    }
    public int rootSum(TreeNode root,long targetSum){
        int ret=0;
        if(root==null){
            return 0;
        }
        long val=(long) root.val;
        if(val==targetSum){
            ret++;
        }
        ret+=rootSum(root.left, targetSum-val);
        ret+=rootSum(root.right,targetSum-val);
        return ret;
    }
}
 */
/***
 * 前缀和(回溯)
 * 时间 O(n)
 * 空间 O(n)
 */
//抵达当前节点(即B节点)后，将前缀和累加，然后查找在前缀和上，有没有前缀和currSum-target的节点(即A节点)，存在即表示从A到B有一条路径之和满足条件的情况。结果加上满足前缀和currSum-target的节点的数量。然后递归进入左右子树。
//左右子树遍历完成之后，回到当前层，需要把当前节点添加的前缀和去除。避

class Solution {
    public int pathSum(TreeNode root, long targetSum) {
        Map<Long,Integer> preSum= new HashMap<>();
        //前缀和为0的路径
        preSum.put(0L,1);
        return recursionPathSum(root,preSum,targetSum,0L);
    }
    public int recursionPathSum(TreeBide node,Map<Lonhg,Integer>preSum,int target,long currSum )
    {
        if(node==null){
            return 0;
        }
        int res=0;
        currSum+=node.val;
        res+=preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += recursionPathSum(node.left, preSum, target, currSum);
        res += recursionPathSum(node.right, preSum, target, currSum);

        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;


    }
    
}
// @lc code=end

