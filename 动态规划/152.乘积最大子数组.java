/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子数组
 *
 * https://leetcode.cn/problems/maximum-product-subarray/description/
 *
 * algorithms
 * Medium (43.14%)
 * Likes:    2174
 * Dislikes: 0
 * Total Accepted:    403.5K
 * Total Submissions: 934.8K
 * Testcase Example:  '[2,3,-2,4]'
 *
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 * 
 * 测试用例的答案是一个 32-位 整数。
 * 
 * 子数组 是数组的连续子序列。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -10 <= nums[i] <= 10
 * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
 * 
 * 
 */

// @lc code=start
/***
 * dp
 * 分正负数情况讨论
 * fmin(i)=max_{i-1}^{n} {fmax(i-1)*ai,fmin(i-1)*ai,ai}
 * fmax(i)=min_{i-1}^{n} {fmax(i-1)*ai,fmin(i-1)*ai,ai}
 * 
class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxdp = new int[len];
        int[] mindp= new int[len];
        System.arraycopy(nums, 0, maxdp, 0, len);
        System.arraycopy(nums, 0, mindp, 0, len);
        for(int i=1;i<len;i++){
            maxdp[i]=Math.max(maxdp[i-1]*nums[i],Math.max(nums[i],mindp[i-1]*nums[i]));
            mindp[i]=Math.min(mindp[i-1]*nums[i],Math.min(nums[i],maxdp[i-1]*nums[i]));
        }
        int res=maxdp[0];
        for(int i=1;i<len;i++){
            res= Math.max(res,maxdp[i]);
        }
        return res;
    }
}
 */

/***
 * dp
 * 优化空间
 * 时间 O(n)
 * 空间 O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int maxdb=nums[0];
        int mindb=nums[0];
        int res=nums[0];
        int len=nums.length;
        for(int i=1;i<len;i++){
            int mx=maxdb;
            int mn=mindb;
            maxdb=Math.max(mx*nums[i],Math.max(nums[i],mn*nums[i]));
            mindb=Math.min(mn*nums[i],Math.min(nums[i],mx*nums[i]));
            res=Math.max(maxdb,res);
        }
        return res;
    }
        
}
// @lc code=end

