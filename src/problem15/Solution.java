package problem15;

import java.util.Objects;

/**
 * @author je
 * @Date 2021/10/27
 */
public class Solution {

    public static Node lastKNode(Node node, int k) {
        Objects.requireNonNull(node, "node can not be null");
        if (k <= 0) throw new IllegalArgumentException("k can not be less than 1");
        Node pre = node;
        Node back = node;
        for (int i = 1; i < k; i++) {
            pre = pre.next;
            if (pre == null) {//说明链表的长度小于k
                throw new IllegalArgumentException("k cant not be bigger than link size");
            }
        }
        while (pre.next != null) {
            pre = pre.next;
            back = back.next;
        }
        return back;
    }

    public static class Node {
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        private int value;
        private Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node root = generateNode(6);
        System.out.println(lastKNode(new Node(1,null), -1));

        System.out.println(lastKNode(null, 0));
    }

    public static Node generateNode(int n) {
        Node node = new Node(1, null);
        Node root = node;
        for (int i = 2; i <= n; i++) {
            node.next = new Node(i, null);
            node = node.next;
        }
        return root;
    }


}
