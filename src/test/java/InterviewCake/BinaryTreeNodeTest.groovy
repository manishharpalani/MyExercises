package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 03/03/17.
 */
class BinaryTreeNodeTest extends Specification {
    def "rightmost leaf get2ndLargest"() {
        when:
        Q10_2ndLargest.BinaryTreeNode root = new Q10_2ndLargest.BinaryTreeNode(10);
        root.insertRight(15)

        then:
        root.get2ndLargest() == root
    }

    def "basic get2ndLargest"() {
        when:
        Q10_2ndLargest.BinaryTreeNode root = new Q10_2ndLargest.BinaryTreeNode(10);
        Q10_2ndLargest.BinaryTreeNode secondLargest = root.insertLeft(5)

        then:
        root.get2ndLargest() == secondLargest
    }

    def "leaf tree get2ndLargest"() {
        when:
        Q10_2ndLargest.BinaryTreeNode root = new Q10_2ndLargest.BinaryTreeNode(10);
        root.get2ndLargest()

        then:
        thrown RuntimeException
    }
}
