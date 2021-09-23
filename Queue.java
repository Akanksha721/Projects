public class Queue{
    int max= 5;
    int front = -1, rear = -1;
    int a[] = new int[max];

    public void is_Empty(){
        if(front == rear){
            System.out.println("Queue is empty");
        }
    }

    public void is_Full(){
        if(rear == max-1){
            System.out.println("Queue is full");
        }
    }

    public void add(int item){
        if(rear == max-1){
            System.out.println("Queue is full");
        }
        else{
            a[++rear] = item;
        }
    }

    public void delete(){
        if(front == rear){
            System.out.println("Queue is empty");
        }
        else{
            int item = a[++front];
            System.out.println(item + " deleted");
        }
    }
    public void print(){
        int i;
        if(front == rear){
            System.out.println("Queue is empty");
        }
        for(i = front+1; i <= rear; i++){
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args){
        Queue q = new Queue();
        q.is_Empty();
        q.add(13);
        q.add(26);
        q.add(38);
        q.delete();
        q.add(71);
        q.add(86);
        q.is_Full();
        q.print();

    }
}
