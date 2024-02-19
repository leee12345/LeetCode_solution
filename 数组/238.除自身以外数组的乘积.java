/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 *
 * https://leetcode.cn/problems/product-of-array-except-self/description/
 *
 * algorithms
 * Medium (74.99%)
 * Likes:    1707
 * Dislikes: 0
 * Total Accepted:    374.1K
 * Total Submissions: 497.8K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 2 <= nums.length <= 10^5
 * -30 <= nums[i] <= 30
 * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
 * 
 * 
 * 
 * 
 * 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。）
 * 
 */

// @lc code=start
/**
 *  问题：输入的数组中可能有0 不能全部相乘再除的方式计算
 *  左右乘积列表：索引左侧所有数字的乘积和右侧所有数字的乘积
 *  时间 O(n)
 *  空间 O(n)
 * 
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] L= new int[n];
        int [] R = new int [n];
        
        int [] res= new int [n];
        L[0]=1;
        for(int i=1;i<n;i++){
            L[i]=nums[i-1]*L[i-1];
        }
        R[n-1]=1;
        for(int i=n-2;i>=0;i--){
            R[i]=nums[i+1]*R[i+1];
        }
        for(int i=0;i<n;i++){
            res[i]=L[i]*R[i];
        }
        return res;
    }
}
 */

/**
 *  问题：输入的数组中可能有0 不能全部相乘再除的方式计算
 *  左右乘积列表：索引左侧所有数字的乘积和右侧所有数字的乘积
 *  空间优化
 *  时间 O(n)
 *  空间 O(1)
 * 
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] res= new int [n];
        res[0]=1;
        for(int i=1;i<n;i++){
            res[i]=nums[i-1]*res[i-1];
        }
        int R=1;
        for(int i=n-1;i>=0;i--){
            res[i]=res[i]*R;
            R*=nums[i];
        }
        return res;
    }
}
// @lc code=end

