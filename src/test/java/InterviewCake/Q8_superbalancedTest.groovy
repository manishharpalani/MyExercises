package InterviewCake

import com.sun.source.tree.BinaryTree
import spock.lang.Specification

/**
 * Created by manishharpalani on 02/03/17.
 */
class Q8_superbalancedTest extends Specification {
    def "test superbalanced"() {
        when:
        Q8_superbalanced.BinaryTreeNode rootNode = new Q8_superbalanced.BinaryTreeNode(8);
          rootNode.insertLeft(0);

        then:
//        Q8_superbalanced.getMaxDepth(null) == 0
//        Q8_superbalanced.getMinDepth(null) == 0
        Q8_superbalanced.isSuperBalanced(null) == true

//        Q8_superbalanced.getMaxDepth(rootNode.left) == 1
//        Q8_superbalanced.getMinDepth(rootNode.left) == 1
        Q8_superbalanced.isSuperBalanced(rootNode.left) == true

//        Q8_superbalanced.getMaxDepth(rootNode) == 2
//        Q8_superbalanced.getMinDepth(rootNode) == 1
        Q8_superbalanced.isSuperBalanced(rootNode) == true

        when:
        rootNode.insertRight(10).insertLeft(9);

        then:
//        Q8_superbalanced.getMinDepth(rootNode) == 2
//        Q8_superbalanced.getMaxDepth(rootNode) == 3
        Q8_superbalanced.isSuperBalanced(rootNode) == true
    }

    def "test unbalanced"() {
        when:
        Q8_superbalanced.BinaryTreeNode rootNode = new  Q8_superbalanced.BinaryTreeNode(8);
        rootNode.insertLeft(6).insertLeft(2).insertLeft(1)
        rootNode.insertRight(100)

        then:
//        Q8_superbalanced.getMinDepth(rootNode) == 2
//        Q8_superbalanced.getMaxDepth(rootNode) == 4
        !Q8_superbalanced.isSuperBalanced(rootNode)
    }

/*    def "test getMinDepth"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }

    def "test getMaxDepth"() {
        given:

        when:
        // TODO implement stimulus
        then:
        // TODO implement assertions
    }
    */
}
