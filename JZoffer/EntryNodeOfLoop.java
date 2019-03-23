public class EntryNodeOfLoop {
    public static void main(String[] args) throws Exception {
        //6.5min
        ListNode head=new ListNode(1);
        ListNode a=new ListNode(2);
        head.next=a;
        ListNode b=new ListNode(3);
        a.next=b;
        a=new ListNode(4);
        b.next=a;
        b=new ListNode(3);
        a.next=b;
        ListNode r=a;
        a=new ListNode(2);
        b.next=a;
        b=new ListNode(1);
        a.next=b;
        a=new ListNode(0);
        b.next=a;
        a.next=r;
        a=answer(head);
        if(a==r) System.out.println("ok");
    }
    static ListNode answer(ListNode head){
        if(head==null||head.next==null||head.next.next==null) return null;
        ListNode k=head.next.next,m=head.next;
        while(k!=m){
            if(k==null||k.next==null||k.next.next==null) return null;
            k=k.next.next;
            m=m.next;
        }
        k=head;
        while(k!=m){
            k=k.next;
            m=m.next;
        }
        return k;
    }
}
