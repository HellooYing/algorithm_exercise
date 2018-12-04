
import java.util.*;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class printListFromTailToHead {
    public static void main(String[] args) throws Exception {
        ListNode a = new ListNode(10);
        a.next = new ListNode(9);
        a.next.next = new ListNode(8);
        System.out.println(new printListFromTailToHead().answer(a).toString());
    }

    public ArrayList<Integer> answer(ListNode listNode) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        ListNode n=listNode;
        if(n==null) return r;
        while(n.next!=null){
            r.add(0,n.val);
            n=n.next;
        }
        r.add(0,n.val);
        return r;
    }

}