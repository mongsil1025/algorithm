package algorithm.cracking.dataStructure;

/**
 * LinkedList는 다음 노드의 포인터를 가지고 있는 자료구조이다.
 * 
 * 1. 삽입(head에 삽입, tail에 삽입), 탐색, 삭제, 출력, 크기를 구현할 줄 알아야 한다.
 * 2. 단방향 LinkedList, 양방향 LinkedList 가 있다.
 * 3. head Node를 감싸는 LinkedList 객체가 있어야 한다.
 * 
 * NullPointerException 에 주의해야 한다.
 * 
 */
public class LinkedList {
    class Node {
        Node next;
        int data;
        public Node(int data) {
            this.data = data;
        }
        public Node() {}
    }
    // 포인터
    Node header;
    int size;

    public LinkedList() {
        header = new Node(); // 빈노드를 만들어준다.
    }
    // 삽입
    public void appendToTail(int data) {
        Node n = header;
        while(n.next != null) {
            n = n.next;
        }
        n.next = new Node(data);
        size ++;
    }
    public void appendToHead(int data) {
        Node next = header.next;
        Node node = new Node(data);
        node.next = next;
        header.next = node;
        size ++;
    }
    // 링크드리스트 안에, 중복값이 없다고 가정한다.
    public void insertBefore(int target, int data) {
        Node n = header;
        while(n.next != null) {
            if(n.next.data == data) {
                break;
            }
            n = n.next;
        }
        Node node = new Node(data);
        node.next = n.next;
        n.next = node;
        size ++;
    }
    // 링크드리스트 안에, 중복값이 없다고 가정한다.
    public void insertAfter(int target, int data) {
        Node n = header.next;
        while(n != null) {
            if(n.data == target) {
                break;
            }
            n = n.next;
        }
        Node node = new Node(data);
        node.next = n.next;
        n.next = node;
        size ++;
    }
    public void print() {
        Node n = header.next;
        while(n != null) {
            System.out.print(n.data + "->");
            n = n.next;
        }
        System.out.println();
    }
    public void delete(int data) {
        Node n = header;
        while(n.next != null) {
            if(n.next.data == data) {
                break;
            }
            n = n.next;
        }
        n.next = n.next.next;
        size --;
    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.appendToTail(1);
        ll.appendToTail(2);
        ll.appendToTail(3);
        ll.appendToTail(4);
        ll.print();
        ll.insertAfter(3, 2);
        ll.print();
        ll.insertBefore(4, 3);
        ll.print();
        ll.delete(2);
        ll.print();
    }
}
