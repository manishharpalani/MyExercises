package InterviewCake;

import com.sun.tools.classfile.ConstantPool;

import java.util.Stack;

/**
 * Created by manishharpalani on 02/03/17.
 */
public class Q8_superbalanced {
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
    }

    static class StackItem {
        BinaryTreeNode node;
        int depth;

        public StackItem(BinaryTreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static boolean isSuperBalanced(BinaryTreeNode node) {
        if (node == null)
            return true;

        Stack<StackItem> nodeStack = new Stack<>();
        nodeStack.add(new StackItem(node, 1));

        int minDepth = Integer.MAX_VALUE; // TODO: Ensure appropriate const.
        int maxDepth = 0;


        while (!nodeStack.isEmpty()) {
            StackItem cur = nodeStack.pop();
            if (cur.node.left == null && cur.node.right == null) {
                maxDepth = Math.max(maxDepth, cur.depth);
                minDepth = Math.min(minDepth, cur.depth);
            }

            if (cur.node.left != null) {
                nodeStack.add(new StackItem(cur.node.left, cur.depth + 1));
            }
            if (cur.node.right != null) {
                nodeStack.add(new StackItem(cur.node.right, cur.depth + 1));
            }
        }

        System.out.format("maxDepth=%d minDepth=%d\n", maxDepth, minDepth);

        return (maxDepth - minDepth <= 1);
    }

/*
    public static boolean isSuperBalanced(BinaryTreeNode node) {

        int max = getMaxDepth(node);
        int min = getMinDepth(node);

        return (max - min <= 1);
    }

    public static int getMinDepth(BinaryTreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = getMinDepth(node.left) + 1;
        int rightDepth = getMinDepth(node.right) + 1;
        return Math.min(leftDepth, rightDepth);
    }

    public static int getMaxDepth(BinaryTreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = getMaxDepth(node.left) + 1;
        int rightDepth = getMaxDepth(node.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }*/



}
