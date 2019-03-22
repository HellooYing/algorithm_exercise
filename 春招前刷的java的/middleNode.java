public class middleNode {
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
        middleNode list1=new middleNode();
        list1.add(-10);
        list1.add(-9);
        list1.add(-4);
        list1.add(2);
        list1.add(20);
        ListNode result=list1.answer(list1.head);
        while(result.next!=null){
            System.out.println(result.val);
            result=result.next;
        }
        System.out.println(result.val);
    }
    public ListNode answer(ListNode head){
        if(head==null) return head;
        ListNode a=head,b=head;
        while(true){
            if(a.next==null) break;
            else if(a.next.next==null) {b=b.next;break;}
            else {a=a.next.next;b=b.next;continue;}
        }
        return b;
    }
}