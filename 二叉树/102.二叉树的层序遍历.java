/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
 *
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (66.26%)
 * Likes:    1864
 * Dislikes: 0
 * Total Accepted:    936.8K
 * Total Submissions: 1.4M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1]
 * 输出：[[1]]
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
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
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
 * 广度优先搜索
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> level=new ArrayList<Integer>();
            int currentLevelSize=queue.size();
            for(int i=1;i<=currentLevelSize;i++){
                TreeNode node= queue.poll();
                level.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;

    }
}
*/

/***
 * 递归方法
 **/

class Solution {
    public List<List<Integer>> resList= new ArrayList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun01(root, 0);
        return resList;
    }
    public void checkFun01(TreeNode node,Integer deep){
        if(node==null) return;
        deep++;
        if(resList.size()<deep){
            List<Integer> item= new ArrayList<Integer>();
            resList.add(item);
        }
        resList.get(deep-1).add(node.val);
        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }
}

// @lc code=end

