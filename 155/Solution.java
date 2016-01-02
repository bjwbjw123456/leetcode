class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        if (min.isEmpty() || x<=min.peek()){
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        int tmp = stack.peek();
        stack.pop();
        if (tmp == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
