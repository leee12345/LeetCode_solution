/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode.cn/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (37.42%)
 * Likes:    2249
 * Dislikes: 0
 * Total Accepted:    826.8K
 * Total Submissions: 2.2M
 * Testcase Example:  '[2,1,3]'
 *
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 
 * 有效 二叉搜索树定义如下：
 * 
 * 
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [2,1,3]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目范围在[1, 10^4] 内
 * -2^31 <= Node.val <= 2^31 - 1
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
//二叉搜索树:  
// 节点的左子树只包含小于当前节点的数
// 节点的右子树只包含大于当前节点的数
// 所有左子树和右子树自身必须也是二叉搜索树


/**
* 先序遍历
*
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return valid(root,null,null);
    }
    public boolean valid(TreeNode root,Integer low, Integer high){
        if(root==null) return true;
        if(low!=null&&root.val<=low)
            return false;
        if(high!=null&&root.val>=high)
            return false;
        return valid(root.left,low,root.val)&&valid(root.right,root.val,high);
    }

}
*/

import java.util.List;

/***
 * 中序遍历
 * 
 * 二叉搜索树 中序遍历后，得到的的序列一定是升序序列
 * 判断每个值是否大于前一个值
 * 
 */
class Solution {
    List<Integer> inOrderList= new ArrayList<Integer>();

    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
       inorder(root);
       for(int i=0;i<inOrderList.size();i++){
            if(i>0&&inOrderList.get(i)<=inOrderList.get(i-1)){
                return false;
            }
       }
       return true;
    }

    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        inOrderList.add(root.val);
        inorder(root.right);
    }

    
}

// @lc code=end

