/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (71.41%)
 * Likes:    1201
 * Dislikes: 0
 * Total Accepted:    981.8K
 * Total Submissions: 1.4M
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：root = [1]
 * 输出：[1]
 * 
 * 
 * 示例 4：
 * 
 * 
 * 输入：root = [1,2]
 * 输出：[1,2]
 * 
 * 
 * 示例 5：
 * 
 * 
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 100] 内
 * -100 
 * 
 * 
 * 
 * 
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
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
 * 递归方法
 * 时间 O(n)
 * 空间 O(n)

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        preorder(root,res);
        return res;
    }
    public void preorder(TreeNode root,List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

}
 */


/**
 * 迭代方法
 * 时间 O(n)
 * 空间 O(n)
 */
 //前序遍历顺序：中 左 右 入栈顺序 中 右 左
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer>res= new ArrayList<Integer>();
         Deque<TreeNode> stack = new LinkedList<TreeNode>();
         if(root==null) return res;
         stack.push(root);
         while(!stack.isEmpty()){
            TreeNode node= stack.pop();
            res.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
         }
         return res;

    }


}

// @lc code=end

