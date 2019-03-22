import java.util.*;

public class deleteDuplication {
    static class ListNode {
        int val;
        ListNode next = null;
    
        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {
        ListNode a,b,head;
        head=new ListNode(1);
        b=new ListNode(1);
        head.next=b;
        a=new ListNode(2);
        b.next=a;
        b=new ListNode(3);
        a.next=b;
        a=new ListNode(3);
        b.next=a;
        b=new ListNode(4);
        a.next=b;
        a=new ListNode(5);
        b.next=a;
        b=new ListNode(5);
        a.next=b;
        ListNode r=new deleteDuplication().answer(head);
        while(r!=null){
            System.out.println(r.val);
            r=r.next;
        }
    }

    public ListNode answer(ListNode pHead){
        //42min disaster
        if(pHead==null||pHead.next==null) return pHead;
        ListNode p1=pHead,p=pHead.next;
        while(p!=null&&p1.val==p.val){
            while(p!=null&&p.val==p1.val) p=p.next;
            if(p==null) return null;
            pHead=p;
            p1=pHead;
            p=p1.next;
        }
        while(p!=null&&p.next!=null){
            if(p.val!=p.next.val){
                p=p.next;
                p1=p1.next;
                continue;
            }
            if(p.val==p.next.val){
                while(p.val==p.next.val){
                    if(p.next.next==null){
                        p1.next=null;
                        return pHead;
                    }
                    else{
                        p1.next=p.next;
                        p=p.next;
                    }
                }
            }
            p1.next=p.next;
            p=p.next;
        }
        return pHead;
    }
}