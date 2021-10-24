package algorithm.cracking.dataStructure;


/**
 * Linked List 와 Hash Code Function 을 이용해서 HashTable을 구현한다.
 * 
 * input 으로 String 이 주어졌을 때, value 를 HashTable에 저장한다.
 * 
 * - 해시코드 함수 = mod(key)
 * - 충돌을 방지하기 위해, LinkedList를 사용한다.
 * - 탐색 Time Complexity
 *  - 충돌이 자주 발생한다면 최악의 경우 O(n)
 *  - 일반적인 경우(해시함수를 잘 이용했을 경우) O(1)
 *  - 값을 저장해두는 구조를 이진탐색트리를 사용한다면 O(logN)
 * 
 * - 충돌을 방지하는 방법
 *  - HashTable 의 저장공간을 늘린다. (저장하고자 하는 값이 해쉬 테이블의 크기의 50% 라면 해쉬 테이블의 크기를 늘려준다)
 *  - Hash 함수를 최적화 한다.
 *      - SHA 256
 * 
 *  - Collision 해결 알고리즘
 *      - Chaining 기법 : 아래 예시처럼 해쉬 테이블 저장공간 외의 공간을 활용한다.
 *      - Linear Probing 기법 : 해시테이블 저장 공간 중, 비어 있는 공간을 찾아서 저장한다 (충돌이 일어나면 그 공간 + 1 인덱스에 값을 저장한다.)
 */
public class HashTable {

    static class Node {
        Node next;
        String data;
        public Node(String d) {
            this.data =  d;
        }
        public void print() {
            System.out.print(this.data);
            Node n = next;
            while(n != null) {
                System.out.print("->" + n.data);
                n = n.next;
            }
        }
    }
    
    static Node[] hashTable = new Node[10];

    /**
     * convert String to hashCode And save to Hash Table
     * notice that String.hashCode() can have negative value (-2^31 to 2^31 - 1)
     * Math.abs(hashCode()) is not safe becuase Math.abs(Integer.MIN_VALUE) will return OverflowException
     * So pefrom bit manipulation by 0x7fffffff (in hexadecimal) to convert firt bit (signal) to get positive value
     * @param key
     */
    public static void setHash(String key) {
        int hashKey = (key.hashCode() & 0x7fffffff) % 10;
        Node root = hashTable[hashKey];
        if(root == null) {
            root = new Node(key);
            hashTable[hashKey] = root;
        } else {
            while(root.next != null) {
                root = root.next;
            }
            root.next = new Node(key);
        }
    }

    public static boolean find(String key) {
        int hashKey = (key.hashCode() & 0x7fffffff) % 10;
        Node node = hashTable[hashKey];
        if(node == null) return false;
        while(node != null) {
            if (key.equals(node.data)) return true;
            node = node.next;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] values = new String[] {"hi", "I'm", "SunMin", "Wish", "To", "Work"};
        for(String v : values) {
            setHash(v);
        }
        for(Node n : hashTable) {
            if(n != null) {
                n.print();
                System.out.println();
            }
        }
        // Find If input exists
        System.out.println("SunMin exixts ? " + find("SunMin"));
        System.out.println("SanMin exixts ? " + find("SanMin"));
    }

}
