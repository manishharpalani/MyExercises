package InterviewCake

import spock.lang.Specification
import InterviewCake.Q24_ReverseList.LinkedListNode
/**
 * Created by manishharpalani on 10/04/17.
 */
class Q24_ReverseListTest extends Specification {
    def "test reverse"() {
        when:
        LinkedListNode list = null;
        then:
        Q24_ReverseList.reverse(list) == null

        when:
        LinkedListNode oneNode = new LinkedListNode(5)
        LinkedListNode rev1Node = Q24_ReverseList.reverse(oneNode)

        then:
        rev1Node.value == 5
        rev1Node.next == null


        when:
        LinkedListNode twoNode = new LinkedListNode(10)
        twoNode.next = oneNode
        LinkedListNode rev2Nodes = Q24_ReverseList.reverse(twoNode)

        then:
        rev2Nodes.value == 5
        rev2Nodes.next.value == 10
        rev2Nodes.next.next == null
    }
}
