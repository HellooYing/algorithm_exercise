public class Clone {
    public static void main(String[] args) throws Exception {
        //18min bug是原始链表的最后一位多连next了
        RandomListNode a1=new RandomListNode(1);
        RandomListNode a2=new RandomListNode(2);
        RandomListNode a3=new RandomListNode(3);
        RandomListNode a4=new RandomListNode(4);
        RandomListNode a5=new RandomListNode(5);
        a1.next=a2;
        a2.next=a3;
        a3.next=a4;
        a4.next=a5;
        a1.random=a3;
        a2.random=a5;
        a4.random=a2;
        RandomListNode r=a1;
        while(r!=null){
            System.out.println();
            System.out.print(r);
            if(r.random!=null) {
                System.out.print(" "+r.random);
            }
            r=r.next;
        }
        System.out.println();
        a1=answer(a1);
        while(a1!=null){
            System.out.println();
            System.out.print(a1);
//            System.out.print(a1.label);
            if(a1.random!=null) {
                System.out.print(" "+a1.random);
            }
            a1=a1.next;
        }
    }
    static RandomListNode answer(RandomListNode pHead){
        if(pHead==null) return null;
        if(pHead.next==null){
            RandomListNode r=new RandomListNode(pHead.label);
            if(pHead.random==pHead){
                r.random=r;
            }
            return r;
        }
        RandomListNode a=pHead,b,c;

        while(a!=null){
            b=a.next;
            c=new RandomListNode(a.label);
            a.next=c;
            c.next=b;
            a=a.next.next;
        }
        a=pHead;
        b=pHead.next;
        while(b.next!=null){
            if(a.random!=null) b.random=a.random.next;
            a=a.next.next;
            b=b.next.next;
        }
        if(a.random!=null) b.random=a.random.next;
        a=pHead;
        b=pHead.next;
        pHead=a;
        while(b.next!=null){
            a.next=a.next.next;
            b.next=b.next.next;
            b=b.next;
            a=a.next;
        }
        a.next=null;
        return pHead;
    }
}
