/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 *
 * https://leetcode.cn/problems/palindrome-linked-list/description/
 *
 * algorithms
 * Easy (53.80%)
 * Likes:    1833
 * Dislikes: 0
 * Total Accepted:    667.4K
 * Total Submissions: 1.2M
 * Testcase Example:  '[1,2,2,1]'
 *
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = [1,2]
 * 输出：false
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点数目在范围[1, 10^5] 内
 * 0 <= Node.val <= 9
 * 
 * 
 * 
 * 
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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
 *快慢指针找中点 mid 反转 然后指针分别从head和mid遍历判断
*
*
class Solution {
    //快慢指针找中点 mid 反转 然后指针分别从head和mid遍历判断
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode r=slow.next;
        slow.next=null;
        r=reverse(r);
        ListNode l=head;

        while(l!=null&&r!=null){
            if(l.val!=r.val) return false;
            l=l.next;
            r=r.next;
        }
        return true;  
    }
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
}
 */

import java.util.List;

/***
 * 存入数组 双指针
*
class Solution {
    //快慢指针找中点 mid 反转 然后指针分别从head和mid遍历判断
    public boolean isPalindrome(ListNode head) {
        if(head==null) return true;
       List<Integer>array= new ArrayList<Integer>();
       ListNode p=head;
       while(p!=null){
        array.add(p.val);
        p=p.next;
       }
       int l=0,r=array.size()-1;
       while(l<r){
         if(!array.get(l).equals(array.get(r))){
            return false;
         }
         l++;
         r--;
       }
       return true;
    }
   
}
*
*/

/***
 * 递归
 */

class Solution {
    private ListNode frontPointer;
    
    private boolean Check(ListNode cur){
        if(cur!=null){
            if(!Check(cur.next)){
                return false;
            }
            if(cur.val!=frontPointer.val){
                return false;
            }
            frontPointer=frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head){
        frontPointer=head;
        return Check(head);
   }

}
// @lc code=end

