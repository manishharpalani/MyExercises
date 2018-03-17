package InterviewCake;

/**
 * Created by manishharpalani on 03/03/17.
 */
public class Q10_2ndLargest {
    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }

        public BinaryTreeNode get2ndLargest() {
            if (isLeaf(this))
                throw new RuntimeException("tree is a leaf - no 2ndLargest");

            if (isLeaf(right))
                return this;

            if (right != null)
                return right.get2ndLargest();
            else //if (left != null) {
                return left.getLargest();

        }

        public BinaryTreeNode getLargest() {
            if (right == null)
                return this;

            return right.getLargest();
        }

        public static boolean isLeaf(BinaryTreeNode node) {
            return (node != null && node.left == null && node.right == null);
        }
    }


}
