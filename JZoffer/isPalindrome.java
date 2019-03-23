public class isPalindrome {
    //20min, LinkedList always infinite loop
    public static void main(String[] args) throws Exception {
        ListNode head=new ListNode(1);
        ListNode a=new ListNode(2);
        head.next=a;
        ListNode b=new ListNode(3);
        a.next=b;
        a=new ListNode(4);
        b.next=a;
        b=new ListNode(3);
        a.next=b;
        a=new ListNode(2);
        b.next=a;
        b=new ListNode(1);
        a.next=b;
        a=new ListNode(0);
        b.next=a;
        System.out.println(answer(head));
    }
    static boolean answer(ListNode head){
        if(head==null||head.next==null) return true;
        int i=1;
        int m;
        ListNode a=head,b=head,c,d=head;
        while(a.next!=null){
            a=a.next;
            i++;
        }//a为尾部节点
        if(i==2) {
            if(head.val==a.val) return true;
            else return false;
        }
        if(i%2==0){
            m=i/2;
            for(int j=0;j<m;j++){
                b=b.next;
            }//b为中间偏后节点
            c=reverse(b);//c为尾部节点
            while(c!=b){
                if(c.val!=d.val) return false;
                c=c.next;
                d=d.next;
            }
            if(c.val==d.val) return true;
            else return false;
        }
        else{
            m=(int)Math.floor(i/2);
            for(int j=0;j<m;j++){
                b=b.next;
            }//b为中间偏后节点
            c=reverse(b);
            while(c!=b){
                if(c.val!=d.val) return false;
                c=c.next;
                d=d.next;
            }
            return true;
        }
    }
    static ListNode reverse(ListNode h){
        if(h.next==null) return h;
        ListNode p,q;
        p=h.next;
        q=p.next;
        while(h!=null&&p!=null&&q!=null){
            p.next=h;
            h=p;
            p=q;
            q=q.next;
        }
        p.next=h;
        return p;
    }
}
