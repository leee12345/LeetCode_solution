/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 *
 * https://leetcode.cn/problems/perfect-squares/description/
 *
 * algorithms
 * Medium (66.40%)
 * Likes:    1904
 * Dislikes: 0
 * Total Accepted:    472.4K
 * Total Submissions: 710.4K
 * Testcase Example:  '12'
 *
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11
 * 不是。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 12
 * 输出：3 
 * 解释：12 = 4 + 4 + 4
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 10^4
 * 
 * 
 */

// @lc code=start
/***
 * dp
 * 时间 O(nsqrt(n))
 * 空间 O(n)
 */
class Solution {
    public int numSquares(int n) {
        int [] f= new int [n+1];
        for(int i=1;i<=n;i++){
            f[i]=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                f[i]=Math.min(f[i],f[i-j*j]+1);
            }
        }
        return f[n];
    }
}

// @lc code=end

