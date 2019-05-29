package org.bohdanrakov.effectivejava;

import java.util.Arrays;

public class Stack {

    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    public static final String STACK_IS_EMPTY_MESSAGE = "Stack is empty";
    private Object[] elements;
    private int size = 0;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new RuntimeException(STACK_IS_EMPTY_MESSAGE);
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
