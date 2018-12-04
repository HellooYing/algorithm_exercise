import java.util.Stack;

public class queueByStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //重新想，push的时候是直接push到栈1，pop想pop栈1的栈底，所以全扔进栈2再pop。如果栈2非空就应该一直pop栈2
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()) stack2.push(stack1.pop());
            return stack2.pop();
        }
        else return stack2.pop();
    }
}