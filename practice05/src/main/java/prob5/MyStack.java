package prob5;

public class MyStack {
	int top;    
    int size;    
    String[] stack;
    public MyStack(int size) {
        this.size = size;
        stack = new String[size];
        top = -1;
    }
    
   public void resize() {
	   String[] newStack;
	   newStack = new String[size*2];
	   
	   for(int i = 0;i <size; i++) {
		   newStack[i] = stack[i];
	   }
	   stack = newStack;
	   size = size*2;
	   
   }
    
    public void push(String item) {
    	if(top >= size-1) {
    		resize();
    	}
        stack[++top] = item;
     
    }
    public String pop() throws MyStackException {
    	if(top ==-1) {
    		throw new MyStackException("Stack is Empty");
    	}
        String result = stack[top];
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

