package data_structure;

import java.util.ArrayList;
import java.util.List;

public class JavaStack<E> {
    private final List<E> stack = new ArrayList<>();

    public void push(E item) { stack.add(item); }

    public E pop() {
        if (stack.isEmpty()) return null;

        E obj;
        obj = peek();
        stack.remove(size() - 1);

        return obj;
    }

    public int size() { return stack.size(); }

    public E peek() {
        return stack.get(stack.size() - 1);
    }
}
