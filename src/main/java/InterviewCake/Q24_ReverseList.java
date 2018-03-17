package InterviewCake;

/**
 * Created by manishharpalani on 10/04/17.
 Hooray! It's opposite day. Linked lists go the opposite way today.
 Write a function for reversing a linked list ↴ . Do it in-place ↴ .


 Here's a sample linked list node class: */
public class Q24_ReverseList {

/*
 Your function will have one input: the head of the list.

 Your function should return the new head of the list.
 */
    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    static public LinkedListNode reverse(LinkedListNode list) {
        if (list == null)
            return null;

        LinkedListNode cur = list;
        LinkedListNode reversed = null;

//        LinkedListNode reversed = list;
//        LinkedListNode cur = list.next;
//        list.next = null;

        while(cur != null) {
            LinkedListNode remaining = cur.next;
            cur.next = reversed;

            reversed = cur;
            cur = remaining;
        }

        return reversed;
    }

}
