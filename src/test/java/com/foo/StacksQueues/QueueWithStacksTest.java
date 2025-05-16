package com.foo.StacksQueues;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import com.foo.StacksQueues._01_queue_with_stacks.QueueWithStacks;

public class QueueWithStacksTest {

    @Test
    public void testEnqueueAndPeek() {
        QueueWithStacks queue = new QueueWithStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.peek());
    }

    @Test
    public void testDequeue() {
        QueueWithStacks queue = new QueueWithStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
    }

    @Test
    public void testIsEmpty() {
        QueueWithStacks queue = new QueueWithStacks();
        assertTrue(queue.isEmpty());
        queue.enqueue(5);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testDequeueFromEmptyThrows() {
        QueueWithStacks queue = new QueueWithStacks();
        assertThrows(NoSuchElementException.class, queue::dequeue);
    }

}
