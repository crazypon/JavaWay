package CollectionsFramework;

import java.util.*;

public class QueueTutorial {
    /*
    we create a queue using LinkedList
    we create a stack using Deque
    we create a double-ended queue (deque) using ArrayDeque

    follow the naming convention, don't add to queue, offer to it, otherwise you might get
    an exception
     */
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q.peek()); // getting, but not removing
        System.out.println(q.poll()); // getting and removing

        System.out.println();
        System.out.println("Stack Demo: ");
        // *** IMPLEMENTING Stack ***
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }

        System.out.println();
        System.out.println("Deque Demo:");

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        System.out.println(deque);

        deque.pollFirst();
        System.out.println(deque.peekFirst());
    }
}
