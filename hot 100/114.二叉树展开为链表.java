/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 *
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (73.26%)
 * Likes:    1610
 * Dislikes: 0
 * Total Accepted:    416.4K
 * Total Submissions: 567.8K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 
 * 
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
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
 * 输入：root = [0]
 * 输出：[0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中结点数在范围 [0, 2000] 内
 * -100 
 * 
 * 
 * 
 * 
 * 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
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
 * 先序遍历+递归
 * 时间 O(n)
 * 空间 O(n)
 * 
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorder(root,list);
        int size=list.size();
        for(int i=1;i<size;i++){
            TreeNode prev=list.get(i-1);
            TreeNode cur=list.get(i);
            prev.left=null;
            prev.right=cur;
        }
    }
    public void preorder(TreeNode root,List<TreeNode> list){
        if(root!=null){
            list.add(root);
            preorder(root.left, list);
            preorder(root.right,list);
        }
    }
}

*/


/**
 * 先序遍历+迭代
 * 时间 O(n)
 * 空间 O(n)
 * 
class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> list =new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                list.add(root);
                root=root.left;
            }
            root=stack.pop();
            root=root.right;
        }
        for(int i=1;i<list.size();i++){
            TreeNode pre=list.get(i-1);
            TreeNode cur=list.get(i);
            pre.left=null;
            pre.right=cur;
        }
    }

}
 */

/**
 * 寻找前驱节点
 * 时间 O(n)
 * 空间 O(n)
 */

class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur= root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode next= cur.left;
                TreeNode pre=next;
                while(pre.right!=null){
                    pre=pre.right;
                }
                pre.right=cur.right;
                cur.left=null;
                cur.right=next;
            }
            cur=cur.right;
        }

    }

}
// @lc code=end

