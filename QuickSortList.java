import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val, ListNode next){this.val=val;this.next=next;}
}
public class QuickSortList {

    public static void main(String[] args){
        ListNode head=createList();
        System.out.println("排序前：");
        printList(head);
        ListNode end=head;
        if(head!=null){
            while (end.next!=null) {
                end=end.next;
            }
        }
        quickSort(head,end);
        System.out.println("排序后：");
        printList(head);
    }
    
    private static void quickSort(ListNode begin,ListNode end){
        if(begin==null||begin==end) return;
        ListNode index=partition(begin,end);//划分元素 以头结点划分
        quickSort(begin, index);
        quickSort(index.next, end);
    }
    
    private static ListNode partition(ListNode begin,ListNode end){
        if(begin==null||begin==end) return begin;
        
        int val=begin.val;
        ListNode index=begin,cur=begin.next;
        while(cur!=null){
            if(cur.val<val){
                index=index.next;
                int tmp=cur.val;
                cur.val=index.val;
                index.val=tmp;
            }
            cur=cur.next;
        }
        begin.val=index.val;
        index.val=val;
        return index;
    }

    /**
     * 划分函数 以头结点值为基准元素进行划分
     */
    

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
        String s= sc.nextLine().trim();
         ListNode dummyHead= new ListNode(-1);
        ListNode cur=dummyHead;
        if(s!=""||s!=null){
            String[] strs= s.split(",");
            for(String str: strs){
                cur.next= new ListNode(Integer.parseInt(str));
                cur=cur.next;
            }
        }
        cur.next=null;
        return dummyHead.next;
    }



    
}
