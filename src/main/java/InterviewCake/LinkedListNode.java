package InterviewCake;

/**
 * Created by manishharpalani on 16/02/17.
 * Delete a node from a singly-linked list ↴ , given only a variable pointing to that node.
 * The input could, for example, be the variable b below:
 * LinkedListNode a = new LinkedListNode("A");
 * LinkedListNode b = new LinkedListNode("B");
 * LinkedListNode c = new LinkedListNode("C");
 *
 * a.next = b;
 * b.next = c;
 */
public class LinkedListNode {

    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
    }

    public static void deleteNode(LinkedListNode node) {
        if (node == null)
            return;

        //LinkedListNode toDelete = node;
        if (node.next != null) {
            node.value = node.next.value;
            node.next = node.next.next;
        }

    }

    public static boolean containsCycle(LinkedListNode node) {
        LinkedListNode slow = node;
        LinkedListNode fast = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;


    }


}