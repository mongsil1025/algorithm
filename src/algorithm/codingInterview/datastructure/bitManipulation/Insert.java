package algorithm.codingInterview.datastructure.bitManipulation;

public class Insert {
    public static void main(String[] args) {
        int answer = insert(Integer.parseInt("10000000000", 2), Integer.parseInt("10011", 2), 2, 6);
        System.out.println(Integer.toBinaryString(answer));
        System.out.println(answer);
    }

    public static int insert(int n, int m, int i, int j) {

        int mask = -1 << (j + 1) | (1 << i);
        int n_cleared = n & mask; // delete bit between i and j
        int m_shifted = m  << i;

        return n_cleared | m_shifted;

    }
}
