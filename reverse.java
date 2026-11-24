/** Solutions to the four stack questions using a linked-list stack. */
public class reverse {

    /** Custom Stack implementation: the head node is the top of the stack. */
    static class LinkedStack<T> {
        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> top;

        void push(T data) {
            Node<T> newNode = new Node<>(data);
            newNode.next = top;
            top = newNode;
        }

        T pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack underflow");
            }
            T data = top.data;
            top = top.next;
            return data;
        }

        boolean isEmpty() {
            return top == null;
        }

        // Question 4: slow moves one node while fast moves two nodes.
        T findMiddle() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }

            Node<T> slow = top;
            Node<T> fast = top;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow.data;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder("top -> ");
            for (Node<T> current = top; current != null; current = current.next) {
                result.append(current.data);
                if (current.next != null) {
                    result.append(" -> ");
                }
            }
            return result.toString();
        }
    }

    // Question 1: push all characters, then pop them to get reverse order.
    static String reverseString(String text) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (char character : text.toCharArray()) {
            stack.push(character);
        }

        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        return answer.toString();
    }

    // Question 2: popped order must match the original string for a palindrome.
    static boolean isPalindrome(String text) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (char character : text.toCharArray()) {
            stack.push(character);
        }

        for (int index = 0; index < text.length(); index++) {
            if (text.charAt(index) != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Question 3: moving every element to another stack reverses the order.
    static <T> LinkedStack<T> reverseStack(LinkedStack<T> original) {
        LinkedStack<T> reversed = new LinkedStack<>();
        while (!original.isEmpty()) {
            reversed.push(original.pop());
        }
        return reversed;
    }

    public static void main(String[] args) {
        String text = "Hello";
        System.out.println("1. Reverse of " + text + ": " + reverseString(text));

        String palindrome = "madam";
        String notPalindrome = "java";
        System.out.println("2. " + palindrome + " is a palindrome: " + isPalindrome(palindrome));
        System.out.println("   " + notPalindrome + " is a palindrome: " + isPalindrome(notPalindrome));

        LinkedStack<Integer> original = new LinkedStack<>();
        original.push(1);
        original.push(2);
        original.push(3);
        original.push(4);
        System.out.println("3. Original stack: " + original);
        LinkedStack<Integer> reversed = reverseStack(original);
        System.out.println("   Reversed stack: " + reversed);

        LinkedStack<Integer> middleStack = new LinkedStack<>();
        middleStack.push(10);
        middleStack.push(20);
        middleStack.push(30);
        middleStack.push(40);
        middleStack.push(50);
        System.out.println("4. Stack: " + middleStack);
        System.out.println("   Middle element: " + middleStack.findMiddle());
    }
}
