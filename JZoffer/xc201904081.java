import java.util.HashMap;
import java.util.Scanner;

public class xc201904081 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        in.close();
        String[] a=s.split(",");
        HashMap<String,ListNode> map=new HashMap<String,ListNode>();
        ListNode head=new ListNode(a[0]);
        map.put(a[0],head);
        for (int i = 1; i < a.length; i++) {
            if(map.get(a[i])==null) map.put(a[i],new ListNode(a[i]));
        }
        for (int i = 0; i < a.length-1; i++) {
            map.get(a[i]).next=map.get(a[i+1]);
        }
        System.out.println(answer(head));
    }
    static boolean answer(ListNode head){
        ListNode k=head,m=head;
        while(k!=null&&k.next!=null){
            k=k.next.next;
            m=m.next;
            if(k==m) return true;
        }
        return false;
    }
    static class ListNode {
        String val;
        ListNode next = null;

        ListNode(String val) {
            this.val = val;
        }
    }
}
