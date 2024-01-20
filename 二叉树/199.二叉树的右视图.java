/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
 *
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/
 *
 * algorithms
 * Medium (66.36%)
 * Likes:    1019
 * Dislikes: 0
 * Total Accepted:    355.4K
 * Total Submissions: 534.9K
 * Testcase Example:  '[1,2,3,null,5,null,4]'
 *
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 
 * 
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: []
 * 输出: []
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 二叉树的节点个数的范围是 [0,100]
 * -100  
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
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> rightmostValueAtDepth= new HashMap<Integer,Integer>();
        int max_depth=-1;

        Deque<TreeNode> nodeStack = new LinkedList<TreeNode>();
        Deque<Integer> depthStack= new LinkedList<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while(!nodeStack.isEmpty()){
            TreeNode node=nodeStack.pop();
            int depth = depthStack.pop();

            if(node!=null){
                //维护二叉树的最大深度
                max_depth=Math.max(max_depth,depth);
                //不存在对应深度的节点才插入
                if(!rightmostValueAtDepth.containsKey(depth)){//先出栈右子树的结点 先存右子树的结点
                    rightmostValueAtDepth.put(depth,node.val);
                }

                nodeStack.push(node.left);//先进后出 先出栈左子树的
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for(int depth=0;depth<=max_depth;depth++){
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;

    }
}
*/


/**
 * 广度优先搜索
 * 对每一层 从左向右访问 只保留每个深度最后访问的结点 
 * 就可以在遍历完整棵树后得到每个深度最右的结点 
 * 
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer>rightmostValueAtDepth = new HashMap<Integer,Integer>();
        int max_depth=-1;
        Queue<TreeNode> nodeQueue= new LinkedList<TreeNode>();
        Queue<Integer> depthQueue= new LinkedList<Integer>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while(!nodeQueue.isEmpty()){
            TreeNode node=nodeQueue.remove();//删除队列头元素
            int depth=depthQueue.remove();

            if(node!=null){
                max_depth=Math.max(max_depth,depth);

                rightmostValueAtDepth.put(depth,node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth+1);
                depthQueue.add(depth+1);
            }

        }

        List<Integer> rightView= new ArrayList<Integer>();
        for(int depth=0;depth<=max_depth;depth++){
            rightView.add(rightmostValueAtDepth.get(depth));
        }
        
        return rightView;
    }
}
// @lc code=end

