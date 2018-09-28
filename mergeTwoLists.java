public class mergeTwoLists {
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
        mergeTwoLists list1=new mergeTwoLists();
        mergeTwoLists list2=new mergeTwoLists();
        list1.add(-10);
        list1.add(-9);
        list1.add(-4);
        list1.add(2);
        
        list2.add(-7);
        ListNode result=list1.answer(list1.head, list2.head);
        while(result.next!=null){
            System.out.println(result.val);
            result=result.next;
        }
        System.out.println(result.val);
    }
    public ListNode answer(ListNode l1, ListNode l2){
        ListNode a,b,t;
        if(l1==null) return l2;
        if(l2==null) return l1;
        a=l1;
        b=l2;
        if(a.val>b.val) {
            t=l1;
            l1=l2;
            l2=t;
            a=l1;
            b=l2;
        }
        while(true){
            if(a.next==null){
                while(a.next!=null){
                    a=a.next;
                }
                a.next=b;
                return l1;
            }
            else if(a.val<=b.val&&a.next.val>=b.val){
                t=a.next;
                a.next=b;
                if(b.next!=null){b=b.next;a.next.next=t;}
                else {
                    a.next.next=t;
                    return l1;
                }
                
            }
            else if(a.next.val<b.val){
                a=a.next;
            }
            else {
                return l1;
            }
        }
    }
}