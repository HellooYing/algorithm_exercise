import java.util.Scanner;
import java.util.Stack;

public class xc201904082 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        int k=in.nextInt();
        in.close();
        s=s.substring(1,s.length()-1);
        String[] a1=s.split(",");
        ListNode head=new ListNode(Integer.parseInt(a1[0]));
        ListNode node=head;
        for (int i = 1; i < a1.length; i++) {
            node.next =new ListNode(Integer.parseInt(a1[i]));
            node=node.next;
        }
        ListNode r=answer(head,k);
        System.out.print("[");
        while(r!=null){
            System.out.print(r.val);
            if(r.next!=null) System.out.print(",");
            r=r.next;
        }
        System.out.println("]");
    }
    static ListNode answer(ListNode head,int k){
        if(head==null||k<=1) return head;
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode ok;
        ListNode node=head;

        for (int i = 0; i <k; i++) {
            if(node!=null) stack.push(node);
            else return head;
            node=node.next;
        }
        head=stack.pop();
        ok=head;
        for (int i = 0; i <k-1 ; i++) {
            ok.next=stack.pop();
            ok=ok.next;
        }
        ok.next=node;
        if(node==null) return head;
        while(node!=null){
            for (int i = 0; i <k; i++) {
                if(node!=null) stack.push(node);
                else return head;
                node=node.next;
            }
            for (int i = 0; i <k ; i++) {
                ok.next=stack.pop();
                ok=ok.next;
            }
            ok.next=node;
        }
        return head;
    }
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
