import java.util.Stack;

public class SortStack {
    public static void main(String[] args) throws Exception {
        Stack<Integer> s=new Stack<Integer>();
        s.push(1);s.push(122);s.push(3);s.push(23);s.push(4);
        answer(s);
        System.out.println(s);
    }
    static void answer(Stack<Integer> s){
        //7min no bug but too slow
        Stack<Integer> h=new Stack<Integer>();
        int i;
        while(!s.isEmpty()){
            i=s.pop();
            while(!h.isEmpty()&&h.peek()<i){
                s.push(h.pop());
            }
            h.push(i);
        }
        while(!h.isEmpty()) s.push(h.pop());
    }
}
