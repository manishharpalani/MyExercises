package InterviewCake

import spock.lang.Specification

/**
 * Created by manishharpalani on 03/03/17.
 */
class Q9_BSTTest extends Specification {
    def "basic isBST"() {
        expect:
        Q9_BST.isBST(null)

        when:
        Q9_BST.BinaryTreeNode rootNode = new Q9_BST.BinaryTreeNode(8);
        rootNode.insertLeft(6)
        rootNode.insertRight(10)
        then:
        Q9_BST.isBST(rootNode)

        when:
        rootNode.left.value = 20
        then:
        !Q9_BST.isBST(rootNode)

        when:
        rootNode.value = 50
        then:
        !Q9_BST.isBST(rootNode)

    }

    def "left subtree has higher value"() {
        when:
        Q9_BST.BinaryTreeNode rootNode = new Q9_BST.BinaryTreeNode(8);
        rootNode.insertLeft(6).insertRight(12)
        rootNode.insertRight(10)
        then:
        !Q9_BST.isBST(rootNode)
    }
}
