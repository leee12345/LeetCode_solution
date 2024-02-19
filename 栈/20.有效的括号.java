/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 *
 * https://leetcode.cn/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (43.87%)
 * Likes:    4290
 * Dislikes: 0
 * Total Accepted:    1.7M
 * Total Submissions: 3.8M
 * Testcase Example:  '"()"'
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：s = "()"
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：s = "()[]{}"
 * 输出：true
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：s = "(]"
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 * 
 * 
 */

// @lc code=start

import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character>deque= new LinkedList<>();
        char ch;
        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            if(ch=='('){
                deque.push(')');
            }else if(ch=='['){
                deque.push(']');
            }else if(ch=='{'){
                deque.push('}');
            }else if(deque.isEmpty()||deque.peek()!=ch){
                return false;
            }else{//deque.peek()==ch
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
// @lc code=end

