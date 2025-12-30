package data_structure;

import java.util.LinkedList;

public class JavaQueue<E> {
    private final LinkedList<E> queue = new LinkedList<>();

    public void enqueue(E item) { queue.addLast(item); }

    public E dequeue()  {
        if (queue.isEmpty()) return null;
        return queue.removeFirst();
    }
}
