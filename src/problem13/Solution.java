package problem13;

/**
 * @author je
 * @Date 2021/10/25
 */
public class Solution {

    public static void deleteNode(Node head, Node nodeNeedDelete) {
        if (head == null || nodeNeedDelete == null) {
            return;
        }
        if (head.next == null) {//链表长度为1
            head = null;// java这里没啥作用
            return;
        }
        if (nodeNeedDelete.next == null) {//nodeNeedDelete是的尾节点
            Node next = head.next;
            while (next.next != nodeNeedDelete) {
                next = next.next;
            }
            next.next = null;
            return;
        }
        Node temp = nodeNeedDelete.next;
        nodeNeedDelete.setValue(temp.getValue());
        nodeNeedDelete.setNext(temp.getNext());
        temp = null;
    }

    public static class Node {
        private Node next;
        private int value;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(3);
        Node node5 = new Node(4);
        node4.next = node5;
        node3.next = node4;
        node2.next = node3;
        node1.next = node2;
        deleteNode(null, null);
        deleteNode(node1, node3);
        Node singleNode = new Node(0);
        deleteNode(singleNode, singleNode);
        System.out.println(node1);
        System.out.println(singleNode);
    }
}
