class CustomStack {
    public int[] stack;
    public int index;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        index = 0;
    }
    
    public void push(int x) {
        if(index<stack.length){
            stack[index]=x;
            index++;
        }
    }
    
    public int pop() {
        if(index>0 ){
            index--;
            return stack[index];
        }
        else{
            return -1;
        }
    }
    
    public void increment(int k, int val) {
        if(k>stack.length){
            k = stack.length;
        }
        for(int i=0;i<k;i++){
            stack[i]+=val;
        }

    }
            
        
    
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
