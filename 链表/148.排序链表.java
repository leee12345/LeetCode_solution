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
        ListNode lastsorted=head;
        ListNode cur=head.next;
        while(cur!=null){
            if(lastsorted.val<=cur.val){//插入lastsort后 lastsort移动
                lastsorted.next=cur;
                lastsorted=cur;
            }else{//插入lastsort前 lastsort不动
                ListNode pre=dummyHead;
                while(pre.next.val<=cur.val){
                    pre=pre.next;
                }
                lastsorted.next=cur.next;
                cur.next=pre.next;
                pre.next=cur;
            }
            cur=lastsorted.next;
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
        return sort(head);

    }
    private static ListNode sort(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode mid=findMid(head);
        ListNode l=head;
        ListNode r=mid.next;
        mid.next=null;
        l=sort(l);
        r=sort(r);
        return mergeList(l,r);
    }

    private static ListNode findMid(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static ListNode mergeList(ListNode l1,ListNode l2){
       ListNode dummyHead= new ListNode(-1);
       ListNode cur=dummyHead;
       while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }
            else{
                cur.next=l2;
                l2=l2.next;
            }
        cur=cur.next;
       }
       cur.next=l1==null?l2:l1;
       return dummyHead.next;
    }
}

    
// @lc code=end

