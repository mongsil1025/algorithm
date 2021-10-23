package algorithm.codingInterview.datastructure.linkedList;

import algorithm.codingInterview.datastructure.linkedList.LinkedList.Node;

public class LinkedListSum {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(7);
        l1.append(1);
        // l1.append(6);

        LinkedList l2 = new LinkedList();
        l2.append(5);
        l2.append(9);
        l2.append(9);

        Node result = sum(l2, l1);
        while(result != null) {
            System.out.print(result.data + " > ");
            result = result.next;
        }
    }

    static Node sum(LinkedList l1, LinkedList l2) {
        Node num1 = l1.header.next;
        Node num2 = l2.header.next;

        // validation
        if(num1 == null && num2 != null) {
            return num2;
        } else if(num1 != null && num2 == null) {
            return num1;
        } else if (num1 == null && num2 == null){
            return null;
        }
        // variables
        Node result = new Node();
        Node n = result;
        int carry = 0;

        while(num1 != null && num2 != null) {
            int val = num1.data + num2.data + carry;
            if(val > 9) carry = 1;
            n.next = new Node(val % 10);
            n = n.next;

            num1 = num1.next; num2 = num2.next;
        }

        if(carry > 0) {
            if(num1 != null) {
                addRedundant(num1, n, carry);
            } else if(num2 != null) {
                addRedundant(num2, n, carry);
            }
        } else {
            if(num1 != null) n.next = num1;
            if(num2 != null) n.next = num2;
        }
        return result.next;
    }

    static void addRedundant(Node num, Node n, int carry) {
        while(num != null) {
            int val = num.data + carry;
            if(val > 9) carry = 1;
            n.next = new Node(val % 10);
            n = n.next;
            num = num.next;
        }
        if(carry > 0) {
            n.next = new Node(1);
        } 
    }
}
