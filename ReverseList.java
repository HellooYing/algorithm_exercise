import java.util.*;
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseList {
    public static void main(String[] args) throws Exception {
        ListNode h=new ListNode(1);
        h.next=new ListNode(2);
        h.next.next=new ListNode(3);
        h.next.next.next=new ListNode(4);
        //1->2->3->4 p->q->s->4,q.next=p;if(s.next!=null)p=s.next;s.next->q;if(p.next!=null)q=p.next;
        ListNode r=new ReverseList().answer(h);
        while(r!=null){
            System.out.println(r.val);
            r=r.next;
        }
    }

    public ListNode answer(ListNode head){
        ListNode p,q,s;
        if(head!=null) p=head;
        else return null;
        if(p.next!=null) q=p.next;
        else return p;
        if(q.next!=null) s=q.next;
        else{
            q.next=p;
            return q;
        }
        p.next=null;
        //1->2->3->4 p->q->s->4
        while(true){
            q.next=p;
            if(s.next!=null) p=s.next;
            else {s.next=q;return s;}
            s.next=q;
            if(p.next!=null) q=p.next;
            else {p.next=s;return p;}
            p.next=s;
            if(q.next!=null) s=q.next;
            else {q.next=p;return q;}
        }
    }
}