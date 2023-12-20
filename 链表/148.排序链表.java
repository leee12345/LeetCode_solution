/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 *
 * https://leetcode.cn/problems/sort-list/description/
 *
 * algorithms
 * Medium (65.52%)
 * Likes:    2188
 * Dislikes: 0
 * Total Accepted:    453.4K
 * Total Submissions: 692.1K
 * Testcase Example:  '[4,2,1,3]'
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
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
 * 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -10^5 <= Node.val <= 10^5
 * 
 * 
 * 
 * 
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
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
/**
 * 插入排序
 * 
class Solution {
    //插入排序
    public ListNode sortList(ListNode head) {
       if(head==null) return null;
       ListNode dummyHead= new ListNode(-1);
       dummyHead.next=head;
       ListNode sortlast=head;
       ListNode cur=head.next;
       while(cur!=null)
       {
            if(cur.val>=sortlast.val){
                sortlast.next=cur;
                sortlast=cur;
            }else{
                //从前向后遍历找位置
                ListNode pre=dummyHead;
                while(pre.next.val<=cur.val){
                    pre=pre.next;
                }
                sortlast.next=cur.next;
                cur.next=pre.next;
                pre.next=cur;
            }
            cur=sortlast.next;
       }
       return dummyHead.next;
    }
}
 */

 /***
  * 归并排序：(自顶向下)
  * 找到中点（快慢指针法则） 分别排序 有序链表合并
  */
class Solution {
    //归并排序
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode r=slow.next;
        slow.next=null;
        r=mergeSort(r);
        ListNode l=head;
        l=mergeSort(l);
        return mergeList(l,r);
    }
    private ListNode mergeList(ListNode l,ListNode r){
        ListNode dummyHead= new ListNode(-1);
        ListNode pre=dummyHead;
        while(l!=null&&r!=null){
            if(l.val<=r.val){
                pre.next=l;
                l=l.next;
            }else{
                pre.next=r;
                r=r.next;
            }
            pre=pre.next;
        }
        pre.next=l==null?r:l;
        return dummyHead.next;

    }
    

    

}
// @lc code=end

