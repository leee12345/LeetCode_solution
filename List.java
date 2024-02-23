class ListNode{
    int val;
    ListNode next;
    ListNode ( int val){
        this.val=val;
        this.next=null;
    }

}
public class List {
    public static void main(String[]args){

        

    }

    public  boolean ispal(ListNode head){
        if(head.next == null) return true;

        ListNode l=head;
        ListNode mid=findMid(head);

        ListNode r=reverse(mid);
        
        mid.next=null;
        while(l!=null&&r!=null){
            if(l.val!=r.val){
                return false;
            }
            l=l.next;
            r=r.next;
        }
        return true;

    }
    public static ListNode findMid(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static ListNode reverse(ListNode head){
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
