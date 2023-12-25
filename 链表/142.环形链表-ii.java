/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 *
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/
 *
 * algorithms
 * Medium (58.01%)
 * Likes:    2421
 * Dislikes: 0
 * Total Accepted:    790.9K
 * Total Submissions: 1.4M
 * Testcase Example:  '[3,2,0,-4]\n1'
 *
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos
 * 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos
 * 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 
 * 不允许修改 链表。
 * 
 * 
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 
 * 
 * 示例 3：
 * 
 * 
 * 
 * 
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 链表中节点的数目范围在范围 [0, 10^4] 内
 * -10^5 <= Node.val <= 10^5
 * pos 的值为 -1 或者链表中的一个有效索引
 * 
 * 
 * 
 * 
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/* 
 * 哈希表 存储节点 时间 O(n) 空间 O(n)
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode pos=head;
        Set<ListNode>set= new HashSet<ListNode>();
        while(pos!=null)
        {
            if(set.contains(pos))
            {
                return pos;
            }else{
                set.add(pos);
                pos=pos.next;
            }
        }
        return null;
    }
}
*/

/* 
 * 快慢指针 时间 O(n) 空间 O(1)
 * 快指针每次走两步 慢指针每次走一步在环内相遇 a:环外步数 b：相遇点 c：相遇点到入环点
 * fast: a+n(b+c)+b=a+(n+1)b+nc
 * slow: a+b
 * a+(n+1)b+nc=a*(a+b)
 * a=c+(n-1)(b+c)
 * 
 * 
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }else{
                return null;//不是环
            }
            if(fast==slow)//是环
            {
                //找环起始点
                ListNode p=head;
                while(p!=fast){
                    p=p.next;
                    fast=fast.next;
                }
                if(p==fast) return p;
            }
        }
        return null;
    }
}
// @lc code=end

