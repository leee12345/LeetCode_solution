/*
 * @lc app=leetcode.cn id=59 lang=java
 *
 * [59] 螺旋矩阵 II
 *
 * https://leetcode.cn/problems/spiral-matrix-ii/description/
 *
 * algorithms
 * Medium (71.61%)
 * Likes:    1253
 * Dislikes: 0
 * Total Accepted:    389.6K
 * Total Submissions: 545.2K
 * Testcase Example:  '3'
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：n = 1
 * 输出：[[1]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int loop=0;//控制循环次数
        int[][] res=new int [n][n];
        int start=0;//每次循环的开始点
        int count=1;//填充数字
        int i,j;
        while(loop++<n/2){
            //上左 到 上右
            for(j=start;j<n-loop;j++){
                res[start][j]=count++;
            }
            //右上 到 右下
            for(i=start;i<n-loop;i++){
                res[i][j]=count++;
            }
            //下右 到 下左
            for(;j>=loop;j--){
                res[i][j]=count++;
            }
            //左下 到 左上
            for(;i>=loop;i--){
                res[i][j]=count++;
            }
            start++;
        }
        if(n%2==1){
            res[start][start]=count;
        }
        return res;

    }
}
// @lc code=end

