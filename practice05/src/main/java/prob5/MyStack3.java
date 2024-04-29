package prob5;

import java.lang.reflect.Array;

public class MyStack3<T> {
	private int top;    
    private int size;    
    
    private T[] stack;
    
//    @SuppressWarnings("unchecked")
//    public MyStack3(Class<?> klass, int size) {
//        this.size = size;
//        stack = (T[])new Object[size];
//        stack = (T[])Array.newInstance(klass, size);
//        top = -1;
//    }
//    
    @SuppressWarnings("unchecked")
    public MyStack3(int size) {
        this.size = size;
        stack = (T[])new Object[size];
        top = -1;
    }
    
   public void resize() {
	   T[] newStack;
	   newStack = (T[])new Object[size*2];
	   
	   for(int i = 0;i <size; i++) {
		   newStack[i] = stack[i];
	   }
	   stack = newStack;
	   size = size*2;
	   
   }
    
    public void push(T item) {
    	if(top >= size-1) {
    		resize();
    	}
        stack[++top] = item;
     
    }
    public T pop() throws MyStackException {
    	if(top ==-1) {
    		throw new MyStackException("Stack is Empty");
    	}
        T result = stack[top];
        stack[top--] = null;
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

