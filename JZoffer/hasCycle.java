/**
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 */
public class hasCycle {
    public boolean answer(ListNode head) {
        //判断链表是否有环的做法：快慢指针，一快一慢如果在快到达null之前相等就有环。
        if(head==null||head.next==null||head.next.next==null) return false;
        ListNode quick=head.next.next,slow=head.next;
        while(quick!=null&&quick!=slow){
            quick=quick.next;
            if(quick==null) return false;
            quick=quick.next;
            if(quick==null) return false;
            slow=slow.next;
            if(slow==quick) return true;
        }
        if(quick==null) return false;
        else return true;
    }
}