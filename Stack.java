
public class Stack {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class LinkedStack {
        private Node head;
        private int count;

        public boolean isEmpty() {
            return head == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
            count++;
        }

        public Integer pop() {
            if (isEmpty()) {
                return null;
            }
            int top = head.data;
            head = head.next;
            count--;
            return top;
        }

        public Integer peek() {
            if (isEmpty()) {
                return null;
            }
            return head.data;
        }

        public int size() {
            return count;
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }

            Node current = head;
            while (current != null) {
                System.out.print(current.data);
                if (current.next != null) {
                    System.out.print(" ");
                    System.out.print("->");
                    System.out.print(" ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
       
        LinkedStack stack = new LinkedStack();

        stack.push(10);
        System.out.println("10 inserted");
        stack.push(20);
        System.out.println("20 inserted");
        stack.push(30);
        System.out.println("30 inserted");

        stack.display();
        System.out.println(stack.peek());

        printPopResult(stack.pop());
        stack.display();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        printPopResult(stack.pop());
        printPopResult(stack.pop());
        System.out.println(stack.isEmpty());
        printPopResult(stack.pop());
    }

    private static void printPopResult(Integer value) {
        if (value == null) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(value + " removed");
        }
    }
}
