/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 *
 * https://leetcode.cn/problems/maximum-subarray/description/
 *
 * algorithms
 * Medium (55.11%)
 * Likes:    6537
 * Dislikes: 0
 * Total Accepted:    1.6M
 * Total Submissions: 2.9M
 * Testcase Example:  '[-2,1,-3,4,-1,2,1,-5,4]'
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 
 * 子数组 是数组中的一个连续部分。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：nums = [1]
 * 输出：1
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 
 * 
 * 
 * 
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * 
 */

// @lc code=start
/*
 * dp
 * 时间 O(n)
 * 空间 O(n)
 * 
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int res=Integer.MIN_VALUE;
        int[] dp = new int [nums.length];
        dp[0]=nums[0];
        res=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            if(dp[i]>res) res=dp[i];
        }
        return res;


    }
}
*/

/*
 * dp 空间优化
 * 时间 O(n)
 * 空间 O(1)
 * 
class Solution {
    public int maxSubArray(int[] nums) {
        int pre=0,maxAns=nums[0];
        for(int x:nums){
            pre=Math.max(pre+x,pre);
            maxAns=Math.max(maxAns,pre);
        }
        return maxAns;
    }
}
 */

/*
 * 贪心
 * 时间 O(n)
 * 空间 O(1)
 */ 
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int res=Integer.MIN_VALUE;
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=nums[i];
            res=Math.max(res,count);
            if(count<0){
                count=0;
            }
        }
        
    }
}



// @lc code=end

