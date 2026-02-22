public class BasicLinkedListOperations {
    public static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    public static Node listInsert(Node head, Node x) {
        x.next = head;
        return x;
    }

    public static Node listSearch(Node head, int key) {
        Node curr = head;
        
        while (curr != null) {
            if (curr.key == key) return curr;
            curr = curr.next;
        }
        return null;
    }

    public static Node listDelete(Node head, Node x) {
        if (head == null) return null; 

        if (head == x) return head.next;
        
        Node curr = head;
        while (curr.next != null && curr.next != x) {
            curr = curr.next;
        }

        if (curr.next == x) {
            curr.next = x.next;
        }

        return head;
    }

    // populate method for adding nodes
    public static Node populate (Node head, int[] keys) {
        for (int key : keys) {
            head = listInsert(head, new Node(key));
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;

        // populate linked list
        head = populate(head, new int[]{1, 2, 3});

        Node curr = head;

        // move through list to print
        while (curr != null) {
            System.out.println(curr.key);
            curr = curr.next;
        }

        Node found1 = listSearch(head, 2); // found
        Node found2 = listSearch(head, 4); // not found
       
        System.out.println("Found: " + found1.key);
        System.out.println("Not found: " + found2);

        Node deleteNode = listSearch(head, 1);
        Node delete = listDelete(head, deleteNode);

        // move through list to print
        curr = head;
        while (curr != null) {
            System.out.println(curr.key);
            curr = curr.next;
        }

    }
}
