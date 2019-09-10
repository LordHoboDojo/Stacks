
import java.util.Arrays;

public class ArrayStack<T>  {


    private Object[] stack;
    private int top;
    ArrayStack(){
        this.stack =  new Object[10];
        this.top = -1;
    }


    void push(T value) throws Exception {
       if (!this.isFull()) {
           stack[++top] = value;
       }
       else
        {
            throw new Exception("Stack is Full");
        }
    }

    @SuppressWarnings("unchecked")
    T pop() throws Exception {
        if(!this.isEmpty()) {
            return (T) stack[top--];
        }
        else {
            throw new Exception("Stack is empty");
        }
    }

    @SuppressWarnings("unchecked")
    public T peek() throws Exception {
           if (!this.isEmpty()){
               return (T) stack[top];
           }
           else
           {
               throw new Exception( "Stack is empty");
           }


    }


    int size() {
        return top +1;
    }


    public boolean isEmpty() {
       return top ==-1;
    }


    private boolean isFull() {
        return (top==9);
    }


    void clear() {
        top = -1;
    }
    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
      for (int i=top; i>0;i--) {
          result.append(stack[i]).append(",");
      }
      return result.toString();
    }
    public String ArrayToString()
    {
        return Arrays.toString(stack);
    }

    public int getTop() {
        return top;
    }
}
