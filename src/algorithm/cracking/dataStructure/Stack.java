package algorithm.cracking.dataStructure;

import java.util.EmptyStackException;

/**
 * 스택은 LIFO에 따라 자료를 배열한다. LinkedList로 구현할 수 있다.
 * 
 * - pop()
 * - push(item)
 * - peek()
 * - isEmpty()
 * 
 * 상수시간에 값을 접근할 수는 없지만, 삽입과 삭제는 상수시간에 가능하다.
 * ❗ 스택의 next는 다음노드가 아닌, 이전 노드를 가리켜야한다.
 * ❗ 스택은 재귀 알고리즘을 사용할 때 유용하다
 * 
 */
public class Stack {
    private static class StackNode {
        int data;
        StackNode next;
        public StackNode(int data) {
            this.data = data;
        }
    }

    private StackNode top; // LIFO
    private int size;

    public void push(int item) {
        if(top == null) {
            StackNode node = new StackNode(item);
            top = node;
        } else {
            StackNode node = new StackNode(item);
            node.next = top;
            top = node;
        }
        size ++;
    }

    public int pop() {
        if(top == null) throw new EmptyStackException();

        int value = top.data;
        top = top.next;

        size --;
        return value;
    }

    public int peek() {
        if(top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
    }
}
