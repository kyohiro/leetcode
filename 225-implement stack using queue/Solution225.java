class MyStack {
    private List<Integer> array = new ArrayList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        array.add(x) ;
    }

    // Removes the element on top of the stack.
    public void pop() {
        array.remove(array.size() - 1);
    }

    // Get the top element.
    public int top() {
        return array.get(array.size() - 1);
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return array.isEmpty(); 
    }
}