public class Palidrome {
    public static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    public static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        Node prev;
        Node temp;

        // find middle, slow moves one step, fast moves two
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half from slow
        prev = slow;
        slow = slow.next;
        prev.next = null; // half the list
        while (slow != null) {
            temp = slow.next;
            slow.next = prev; // reverse pointer
            prev = slow;
            slow = temp;
        }

        // compare first half with reversed second half
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.key != slow.key) return false; // does not match = not palindrome
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(head)); // true

        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(20);
        head.next.next.next = new Node(10);
        System.out.println(isPalindrome(head)); // true

        head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(17);
        System.out.println(isPalindrome(head)); // false
    }



}
