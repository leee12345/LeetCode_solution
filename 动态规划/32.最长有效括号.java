/*
 * @lc app=leetcode.cn id=32 lang=java
 *
 * [32] 最长有效括号
 *
 * https://leetcode.cn/problems/longest-valid-parentheses/description/
 *
 * algorithms
 * Hard (37.53%)
 * Likes:    2445
 * Dislikes: 0
 * Total Accepted:    421.8K
 * Total Submissions: 1.1M
 * Testcase Example:  '"(()"'
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = ""
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * s[i] 为 '(' 或 ')'
 * 
 * 
 * 
 * 
 */

// @lc code=start
/**
 * dp
 * 时间 O(n)
 * 空间 O(n)
class Solution {
    public int longestValidParentheses(String s) {
        int maxans=0;
        int[] dp= new int[s.length()];
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    if(i>=2){
                        dp[i]=dp[i-2]+2;
                    }else{
                        dp[i]=2;
                    }
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='('){
                    if(i-dp[i-1]>=2){
                        dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2;
                    }else{
                        dp[i]=dp[i-1]+2;
                    }
                }
                maxans=Math.max(maxans,dp[i]);
            }
        }
        return maxans;
    }
}
*/

import java.util.Deque;

/**
 * 栈
 * 时间 O(n)
 * 空间 O(n)
 */
class Solution {
    public int longestValidParentheses(String s) {
        int maxans=0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxans=Math.max(maxans,i-stack.peek());
                }
            }
        }
        return maxans;
    }
}
// @lc code=end

