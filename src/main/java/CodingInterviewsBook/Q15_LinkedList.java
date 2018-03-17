package CodingInterviewsBook;

/**
 * Created by manishharpalani on 12/02/17.
 */
public class Q15_LinkedList {
    private static class Node {
        Node next;
        int value;

        private Node(int value) {
            this.value = value;
            next = null;
        }
        private Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    public static Node getSmaller(Node node1, Node node2) {
        return (node1.value < node2.value) ? node1 : node2;
    }

    public static Node getLarger(Node node1, Node node2) {
        return (node1.value < node2.value) ? node2 : node1;
    }

    public static Node merge(Node list1, Node list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        Node merged = getSmaller(list1, list2);
        Node mergedLast = merged;
        Node node1 = getLarger(list1, list2);
        Node node2 = merged.next;


        while (node1 != null && node2 != null) {
            mergedLast.next = getSmaller(node1, node2);
            node1 = getLarger(node1, node2);
            node2 = mergedLast.next.next;
            mergedLast = mergedLast.next;
        }
        if (node1 != null)
            mergedLast.next = node1;
        if (node2 != null)
            mergedLast.next = node2;

        return merged;
    }

    /*
    public static Node merge(Node list1, Node list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        Node merged = null;
        if (list1.value < list2.value) {
            merged = list1;
            list1 = list1.next;
        }
        else {
            merged = list2;
            list2 = list2.next;
        }

        Node mergedLast = merged;

        while (list1 != null && list2 != null) {

            if (list1.value < list2.value) {
                mergedLast.next = list1;
                list1 = list1.next;
            }
            else {
                mergedLast.next = list2;
                list2 = list2.next;
            }
            mergedLast = mergedLast.next;
        }
        if (list1 != null)
            mergedLast.next = list1;
        if (list2 != null)
            mergedLast.next = list2;
        return merged;
    }*/


}
