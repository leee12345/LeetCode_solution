import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubString{
    /*
     * 题目二 从一个字符串中找到一个连续子串，该子串中任何两个字符不能相同，求子串的最大长度并输出一条最长不重复子串。 

	例如字符串“abcdeab”，第二个字符a之前的最长不重复子串是“abcde”，a与最长子串中的字符有重复，但是它与稍短的“bcde”串没有重复，于是它可以与其构成一个新的子串，之前的最长重复子串“abcde”结束；
     */
    //滑动窗口
    public static void main(String[] args) {
        String s = "abcdeab";
        int[] result = longestUniqueSubstring(s);
        int maxLength = result[0];
        String maxSubstring = s.substring(result[1], result[2]);

        System.out.println("最长不重复子串长度: " + maxLength);
        System.out.println("最长不重复子串: " + maxSubstring);
    }
    /*
     * 用start指针来标记当前最长不重复子串的起始位置，初始化为0。
     * 遍历输入字符串，如果当前字符已经在char_index中，并且其索引大于或等于start指针所指向的位置，
     * 则更新start指针为该字符上一次出现的索引加1，确保当前子串不包含重复字符。
     */
    public static int[] longestUniqueSubstring(String s) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int start = 0;
        int maxLength = 0;
        int[] result = new int[3];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndex.containsKey(c) && charIndex.get(c) >= start) {
                start = charIndex.get(c) + 1;
            }

            if (i - start + 1 > maxLength) {
                maxLength = i - start + 1;
                result[0] = maxLength;
                result[1] = start;
                result[2] = i + 1;
            }

            charIndex.put(c, i);
        }

        return result;
    }
}