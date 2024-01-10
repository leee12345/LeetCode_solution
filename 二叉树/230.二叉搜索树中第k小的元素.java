/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 *
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/
 *
 * algorithms
 * Medium (76.51%)
 * Likes:    808
 * Dislikes: 0
 * Total Accepted:    314K
 * Total Submissions: 410K
 * Testcase Example:  '[3,1,4,null,2]\n1'
 *
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 * 
 * 
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 树中的节点数为 n 。
 * 1 
 * 0 
 * 
 * 
 * 
 * 
 * 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？
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
 * 中序遍历： 二叉搜索树中序遍历后得到递增的数组，第k个就是第k小的元素
 * 时间复杂度 O(H+k) H是树的高度  树是平衡树时为logN 是线性树时为N
 * 空间复杂度 O(H)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
       Deque<TreeNode> stack= new LinkedList<TreeNode>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            k--;
            if(k==0){
                break;
            }
            root=root.right;
        }
        return root.val;
    }
}
 */

 /**
  * 记录子树的结点数
  * node的左子树的结点数left小于k-1 则第k小的元素一定在node的右子树 令node等于其右子结点，k等于k-left-1并继续搜索
  * node的左子树的结点数left等于k-1 则第k小的元素为node
  * node的左子树的结点数left大于k-1 则第k小的元素一定在node的右左子树 令node等于其左子结点，继续搜索
  * 时间复杂度 O(H) 
  * H 最大是logN 最小是N
  *
  */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
       MyBst bst = new MyBst(root);
       return bst.kthSmallest(k);
    }
}
class MyBst{
    TreeNode root;
    Map <TreeNode,Integer> nodeNum;

    public MyBst(TreeNode root){
        this.root=root;
        this.nodeNum= new HashMap<TreeNode,Integer>();
        countNodeNum(root);
    }

    //返回二叉搜索树中的第k小的元素
    public int kthSmallest(int k){
        TreeNode node=root;
        while(node!=null){
            int left=getNodeNum(node.left);
            if(left<k-1){
                node=node.right;
                k=k-left-1;
            }else if(left==k-1){
                break;
            }else{
                node=node.left;
            }
        }
        return node.val;
    }

    //统计以node为根结点的子树的结点数
    private int countNodeNum(TreeNode node){
        if(node==null){
            return 0;
        }
        nodeNum.put(node,1+countNodeNum(node.left)+countNodeNum(node.right));
        return nodeNum.get(node);
    }

    //获取以node为根结点的子树的结点数
    private int getNodeNum(TreeNode node){
        return nodeNum.getOrDefault(node,0);
    }

}

// @lc code=end

