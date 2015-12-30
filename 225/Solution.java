class MyStack {
    private List<Integer> stack = new ArrayList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        stack.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int l = stack.size();
        if (l>0)
            stack.remove(l-1);
    }

    // Get the top element.
    public int top() {
        int l = stack.size();
        int r = stack.get(l-1);
        return r;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}