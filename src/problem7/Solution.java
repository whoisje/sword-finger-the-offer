package problem7;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author je
 * @Date 2021/10/16
 */
public class Solution {

    public static class Queue<E> {
        private final Stack<E> stack1 = new Stack<>();
        private final Stack<E> stack2 = new Stack<>();

        public void appendTail(E e) {
            stack1.push(e);
        }

        public E deleteHead() {
            if (stack2.isEmpty()) {
                if (stack1.isEmpty()) {
                    throw new EmptyStackException();
                }
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.appendTail("a");
        queue.appendTail("b");
        queue.appendTail("c");
        queue.appendTail("d");
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        queue.appendTail("e");
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
