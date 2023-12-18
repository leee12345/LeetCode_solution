/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 *
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/description/
 *
 * algorithms
 * Hard (67.72%)
 * Likes:    2249
 * Dislikes: 0
 * Total Accepted:    530.9K
 * Total Submissions: 784K
 * Testcase Example:  '[1,2,3,4,5]\n2'
 *
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * 
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中的节点数目为 n
 * 1 <= k <= n <= 5000
 * 0 <= Node.val <= 1000
 * 
 * 
 * 
 * 
 * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
 * 
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
class Solution {
    //链表分为 已翻转 未翻转 待翻转 3部分
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead= new ListNode(0);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode end=dummyHead;
        while(end.next!=null)
        {
            for(int i=0;i<k&&end!=null;i++)
            {   
                end=end.next;
            }
            if(end==null) break;
            ListNode start=pre.next;
            ListNode nex=end.next;
            end.next=null;
            pre.next=reverse(start);
            start.next=nex;

            pre=start;
            end=pre;

        }
        return dummyHead.next;
    }
    public ListNode reverse(ListNode head)
    {
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
// @lc code=end

