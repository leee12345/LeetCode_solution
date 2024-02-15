/*
 * @lc app=leetcode.cn id=416 lang=java
 *
 * [416] 分割等和子集
 *
 * https://leetcode.cn/problems/partition-equal-subset-sum/description/
 *
 * algorithms
 * Medium (52.29%)
 * Likes:    1993
 * Dislikes: 0
 * Total Accepted:    494.6K
 * Total Submissions: 945K
 * Testcase Example:  '[1,5,11,5]'
 *
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 1 
 * 
 * 
 */

// @lc code=start
/**
 * dp
 * dp[i][j]表示从数组的[0,i]小标范围选取若干正整数，是否存在使选取正整数的和等于j
 * j>=nums[i] dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]]
 * j<nums[i]  dp[i][j]=dp[i-1][j]
 * 
class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        if(n<2) return false;
        int sum=0,maxNum=0;
        for(int num:nums){
            sum+=num;
            maxNum=Math.max(maxNum,num);
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        if(maxNum>target) return false;
        boolean[][] dp = new boolean[n][target+1];
        for(int i=0;i<n;i++){
            dp[i][0]=true;
        }
        dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            int num=nums[i];
            for(int j=1;j<=target;j++){
                if(j>=num){
                    dp[i][j]=dp[i-1][j] | dp[i-1][j-nums[i]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n-1][target];
    }
}
*/

/**
 * 优化空间
 * 
 */
class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        if(n<2) return false;
        int sum=0,maxNum=0;
        for(int num:nums){
            sum+=num;
            maxNum=Math.max(num,maxNum);
        }
        if(sum%2!=0) return false;
        int target=sum/2;
        if(maxNum>target) return false;
        boolean[]dp = new boolean[target+1];
        dp[0]=true;
        for(int i=0;i<n;i++){
            int num=nums[i];
            for(int j=target;j>=num;j--){
                dp[j]=dp[j]|dp[j-num];
            }
        }
        return dp[target];
    }
}
// @lc code=end

