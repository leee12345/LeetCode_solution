import java.util.*;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val,ListNode next){ this.val=val;this.next=next;}
}


public class MergeSortList {

    public static void main(String [] args){
        ListNode head=createList();
        printList(head);
        ListNode newHead=mergeSort(head);
        printList(newHead);
        return;
    }
    private static ListNode findMid(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private static ListNode merge(ListNode l1,ListNode l2){
        ListNode dummyHead= new ListNode(-1);
        ListNode cur=dummyHead;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=l1==null?l2:l1;
        return dummyHead.next;
    }

    private static ListNode mergeSort(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode mid=findMid(head);
        ListNode r=mid.next;
        mid.next=null;
        ListNode l_new=mergeSort(head);
        ListNode r_new=mergeSort(r);
        ListNode newhead=merge(l_new, r_new);
        return newhead;
    }


    private static void printList(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    private static ListNode createList(){
        System.out.println("请输入链表以逗号分隔：");
        Scanner sc = new Scanner(System.in);
        String s= sc.nextLine();
        String[] strs= s.split(",");
        ListNode dummyHead= new ListNode(-1);
        ListNode cur=dummyHead;
        for(String str: strs){
            cur.next= new ListNode(Integer.parseInt(str));
            cur=cur.next;
        }
        cur.next=null;

        return dummyHead.next;
    }
    
  
    
}
