package CodingInterviewsBook

import spock.lang.Specification

/**
 * Created by manishharpalani on 12/02/17.
 */
class Q15_LinkedListTest extends Specification {
    def "test merge"() {
        given:
        Q15_LinkedList.Node node = new Q15_LinkedList.Node(7);
        node = new Q15_LinkedList.Node(5, node);
        node = new Q15_LinkedList.Node(3, node);
        Q15_LinkedList.Node list1 = new Q15_LinkedList.Node(1, node);

        node = new Q15_LinkedList.Node(8);
        node = new Q15_LinkedList.Node(6, node);
        node = new Q15_LinkedList.Node(4, node);
        Q15_LinkedList.Node list2 = new Q15_LinkedList.Node(2, node);

        when:
        Q15_LinkedList.Node merged = Q15_LinkedList.merge(list1, list2);


        then:
        int value = 0;
        for (Q15_LinkedList.Node cur = merged; cur != null; cur = cur.next) {
            ++value == cur.value;
        }
        value == 8
    }

    def "list1 null"() {
        given:
        Q15_LinkedList.Node list1 = null;

        Q15_LinkedList.Node node = new Q15_LinkedList.Node(8);
        node = new Q15_LinkedList.Node(6, node);
        node = new Q15_LinkedList.Node(4, node);
        Q15_LinkedList.Node list2 = new Q15_LinkedList.Node(2, node);

        when:
        Q15_LinkedList.Node merged = Q15_LinkedList.merge(list1, list2);


        then:
        int value = 2;
        for (Q15_LinkedList.Node cur = merged; cur != null; cur = cur.next) {
            value == cur.value;
            value +=2
        }
        value == 10
    }

    def "list2 null"() {
        given:
        Q15_LinkedList.Node node = new Q15_LinkedList.Node(7);
        node = new Q15_LinkedList.Node(5, node);
        node = new Q15_LinkedList.Node(3, node);
        Q15_LinkedList.Node list1 = new Q15_LinkedList.Node(1, node);

        Q15_LinkedList.Node list2 = null;

        when:
        Q15_LinkedList.Node merged = Q15_LinkedList.merge(list1, list2);


        then:
        int value = 1;
        for (Q15_LinkedList.Node cur = merged; cur != null; cur = cur.next) {
            value == cur.value;
            value +=2
        }
        value == 9
    }

    def "both lists null"() {
        given:
        Q15_LinkedList.Node list1 = null;
        Q15_LinkedList.Node list2 = null;

        when:
        Q15_LinkedList.Node merged = Q15_LinkedList.merge(list1, list2);


        then:
        int value = 0;
        for (Q15_LinkedList.Node cur = merged; cur != null; cur = cur.next) {
            value == cur.value;
            value +=2
        }
        value == 0
    }

}
