import java.util.Stack;

public class reverseKGroup {
    public static void main(String[] args) throws Exception {
        //24min 脑子不清楚的debug成功 但仍然不完全清晰
        ListNode head=new ListNode(1);
        ListNode a=new ListNode(2);
        head.next=a;
        ListNode b=new ListNode(3);
        a.next=b;
        a=new ListNode(4);
        b.next=a;
        b=new ListNode(5);
        a.next=b;
        a=new ListNode(6);
        b.next=a;
        b=new ListNode(7);
        a.next=b;
        head=answer(head,2);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    static ListNode answer(ListNode head,int k){

        Stack<ListNode> s=new Stack<ListNode>();
        ListNode h=head,e,start;
        for(int i=0;i<k;i++){
            if(h==null) return head;
            s.push(h);
            h=h.next;
        }
        h=s.pop();
        start=h.next;
        head=h;
        for(int i=0;i<k-1;i++){
            h.next=s.pop();
            h=h.next;
        }
        e=h;
        e.next=start;
        h=start;
        while(h!=null){
            for(int i=0;i<k;i++){
                if(h==null) return head;
                s.push(h);
                h=h.next;
            }
            h=s.pop();
            start=h.next;
            e.next=h;
            for(int i=0;i<k-1;i++){
                h.next=s.pop();
                h=h.next;
            }
            e=h;
            e.next=start;
            h=start;
        }
        return head;
    }
}
