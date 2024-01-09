/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 *
 * https://leetcode.cn/problems/symmetric-tree/description/
 *
 * algorithms
 * Easy (59.45%)
 * Likes:    2623
 * Dislikes: 0
 * Total Accepted:    956.3K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,2,3,4,4,3]'
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * 
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
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
//后序遍历比较树 左右中 和 右左中
/***
* 递归法
*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left,root.left);
    }

    private boolean compare(TreeNode left,TreeNode right){
        if(left==null&&right!=null){
            return false;
        }
        if(left!=null&&right==null){
            return false;
        }
        if(left==null&&right==null){
            return true;
        }
        if(left.val!=right.val){
            return false;
        }
        boolean compareOutside=compare(left.left, right.right);
        boolean compareInside=compare(left.right, right.right);
        return compareOutside && compareInside;
    }
}
*/


/***
* 迭代法
* 使用双端队列 相当于两个栈
* 左右 和 右左
*
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while(!deque.isEmpty()){
            TreeNode leftNode = deque.pollFirst();
            TreeNode rightNode = deque.pollLast();
            if(leftNode==null&&rightNode==null){
                continue;
            }
            if(leftNode==null||rightNode==null||leftNode.val!=rightNode.val){
                return false;
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);

            deque.offerLast(rightNode.right);
            deque.offerLast(leftNode.left);
        }
        return true;
    }
}
*/


/***
 * 迭代法
 * 使用普通队列
 * 
 */

class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while(!deque.isEmpty()){
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if(leftNode==null&&rightNode==null){
                continue;
            }
            if(leftNode==null||rightNode==null||leftNode.val!=rightNode.val){
                return false;
            }
            //外层
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            //里层
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }
}
// @lc code=end

