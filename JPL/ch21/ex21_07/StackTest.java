package ch21.ex21_07;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class StackTest {

    @Test
    public void testPushPop() {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(stack.pop(), (Integer) 5);
        assertEquals(stack.pop(), (Integer) 4);
        assertEquals(stack.pop(), (Integer) 3);
        assertEquals(stack.pop(), (Integer) 2);
        assertEquals(stack.pop(), (Integer) 1);

        try {
            stack.pop();
            fail();
        } catch (EmptyStackException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testPeek() {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(stack.peek(), (Integer) 5);
    }

    @Test
    public void testEmpty() {

        Stack<Integer> stack = new Stack<Integer>();

        assertTrue(stack.empty());

        stack.push(1);
        assertFalse(stack.empty());

        stack.pop();
        assertTrue(stack.empty());
    }

    @Test
    public void testSearch() {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertTrue(stack.search(5) == 1);
        assertTrue(stack.search(4) == 2);
        assertTrue(stack.search(3) == 3);
        assertTrue(stack.search(2) == 4);
        assertTrue(stack.search(1) == 5);
        assertTrue(stack.search(0) == -1);
    }

}
