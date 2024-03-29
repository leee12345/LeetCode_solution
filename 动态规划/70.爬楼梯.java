/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode.cn/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (54.31%)
 * Likes:    3431
 * Dislikes: 0
 * Total Accepted:    1.4M
 * Total Submissions: 2.5M
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= n <= 45
 * 
 * 
 */

// @lc code=start
/**
 * 时间 O(N)
 * 空间 O(1)
 * 
class Solution {
    public int climbStairs(int n) {
        int f1=1;
        int f2=2;
        int s=0;
        if(n==1) return f1;
        if(n==2) return f2;
        for(int i=3;i<=n;i++){
            s=f1+f2;
            f1=f2;
            f2=s;
        }
        return s;

    }
}
 */

/**
 * 时间 O(N)
 * 空间 O(1)
 */

class Solution {
    public int climbStairs(int n) {
      if(n<=1) return n;
      int[] dp = new int[n+1];
      dp[1]=1;
      dp[2]=2;
      for(int i=3;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
      }
      return dp[n];
    }
}
// @lc code=end

