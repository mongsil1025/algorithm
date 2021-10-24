package algorithm.cracking.dataStructure;

import java.util.NoSuchElementException;

/**
 * 큐는 FIFO에 따라 자료를 배열한다. 스택과 마찬가지로 LinkedList로 구현할 수 있다.
 * 배열로 구현할 수도 있지만, 그러려면 Buffer를 지정해줘야 한다. 
 * 원형큐 (last_index + 1) % 배열의 사이즈 의 인덱스로 값을 순환시키는 방법도 있다.
 * 
 * - remove()
 * - add(item)
 * - peek()
 * - isEmpty
 * 
 * 큐는 BFS, 캐시 구현에 사용된다.
 * 
 */
public class Queue {
    private static class QueueNode {
        QueueNode next;
        int data;
        public QueueNode(int data) {
            this.data = data;
        }
    }

    QueueNode first;
    QueueNode last;

    public void add(int item) {
        QueueNode node = new QueueNode(item);
        if(last != null) {            
            last.next = node;
        } 
        last = node;
        // ❗ fist 가 null 이면 last로 넣어줘야 한다. (그래야 뒤에 insert가 된다)
        if(first == null) {
            first = last;
        }
    }

    public int remove() {
        if(first == null) throw new NoSuchElementException();
        int value = first.data;
        first = first.next;
        // ❗ fist 가 null 이면 last도 null로 갱신한다. (그래야 또 들어올때, null 부터 추가할 수 있다.)
        if(first == null) {
            last = null;
        }
        return value;
    }

    public int peek() {
        if(first == null) throw new NoSuchElementException();
        return first.data;
    }
    
    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        queue.remove();
        System.out.println(queue.peek());
    }
}
