public class LinkedList {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            this.data = d;
            next = null;
        }
    }
    public void push(int new_data){
        Node new_node = new Node(new_data);

        if(head == null)
        {
            head = new Node(new_data);
            head.next = null;
        }

        Node last = head;
        while(last.next != null){
            last = last.next;
        }
        last.next = new_node;
    }

    public void insertAfter(Node prev_node, int new_data){
        Node new_node = new Node(new_data);
        if(prev_node == null){
            System.out.println("Previous node can't be null");
        }
        new_node.next = prev_node.next;

        prev_node.next = new_node;
    }

    public void delete(int data){
        Node temp = head, prev = null;

        if(temp == null){
            System.out.println("Linkedlist is empty");
        }

        if(temp!= null && temp.data == data){
            head = temp.next;
        }

        while(temp!= null && temp.data != data){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
    }
    public void search(Node head, int data){
        Node current = head;
        while(current != null) {
            if (current.data == data) {
                System.out.println("Data found");
            }

            current = current.next;
        }
        //System.out.println("Data not found");
    }

    public void print() {
        Node n = head;
        while (n != null) {

            System.out.println(n.data);
            n = n.next;
        }
    }


    public static void main(String[] args){
        LinkedList llist = new LinkedList();

        llist.head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        llist.head.next = second;
        second.next = third;
        llist.push(40);
        llist.insertAfter(llist.head.next,25);
        llist.print();
        llist.delete(30);
        llist.print();
        llist.search(llist.head, 25);
    }
}
