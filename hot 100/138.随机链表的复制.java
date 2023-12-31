/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 *
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/
 *
 * algorithms
 * Medium (66.08%)
 * Likes:    1293
 * Dislikes: 0
 * Total Accepted:    238.1K
 * Total Submissions: 359.9K
 * Testcase Example:  '[[7,null],[13,0],[11,4],[10,2],[1,0]]'
 *
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random
 * 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random
 * --> y 。
 * 
 * 返回复制链表的头节点。
 * 
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * 
 * 
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 
 * 
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 
 * 
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 
 * 
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 
 * 
 * 示例 3：
 * 
 * 
 * 
 * 
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 <= n <= 1000
 * -10^4 <= Node.val <= 10^4
 * Node.random 为 null 或指向链表中的节点。
 * 
 * 
 * 
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//HashMap+递归
// class Solution {
//     Map<Node,Node> map= new HashMap<Node,Node>();

//     public Node copyRandomList(Node head) {
//         if(head==null) return null;
//         if(!map.containsKey(head)){
//             Node headNew=new Node(head.val);
//             map.put(head, headNew);
//             headNew.next=copyRandomList(head.next);
//             headNew.random=copyRandomList(head.random);
//         }
//         return map.get(head);
        
//     }
// }

//HashMap+迭代
// class Solution {
//     public Node copyRandomList(Node head) {
//         if(head==null) return null;
//         Map<Node,Node>map= new HashMap<Node,Node>();
//         Node cur=head;
//         while(cur!=null){
//             map.put(cur,new Node(cur.val));
//             cur=cur.next;
//         }
//         cur=head;
//         while(cur!=null){
//             map.get(cur).next= map.get(cur.next);
//             map.get(cur).random= map.get(cur.random);
//             cur=cur.next;
//         }
//         return map.get(head);        
//     }
// }
 
//节点拆分 A->A'->B->B'->C->C'
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        //创建新节点 加入链表
        for(Node node=head;node!=null;node=node.next.next){
            Node nodeNew = new Node(node.val);
            nodeNew.next=node.next;
            node.next=nodeNew;
        }
        //设置random
        for(Node node =head;node!=null;node=node.next.next){
            Node nodeNew=node.next;
            nodeNew.random=(node.random!=null)?node.random.next:null;
        }
        //新节点next指向新节点
        Node headNew=head.next;
        for(Node node=head;node!=null;node=node.next){
            Node nodeNew=node.next;
            node.next=nodeNew.next;
            nodeNew.next=(nodeNew.next!=null)?nodeNew.next.next:null;
        }
        return headNew;
    }
}

// @lc code=end

