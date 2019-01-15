import java.util.*;

public class Clone {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public static void main(String[] args) throws Exception {
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
        RandomListNode a=new Clone().answer(a1);
        RandomListNode t=a;
        while(t!=null){
            if(t.random!=null) System.out.println(t.label+" "+t.random.label);
            else System.out.println(t.label+" #");
            t=t.next;
        }        
    }

    public RandomListNode answer(RandomListNode pHead){
        if(pHead==null) return null;
        RandomListNode t=pHead;
        RandomListNode t1;
        while(t!=null){
            t1=new RandomListNode(t.label);
            t1.next=t.next;
            t.next=t1;
            t=t.next.next;
        }
        t=pHead;
        while(t!=null){
            if(t.random!=null) t.next.random=t.random.next;
            t=t.next.next;
        }
        t=pHead;
        t1=pHead.next;
        while(t!=null){
            RandomListNode mynode=t.next;
            t.next=mynode.next;
            if(mynode.next!=null) mynode.next=mynode.next.next;
            t=t.next;
        }
        return t1;
    }
}