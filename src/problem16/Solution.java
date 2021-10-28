package problem16;

/**
 * @author je
 * @Date 2021/10/27
 */
public class Solution {

    public static Node reverseLink(Node head) {
        if (head == null) return null;
        if (head.next == null) return head;
        Node reserveHead = null;
        Node node = head;
        Node pre = null;
        while (node != null) {
            Node pNext = node.next;
            if (pNext == null) {
                reserveHead = node;
            }
            node.next = pre;

            pre = node;
            node = pNext;
        }
        return reserveHead;

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
        final Node node = generateNode(6);
        System.out.println(reverseLink(node));
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
