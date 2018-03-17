package InterviewCake;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by manishharpalani on 03/03/17.
 */
public class Q9_BST {
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

        static int prevValue = Integer.MIN_VALUE;

        public boolean inOrder() {
            if (right == null && left == null) {
                if (value < prevValue)
                    return false;

                prevValue = value;
                return true;
            }

            if (left != null && !left.inOrder() )
                return false;

            if (value < prevValue)
                return false;

            prevValue = value;

            if (right != null && !right.inOrder())
                return false;

            return true;
        }
    }

    public static boolean isBST(BinaryTreeNode tree) {
        if (tree == null)
            return true;

        List<Integer> values = new ArrayList<>();
        return tree.inOrder();

//        int lastVal = values.get(0);
//        for (int val: values) {
//            if (val < lastVal)
//                return false;
//        }
//        return true;
    }

    static class NodeRange {
        int min;
        int max;
        BinaryTreeNode node;


        public NodeRange(BinaryTreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }

        boolean valid(BinaryTreeNode node) {
            boolean valid = (node.value >= min && node.value <= max);
            if (!valid) {
                System.out.println("Failed: " + node.value + toString());
            }
            return valid;
        }


        @Override
        public String toString() {
            return "Range{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    };

//    public static boolean isBST(BinaryTreeNode tree) {
//        if (tree == null)
//            return true;
//
//        Stack<NodeRange> nodeStack = new Stack<>();
//        nodeStack.add(new NodeRange(tree, Integer.MIN_VALUE, Integer.MAX_VALUE));
//
//        while (!nodeStack.empty()) {
//            NodeRange cur = nodeStack.pop();
//
//            if (!cur.valid(cur.node))
//                return false;
//
//            if (cur.node.left != null) {
//                nodeStack.add(new NodeRange(cur.node.left, cur.min, cur.node.value));
//            }
//
//            if (cur.node.right != null) {
//                nodeStack.add(new NodeRange(cur.node.right, cur.node.value, cur.max));
//            }
//        }
//        return true;
//    }


    static class Range {
        int min;
        int max;

        public Range(int min, int max) {
            this.min = min;
            this.max = max;
        }

        boolean valid(BinaryTreeNode node) {
            boolean valid = (node.value >= min && node.value <= max);
            if (!valid) {
                System.out.println("Failed: " + node.value + toString());
            }
            return valid;
        }


        @Override
        public String toString() {
            return "Range{" +
                    "min=" + min +
                    ", max=" + max +
                    '}';
        }
    };

    public static boolean isBSTrecursive(BinaryTreeNode tree) {
        return inRange(tree, new Range(Integer.MIN_VALUE , Integer.MAX_VALUE));
    }

    public static boolean inRange(BinaryTreeNode tree, Range range) {
        if (tree == null)
            return true;

        if (!range.valid(tree))
            return false;

        return (inRange(tree.left, new Range(range.min, tree.value))
                && inRange(tree.right, new Range(tree.value, range.max)));
    }
}
