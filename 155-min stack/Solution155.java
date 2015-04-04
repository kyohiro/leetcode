public class Solution155 {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x)
            minStack.push(x);
    }

    public void pop() {
        int top = stack.peek();
        if (top == minStack.peek())
            minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek(); 
    }
}
