package rit.stu;

import rit.cs.Node;
import rit.cs.Stack;

/**
 * A stack implementation that uses a Node to represent the structure.
 *
 * @param <T> The type of data the stack will hold
 * @author RIT CS
 */
public class StackNode<T> implements Stack<T> {

    private Node<T> top;

    /**
     * Create an empty stack.
     */
    public StackNode() {
        this.top = new Node(0, null);
    }

    @Override
    public boolean empty() {
        return this.top.getNext() == null;
    }

    @Override
    public T pop() {
        assert !empty();
        T popped = this.top.getData();
        this.top = this.top.getNext();
        return popped;
    }

    @Override
    public void push(T element) {
        this.top = new Node(element, this.top);
    }

    @Override
    public T top() {
        assert !empty();
        return this.top.getData();
    }
}
