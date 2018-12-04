
import java.util.*;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Merge {
    public static void main(String[] args) throws Exception {
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(4);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(2);
        l2.next.next=new ListNode(3);
        ListNode r=new Merge().answer(l1,l2);
        while(r!=null){
            System.out.println(r.val);
            r=r.next;
        }
    }
    public ListNode answer(ListNode list1,ListNode list2){
        ListNode head;
        ListNode t;
        ListNode t1;
        ListNode t2;
        if(list1==null&&list2==null) return null;
        else if(list1==null) return list2;
        else if(list2==null) return list1;
        if(list1.val<=list2.val){
            head=list1;
            t=head;
            t1=list1.next;
            t2=list2;
        }
        else {
            head=list2;
            t=head;
            t1=list2.next;
            t2=list1;
        }
        while(t1!=null&&t2!=null){
            if(t1.val>=t2.val){
                t.next=t2;
                t=t.next;
                t2=t2.next;
            }
            else{
                t.next=t1;
                t=t.next;
                t1=t1.next;
            }
        }
        if(t1!=null) t.next=t1;
        if(t2!=null) t.next=t2;
        return head;
    }
}