/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Easy (76.34%)
 * Likes:    1997
 * Dislikes: 0
 * Total Accepted:    1.3M
 * Total Submissions: 1.7M
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
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
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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
 递归 
 时间复杂度 O(n) n是二叉树节点个数 二叉树每个节点都会被访问一次
 空间复杂度 O(n) 空间复杂度取决于递归的栈深度

class Solution {
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res= new ArrayList<Integer>();
        inorder(root,res);
        return res;
    }
    public void inorder(TreeNode root,List<Integer> res){
        if(root==null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
*/



/**
 迭代
时间复杂度 O(n) n是二叉树节点个数 二叉树每个节点都会被访问一次
 空间复杂度 O(n) 空间复杂度取决于递归的栈深度
*/
class Solution{
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res= new ArrayList<Integer>();
        Deque<TreeNode> stack= new LinkedList<TreeNode>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            res.add(root.val);
            root=root.right;
        }
        return res;
    }
}

// @lc code=end

