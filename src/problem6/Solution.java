package problem6;

import java.util.Arrays;

/**
 * @author je
 * @Date 2021/9/11
 */
public class Solution {

    public static Node buildTree(int[] pre, int[] middle) {
        if (pre.length == 0 || middle.length == 0) return null;
        Node node = new Node(pre[0]);
        for (int i = 0; i < middle.length; i++) {
            if (node.value == middle[i]) {
                node.left = buildTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(middle, 0, i));
                node.right = buildTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(middle, i + 1, middle.length));
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] middle = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        final Node node = buildTree(pre, middle);
        System.out.println(node);
    }

    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }


        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }
}
