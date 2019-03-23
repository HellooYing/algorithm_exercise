import java.util.List;

public class FindFirstCommonNode {
    //4.5min ok
    public static void main(String[] args) throws Exception {
        ListNode h1=new ListNode(1);
        ListNode h2=new ListNode(2);
        h2.next=new ListNode(5);
        ListNode a=new ListNode(4);
        h1.next=a;
        ListNode b=new ListNode(3);
        a.next=b;
        a=new ListNode(3);
        b.next=a;
        h2.next=a;
        ListNode r=a;
        b=new ListNode(3);
        a.next=b;
        a=new ListNode(9);
        b.next=a;
        b=new ListNode(6);
        a.next=b;
        a=new ListNode(0);
        b.next=a;
        h1=answer(h1,h2);
        if(h1==r) System.out.println("ok");
    }
    static ListNode answer(ListNode head1,ListNode head2){
        int i1=0,i2=0;
        ListNode h1=head1,h2=head2;
        while(h1!=null){
            i1++;
            h1=h1.next;
        }
        while(h2!=null){
            i2++;
            h2=h2.next;
        }
        int i=i1-i2;
        h1=head1;
        h2=head2;
        if(i>0){
            for(int j=0;j<i;j++){
                h1=h1.next;
            }
        }
        else{
            i=-i;
            for(int j=0;j<i;j++){
                h2=h2.next;
            }
        }
        while(h1!=h2){
            h1=h1.next;
            h2=h2.next;
        }
        return h1;
    }
}
