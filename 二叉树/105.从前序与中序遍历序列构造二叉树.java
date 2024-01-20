/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (71.16%)
 * Likes:    2179
 * Dislikes: 0
 * Total Accepted:    570.6K
 * Total Submissions: 801.6K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder
 * 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder 和 inorder 均 无重复 元素
 * inorder 均出现在 preorder
 * preorder 保证 为二叉树的前序遍历序列
 * inorder 保证 为二叉树的中序遍历序列
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
 * 递归
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 * 
class Solution {
    private Map<Integer,Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder,int[] inorder, int preorder_left,int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left>preorder_right){
            return null;
        }
        //前序遍历中第一个节点就是根节点
        int preorder_root= preorder_left;
        //中序遍历中定位根节点
        int inorder_root=indexMap.get(preorder[preorder_root]);

        TreeNode root = new TreeNode(preorder[preorder_root]);
        //左子树中节点数目
        int size_left_subtree=inorder_root-inorder_left;
        //递归构造左子树，并连接到根结点
        root.left=myBuildTree(preorder, inorder, preorder_left+1, preorder_left+size_left_subtree, inorder_left, inorder_root-1);
        //递归构造右子树，并连接到根结点
        root.right=myBuildTree(preorder, inorder, preorder_left+size_left_subtree+1, preorder_right, inorder_root+1, inorder_right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=preorder.length;
        indexMap= new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++){
            indexMap.put(inorder[i],i);
        }
        return myBuildTree(preorder, inorder, 0, n-1, 0, n-1);
        

    }
}
 */



/***
 * 迭代
 * 时间复杂度 O(n)
 * 空间复杂度 O(n)
 */
class Solution {
   

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||preorder.length==0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex=0;
        for(int i=1;i<preorder.length;i++){
            int preorderVal=preorder[i];
            TreeNode node =stack.peek();
            if(node.val!=inorder[inorderIndex]){
                node.left= new TreeNode(preorderVal);
                stack.push(node.left);
            }else{
                while(!stack.isEmpty()&&stack.peek().val==inorder[inorderIndex]){
                    node=stack.pop();
                    inorderIndex++;
                }
                node.right= new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;


        

    }
}

// @lc code=end

