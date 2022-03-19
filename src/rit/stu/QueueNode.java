package rit.stu;

import rit.cs.Node;
import rit.cs.Queue;

/**
 * A queue implementation that uses a Node to represent the structure.
 *
 * @param <T> The type of data the queue will hold
 * @author RIT CS
 */
public class QueueNode<T> implements Queue<T> {

    private Node<T> front;
    private Node<T> back;

    /**
     * Create an empty queue.
     */
    public QueueNode() {
        this.front = null;
        this.back = null;
    }

    @Override
    public T back() {
        assert !empty();
        return this.back.getData();
    }

    @Override
    public T dequeue() {
        assert !empty();
        T removed = this.front.getData();
        this.front = this.front.getNext();
        if (empty()) {
            this.back = null;
        }
        return removed;
    }

    @Override
    public boolean empty() {
        return this.front == null;
    }

    @Override
    public void enqueue(T element) {
        Node<T> newNode = new Node(element, null);
        if (empty()) {
            this.front = newNode;
        }
        else {
            this.back.setNext(newNode);
        }
        this.back = newNode;
    }

    @Override
    public T front() {
        assert !empty();
        return this.front.getData();
    }
}
