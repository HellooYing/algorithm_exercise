public class LinkedListDivision {
    public static void main(String[] args) throws Exception {
        //10min, forget to set null at the end
        ListNode head=new ListNode(1);
        ListNode a=new ListNode(3);
        head.next=a;
        ListNode b=new ListNode(2);
        a.next=b;
        a=new ListNode(1);
        b.next=a;
        b=new ListNode(4);
        a.next=b;
        a=new ListNode(6);
        b.next=a;
        b=new ListNode(3);
        a.next=b;
        head=answer(head,3);
        while(head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    static ListNode answer(ListNode head,int i){
        ListNode as=null,bs=null,cs=null,ae=null,be=null,ce=null,q=head;
        while(q!=null){
            if(q.val<i){
                if(as==null){
                    as=q;
                    ae=q;
                }
                else{
                    ae.next=q;
                    ae=ae.next;
                }
            }
            else if(q.val==i){
                if(bs==null){
                    bs=q;
                    be=q;
                }
                else{
                    be.next=q;
                    be=be.next;
                }
            }
            else if(q.val>i){
                if(cs==null){
                    cs=q;
                    ce=q;
                }
                else{
                    ce.next=q;
                    ce=ce.next;
                }
            }
            q=q.next;
        }
        ae.next=bs;
        be.next=cs;
        ce.next=null;
        return as;
    }
}
