import java.util.*;


class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val,ListNode next){this.val=val;this.next=next;}
}
class test{
    public static void main(String[]args){
        System.out.println("请输入要反转的链表 例如: [1,2,3,4]");
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        s=s.replace("[","").replace("]","");
        String[] string=s.split(",");
        ListNode dummyHead= new ListNode(-1);
        ListNode cur=dummyHead;
        for (String str:string){
            ListNode node=new ListNode(Integer.parseInt(str));
            cur.next=node;
            cur=cur.next;
        }
        testsample(dummyHead.next);
        return;

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
    public static void testsample(ListNode head){
        System.out.println("反转前");
        ListNode p=head;
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
        ListNode newHead=solution(head);
        p=newHead;
        System.out.println("反转后");
        while(p!=null){
            System.out.println(p.val);
            p=p.next;
        }
    }
}

    