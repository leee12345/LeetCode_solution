/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 *
 * https://leetcode.cn/problems/reverse-linked-list/description/
 *
 * algorithms
 * Easy (73.76%)
 * Likes:    3447
 * Dislikes: 0
 * Total Accepted:    1.7M
 * Total Submissions: 2.3M
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 
 * 
 * 
 * 
 * 
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * 
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 /***
  * 迭代
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null)
        {
            ListNode nex=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nex;
        }
        return pre;
    }
}
  */
/***
  * 递归
*/
class Solution {
    public ListNode reverseList(ListNode head) {
       if(head==null||head.next==null) return head;
       ListNode newHead=reverseList(head.next);
       head.next.next=head;//head的下一个节点指针指向head
       head.next=null;
       return newHead;
    }
}
// @lc code=end

