package algorithm.codingInterview.datastructure.linkedList;

import java.util.Arrays;
import java.util.List;

import algorithm.codingInterview.datastructure.linkedList.LinkedList.Node;

public class PalindromeList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        List<Integer> list = Arrays.asList(1, 3, 3, 1);
        for(Integer i : list) {
            l1.append(i);
        }
        // solutionA(l1);
        solutionB(l1);

    }
    static String s1 = "";
    static String s2 = "";

    public static void solutionA(LinkedList l1) {
        isPalindrome(l1.header.next);
        System.out.println(s1 + ", " + s2);

        System.out.println(s1.equals(s2));
    }

    public static String isPalindrome(Node n) {
        if(n == null) return "";
        s1 += n.data;
        s2 += isPalindrome(n.next) + n.data;
        return s2;
    }

    public static void solutionB(LinkedList l1) {

        Node p1 = l1.header.next;
        Node p2 = l1.header.next.next;

        reverseUsingRecursive(p1, p2);

        l1.retrieve();
    }

    public static void reverseUsingRecursive(Node p1, Node p2){
        if(p2 == null || p2.next == null) {
            return;
        }

        reverseUsingRecursive(p1.next, p2.next.next);

        Node last = new Node(p1.next.data);
        p1.next = p1.next.next;
        last.next = p1;
        p1 = last;
    }
}
