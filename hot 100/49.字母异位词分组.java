/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 *
 * https://leetcode.cn/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (67.75%)
 * Likes:    1769
 * Dislikes: 0
 * Total Accepted:    580.4K
 * Total Submissions: 856.7K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * 示例 2:
 * 
 * 
 * 输入: strs = [""]
 * 输出: [[""]]
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= strs.length <= 10^4
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * 
 * 
 */

// @lc code=start

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      Map<String,List<String>> map = new HashMap<String,List<String>>();
      for(String str:strs){
        char[] array = str.toCharArray();
        Arrays.sort(array);
        String key= new String(array);
        List<String> list = map.getOrDefault(key, new ArrayList<String>());
        list.add(str);
        map.put(key, list);
      }
      return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

