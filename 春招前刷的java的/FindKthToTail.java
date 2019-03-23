import java.util.*;



public class FindKthToTail{
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {
        ListNode h=new ListNode(1);
        h.next=new ListNode(2);
        h.next.next=new ListNode(3);
        System.out.println(new FindKthToTail().answer(h,1).val);
    }

    public ListNode answer(ListNode head,int k){
        if(head==null) return head;
        if(k==0) return null;
        ListNode e=head;
        for(int i=0;i<k-1;i++) {if(e.next!=null) e=e.next;else return null;}
        ListNode r;
        r=head;
        while(e.next!=null){
            e=e.next;
            r=r.next;
        }
        return r;
    }
}