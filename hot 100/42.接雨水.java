/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 *
 * https://leetcode.cn/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (63.18%)
 * Likes:    4937
 * Dislikes: 0
 * Total Accepted:    832.2K
 * Total Submissions: 1.3M
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == height.length
 * 1 <= n <= 2 * 10^4
 * 0 <= height[i] <= 10^5
 * 
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
       int len=height.length;
       if(len <=2) return 0;
       int[] maxLH= new int[len];
       int[] maxRH=new int [len];
       //柱子左边的最大高度
       maxLH[0]=height[0];
       //柱子右边的最大高度
       maxRH[len-1]=height[len-1];
       for(int i=1;i<len;i++) maxLH[i]=Math.max(maxLH[i-1],height[i]);
       for(int i=len-2;i>=0;i--) maxRH[i]=Math.max(maxRH[i+1],height[i]);
       int sum=0;
       for(int i=1;i<len-1;i++){//第一个和最后一个不接水
            int h=Math.min(maxLH[i],maxRH[i])-height[i];
            sum+=h;
       }
       return sum;

    }
}
// @lc code=end

