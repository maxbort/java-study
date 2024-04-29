package prob5;

public class MyStack2 {
	int top;    
    int size;    
    Object[] stack;
    public MyStack2(int size) {
        this.size = size;
        stack = new Object[size];
        top = -1;
    }
    
   public void resize() {
	   Object[] newStack;
	   newStack = new Object[size*2];
	   
	   for(int i = 0;i <size; i++) {
		   newStack[i] = stack[i];
	   }
	   stack = newStack;
	   size = size*2;
	   
   }
    
    public void push(Object item) {
    	if(top >= size-1) {
    		resize();
    	}
        stack[++top] = item;
     
    }
    public Object pop() throws MyStackException {
    	if(top ==-1) {
    		throw new MyStackException("Stack is Empty");
    	}
        Object result = stack[top];
        stack[top--] = "";
        return result;
    }
    
    
    
    
    public boolean isEmpty() {
    	if (top == -1) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}

