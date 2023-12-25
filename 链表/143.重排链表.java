/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 *
 * https://leetcode.cn/problems/reorder-list/description/
 *
 * algorithms
 * Medium (65.91%)
 * Likes:    1419
 * Dislikes: 0
 * Total Accepted:    296.1K
 * Total Submissions: 449.2K
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * 
 * 
 * L0 → L1 → … → Ln - 1 → Ln
 * 
 * 
 * 请将其重新排列后变为：
 * 
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表的长度范围为 [1, 5 * 10^4]
 * 1 <= node.val <= 1000
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
/*
 * 找链表中点+链表后半翻转 +前后半合并
 * 时间 O(N)
 * 空间 O(N)
*/

class Solution {

    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nex=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nex;
        }
        return pre;

    }
    private ListNode findMid(ListNode head)
    {
        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private void mergeList(ListNode l1,ListNode l2){
        ListNode nex1=l1;
        ListNode nex2=l2;
        while(l1!=null&&l2!=null){
            nex1=l1.next;
            nex2=l2.next;
            
            l1.next=l2;
            l1=nex1;
            l2.next=l1;
            l2=nex2;
        }
    }
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode mid=findMid(head);
        ListNode l=head;
        ListNode r=mid.next;
        mid.next=null;
        ListNode r_new=reverse(r);
        mergeList(l, r_new);
    }

}


/***
  * 数组存链表元素
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        List<ListNode>array= new ArrayList<ListNode>();
        ListNode p=head;
        while(p!=null){
            array.add(p);
            p=p.next;
        }
        int i=0,j=array.size()-1;
        while(i<j){
            array.get(i).next=array.get(j);
            i++;
            if(i==j) break;
            array.get(j).next=array.get(i);
            j--;
        }
        array.get(i).next=null;
    }
}
*/
// @lc code=end

