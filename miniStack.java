import java.util.Stack;

public class miniStack {
    Stack<Integer> data=new Stack<Integer>();
    Stack<Integer> x=new Stack<Integer>();
    public void push(int node) {
        data.push(node);
        if(x.empty()) x.push(node);
        else if(x.peek()>node) x.push(node);
    }
    
    public void pop() {
        int a=data.pop();
        if(a==x.peek()) x.pop();
    }
    
    public int min() {
        return x.peek();
    }
}