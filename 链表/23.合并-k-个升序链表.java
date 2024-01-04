/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并 K 个升序链表
 *
 * https://leetcode.cn/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (58.73%)
 * Likes:    2720
 * Dislikes: 0
 * Total Accepted:    737K
 * Total Submissions: 1.3M
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * ⁠ 1->4->5,
 * ⁠ 1->3->4,
 * ⁠ 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 
 * 
 * 示例 2：
 * 
 * 输入：lists = []
 * 输出：[]
 * 
 * 
 * 示例 3：
 * 
 * 输入：lists = [[]]
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
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
/**
 * 顺序合并

class Solution {
    //顺序合并
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=null;
        for(int i=0;i<lists.length;i++){
            ans=mergeTwoList(ans,lists[i]);
        }
        return ans;
    }

    private ListNode mergeTwoList(ListNode l1,ListNode l2){
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else if(l1.val<l2.val){
            l1.next=mergeTwoList(l1.next, l2);
            return l1;
        }else{
            l2.next=mergeTwoList(l1, l2.next);
            return l2;
        }
    }

}
**/

/***
 * 分治合并

class Solution {
    //分治合并 两两合并 对合并后的链表再进行合并
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int l,int r){
        if(l==r){
            return lists[l];
        }
        if(l>r){
            return null;
        }
        int mid=(l+r)/2;
        return mergeTwoList(merge(lists,l,mid),merge(lists,mid+1,r));
    }
    private ListNode mergeTwoList(ListNode l,ListNode r){
        if(l==null){
            return r;
        }else if(r==null){
            return l;
        }else if(l.val<r.val){
            l.next=mergeTwoList(l.next,r);
            return l;
        }else{
            r.next=mergeTwoList(l,r.next);
            return r;
        }
    } 
}
*/

class Solution {
    //优先队列合并
    //维护每个链表中没有被合并的元素的最前面一个
    //PriorityQueue： 始终给返回最高优先级
    //定义 Status的 compareTo接口
    class Status implements Comparable<Status>{
        int val;
        ListNode ptr;

        Status(int val,ListNode ptr){
            this.val=val;
            this.ptr=ptr;
        }

        public int compareTo(Status status2){
            return this.val-status2.val;
        }
    }
    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for(ListNode node:lists){
            if(node!=null){
                queue.offer(new Status(node.val,node));
            }
        }

        ListNode head=new ListNode(0);
        ListNode tail=head;
        while(!queue.isEmpty()){
            Status f= queue.poll();//返回并删除队列的头部元素
            tail.next=f.ptr;
            tail=tail.next;
            if(f.ptr.next!=null){
                queue.offer(new Status(f.ptr.next.val,f.ptr.next));//插入队列尾部
            }
        }
        return head.next;
    }
}
// @lc code=end

