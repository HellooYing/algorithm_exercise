public class removeElements {
    public static void main(String[] args) throws Exception {
        //12min 有bug 思路不够清晰啊！
        ListNode head=new ListNode(1);
        ListNode a=new ListNode(2);
        head.next=a;
        ListNode b=new ListNode(7);
        a.next=b;
        a=new ListNode(9);
        b.next=a;
        b=new ListNode(1);
        a.next=b;
        a=new ListNode(2);
        b.next=a;
        b=new ListNode(2);
        a.next=b;
        head=answer(head,2);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    static ListNode answer(ListNode head,int i){
        if(head==null) return head;
        ListNode h,t;
        while(head!=null&&head.val==i) head=head.next;
        if(head==null) return head;
        h=head;
        t=h;
        h=h.next;
        while(h!=null){
            while(h!=null&&h.val==i) h=h.next;
            t.next=h;
            t=t.next;
            if(h!=null) h=h.next;
        }
        return head;
    }
}
