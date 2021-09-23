public class Stack {
    static final int max = 1000;
    int top = -1;
    int a[] =new int[max];

    boolean is_empty(){
        if(top == 0){
            return true;
        }
        return false;
    }
    public void push(int item){
        if(top >= (max- 1)){
            System.out.println("Stack is full");
        }
        a[++top] = item;
        System.out.println("Item is added into stack");
    }

    public void pop(){
        if(top < 0){
            System.out.println("Stack is empty");
        }
        int item = a[top--];
        System.out.println(item + "is removed from stack");
    }

    public void peek(){
        if(top < 0){
            System.out.println("Stack is empty");
        }
        else{
            int item = a[top];
            System.out.println(item + "is at top of stack");
        }
    }

    public static void main(String[] args){
        Stack s = new Stack();
        s.is_empty();
        s.push(23);
        s.push(77);
        s.peek();
        s.push(28);
        s.pop();
    }
}
