/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 *
 * https://leetcode.cn/problems/swap-nodes-in-pairs/description/
 *
 * algorithms
 * Medium (71.77%)
 * Likes:    2109
 * Dislikes: 0
 * Total Accepted:    749.9K
 * Total Submissions: 1M
 * Testcase Example:  '[1,2,3,4]'
 *
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：head = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：head = [1]
 * 输出：[1]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
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
    /*迭代
     * 
    public ListNode swapPairs(ListNode head) {
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode pre=preHead;
        while(pre.next!=null&&pre.next.next!=null)
        {
           ListNode node1=pre.next;
           ListNode node2=pre.next.next;
           pre.next=node2;
           node1.next=node2.next;
           node2.next=node1;
           //更新pre
           pre=node1;

        }
        return preHead.next;
    }
    */

    /*
     *递归
     */ 

     public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)//结束条件
        {
            return head;
        }
        ListNode node1=head;
        ListNode node2=head.next;
        ListNode nex=node2.next;
        node1.next=swapPairs(nex);
        node2.next=node1;
        return node2;
    }


    /*
     *迭代

     public ListNode swapPairs(ListNode head) {
        ListNode  dummyHead= new ListNode(0);
        dummyHead.next=head;
        ListNode pre=dummyHead;
        ListNode end=dummyHead;
        while(end.next!=null)
        {
            for(int i=0;i<2&&end!=null;i++)
            {
                end=end.next;
            }
            if(end==null) break;//奇数个剩余1个不翻转
            ListNode start=pre.next;
            ListNode nex=end.next;
            end.next=null;//把start-end这段单独拿出来 null标志这段的结束
            pre.next=swap(start);
            start.next=nex;//翻转后的start为最后一个 start的next为nex

            //更新pre和end end等待下一轮向后遍历2个
            pre=start;
            end=pre;
        }
        return dummyHead.next;
    }
    private ListNode swap(ListNode head)
    {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null)
        {
            ListNode nex=cur.next;
            cur.next=pre;//改变指针方向
            //更新pre和cur
            pre=cur;
            cur=nex;
        }
        return pre;
    }

    */


}
// @lc code=end

