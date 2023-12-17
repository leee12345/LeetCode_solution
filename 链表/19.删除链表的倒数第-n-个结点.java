/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //双指针法
        //head 是头结点 有val值
        //需要构建前置节点
        ListNode preHead= new ListNode(-1);
        preHead.next=head;
        ListNode l=preHead;
        ListNode r=preHead;

        for(int i=0;i<n;i++) r=r.next;
        while(r.next!=null)
        {
            l=l.next;
            r=r.next;
        }
        l.next=l.next.next;

        return preHead.next;

    }
}
// @lc code=end

