/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 *
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (55.86%)
 * Likes:    1707
 * Dislikes: 0
 * Total Accepted:    456.8K
 * Total Submissions: 817.8K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left  。请你反转从位置 left 到位置 right 的链表节点，返回
 * 反转后的链表 。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目为 n
 * 1 
 * -500 
 * 1 
 * 
 * 
 * 
 * 
 * 进阶： 你可以使用一趟扫描完成反转吗？
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
/*
 * 分割-反转-拼接
 * 
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead= new ListNode(0);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode end=dummyHead;
        for(int i=0;i<left-1;i++)
        {
            pre=pre.next;
        }
        for(int i=0;i<right;i++)
        {
            end=end.next;
        }
        ListNode start=pre.next;
        ListNode nex=end.next;
        pre.next=null;
        end.next=null;
        
        pre.next=swap(start);
        start.next=nex;
        return dummyHead.next;
    }
    private ListNode swap(ListNode head)
    {
        if(head==null||head.next==null) return head;
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

import java.util.List;

/**
 * 一次遍历 穿针引线
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
       ListNode dummyHead= new ListNode(-1);
       dummyHead.next=head;
       ListNode pre=dummyHead;
       for(int i=0;i<left-1;i++) pre=pre.next;
       ListNode cur=pre.next;
       ListNode nex;
       for(int i=0;i<right-left;i++)
       {
            nex=cur.next;//nex向后移
            cur.next=nex.next;
            nex.next=pre.next;
            pre.next=nex;
       }
       return dummyHead.next;

    }
    }
// @lc code=end

