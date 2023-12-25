class ListNode{
        ListNode next;
        int val;
        ListNode(int val){this.val=val;}
    }
    
class test{
    public static void main(String []args ){
        ListNode head= new ListNode(1);
        ListNode cur=head;
        for(int i=0;i<3;i++){
            cur.next=new ListNode(i+2);
            cur=cur.next;
        }
        cur.next=null;
        ListNode p=head;
        while(p!=null){
            System.out.println(p.val+" ");
            p=p.next;
        }
        ListNode newHead=solution(head);
        p=newHead;
        while(p!=null){
            System.out.println(p.val+" ");
            p=p.next;
        }
        

    }
    public static ListNode solution(ListNode head){
        if(head==null) return null;
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