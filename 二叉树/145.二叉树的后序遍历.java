/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (76.33%)
 * Likes:    1135
 * Dislikes: 0
 * Total Accepted:    710.2K
 * Total Submissions: 930.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
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
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
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
 *  递归

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<Integer>();
        postorder(res,root);
        return res;
    }
    public void postorder(List<Integer>res,TreeNode root){
        if(root==null) return;
        postorder(res, root.left);
        postorder(res, root.right);
        res.add(root.val);
    }

}
*/



/**
 * 迭代
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack= new LinkedList<TreeNode>();
        TreeNode prev=null;
        while(root!=null||!stack.isEmpty()){
             // 将当前节点及其左子树入栈
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            // 出栈
            root=stack.pop();
            // 如果右子树为空或者已经访问过右子树，将当前节点加入结果集
            if(root.right==null||root.right==prev){
                res.add(root.val);
                prev=root;
                root=null;// 将root置为null，以便下次出栈
            }else{
                //如果右子树存在且未被访问，将当前节点重新入栈，然后转向右子树
                stack.push(root);
                root=root.right;
            }
        }
        return res;

    }

}

// @lc code=end

