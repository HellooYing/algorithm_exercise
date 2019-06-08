import java.util.Stack;

public class reverseList {

    public ListNode answer2(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode n1=head,n2=head.next,n3=head.next.next;
        head.next=null;
        n2.next=n1;
        n1=n2;
        while(n3!=null){
            n2=n3;
            n3=n3.next;
            n2.next=n1;
            n1=n2;
        }
        return n2;
    }

    public ListNode answer1(ListNode head) {
        if(head==null||head.next==null) return head;
        Stack<ListNode> stack=new Stack<>();
        ListNode node=head;
        while(node!=null){
            stack.push(node);
            node=node.next;
        }
        node=stack.pop();
        ListNode r=node;
        while(node!=head){
            node.next=stack.peek();
            node=stack.pop();
        }
        head.next=null;
        return r;
    }
}
