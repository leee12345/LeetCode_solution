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
 * 
class Solution {
    private ListNode reverse(ListNode head){
        //迭代反转链表
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
    private ListNode findMid(ListNode head){ 
        //快慢指针找中点
        ListNode s=head;
        ListNode f=head;
        if(head==null) return null;
        while(f.next!=null&&f.next.next!=null)
        {
            //mid为中间偏前的点
            s=s.next;
            f=f.next.next;
        }
        return s;
    }
    private void mergeList(ListNode l1,ListNode l2){
        ListNode l1nex;
        ListNode l2nex;
        while(l1!=null&&l2!=null)
        {
            l1nex=l1.next;
            l2nex=l2.next;
            
            l1.next=l2;
            l2.next=l1nex;
            l1=l1nex;
            l2=l2nex;
        }
    }
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode mid=findMid(head);
        ListNode l1=head;
        ListNode l2=mid.next;
        mid.next=null;
        l2=reverse(l2);
        mergeList(l1,l2);
    }
}
 */

 /***
  * 数组存链表元素
  */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        List<ListNode> list= new ArrayList<ListNode>();
        ListNode node=head;
        while(node!=null)
        {
            list.add(node);
            node=node.next;
        }
        int i=0,j=list.size()-1;
        while(i<j)
        {
            list.get(i).next=list.get(j);
            i++;
            if(i==j) break;
            list.get(j).next=list.get(i);
            j--;
        }
        list.get(i).next=null;
    }
}
// @lc code=end

