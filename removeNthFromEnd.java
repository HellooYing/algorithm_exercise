public class removeNthFromEnd {
    ListNode head = null;
    class ListNode {
        int val;
        ListNode next=null;

        ListNode(int x) {
            this.val = x;
        }
    }
    public void add(int x){
        ListNode newNode=new ListNode(x);
        if(head==null){
            head = newNode;
            return;
        }
        ListNode tmp=head;
        while(tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=newNode;
    }
    public void delete(ListNode a){//delete a.next  if a.next==null,delete a
        if(a.next!=null){
            a.next=a.next.next;
        }
        else{
            a=null;
        }
    }

    public static void main(String[] args) throws Exception {
        removeNthFromEnd list=new removeNthFromEnd();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.answer(list.head, 4).next.val);
    }
    public ListNode answer(ListNode head, int n){
        ListNode a,b;
        b=null;
        a=head;
        int i=1;
        while(a.next!=null){
            if(b!=null) b=b.next;
            if(i==n) b=head;
            a=a.next;
            i++;
        }
        if(b==null) {
            if(head.next==null){
               head=null; 
            }
            else{
                head=head.next;
            }
        }
        else{
            delete(b);
        }
        return head;
    }
}