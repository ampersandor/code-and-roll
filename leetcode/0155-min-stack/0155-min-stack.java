class MinStack {
    private List<int[]> stack;
    public MinStack() {
        this.stack = new ArrayList<>();
    }
    
    public void push(int val) {
        int min_val = this.stack.isEmpty() ? val : this.stack.get(this.stack.size() - 1)[1];
        this.stack.add(new int[]{val, Math.min(min_val, val)});
    }
    
    public void pop() {
        this.stack.remove(this.stack.size() - 1);
    }
    
    public int top() {
        return this.stack.isEmpty() ? -1 : this.stack.get(this.stack.size() - 1)[0];
    }
    
    public int getMin() {
        return this.stack.isEmpty() ? -1 : this.stack.get(this.stack.size() - 1)[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */