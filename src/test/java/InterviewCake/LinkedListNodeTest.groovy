package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 16/02/17.
 */
class LinkedListNodeTest extends Specification {
    def "test deleteNode"() {
        given:
        LinkedListNode a = new LinkedListNode("A");
        LinkedListNode b = new LinkedListNode("B");
        LinkedListNode c = new LinkedListNode("C");

        a.next = b;
        b.next = c;
        when:
        LinkedListNode.deleteNode(b)
        then:
        a.next.value == c.value
    }


    def "containsCycle 1 node"() {
        given:
        LinkedListNode a = new LinkedListNode("A");

        when:
        a.next = a;
        then:
        LinkedListNode.containsCycle(a)

        when:
        a.next = null
        then:
        !LinkedListNode.containsCycle(a)
    }

    def "containsCycle 2 node"() {
        given:
        LinkedListNode a = new LinkedListNode("A");
        LinkedListNode b = new LinkedListNode("B");

        when:
        a.next = b;
        b.next = a;
        then:
        LinkedListNode.containsCycle(a)

        when:
        b.next = null;
        then:
        !LinkedListNode.containsCycle(a)

    }

    def "containsCycle 3 node"() {
        given:
        LinkedListNode a = new LinkedListNode("A");
        LinkedListNode b = new LinkedListNode("B");
        LinkedListNode c = new LinkedListNode("C");

        when:
        a.next = b;
        b.next = c;
        c.next = a
        then:
        LinkedListNode.containsCycle(a)

        when:
        c.next = b
        then:
        LinkedListNode.containsCycle(a)

        when:
        c.next = null
        then:
        !LinkedListNode.containsCycle(a)
    }
}
