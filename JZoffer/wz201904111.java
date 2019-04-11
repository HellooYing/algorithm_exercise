import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class wz201904111 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        in.close();
        answer(n,m);
    }

    static void answer(int n,int m){
        ListNode head=new ListNode(1);
        ListNode node=head;
        for (int i = 1; i <n ; i++) {
            node.next=new ListNode(i+1);
            node=node.next;
        }
        node.next=head;
        ListNode last=node;
        node=head;
        int bs=1;
        while(node.next!=node){
            if(bs==m){
                System.out.print(node.val+" ");
                last.next=node.next;
                node=node.next;
                bs=1;
            }
            else{
                bs++;
                node=node.next;
                last=last.next;
            }
        }
        System.out.println();
        System.out.println(node.val);
    }

//    static void answer(int n,int m){
//        List<Integer> a=new ArrayList<>();
//        for (int i = 0; i <n ; i++) {
//            a.add(i+1);
//        }
//        int num=1;
//        int child=0;
//        while(a.size()>1){
//            if(child==a.size()) child=0;
//            if(num==m){
//                System.out.print(a.get(child)+" ");
//                a.remove(child);
//                num=1;
//            }
//            else{
//                child++;
//                num++;
//            }
//        }
//        System.out.println();
//        System.out.println(a.get(0));
//    }
}
