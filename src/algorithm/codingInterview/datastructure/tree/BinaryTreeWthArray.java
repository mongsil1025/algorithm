package algorithm.codingInterview.datastructure.tree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * n이 주어졌을 때, 1~n 까지의 숫자를 완전이진트리로 구성해보자
 * 
 * 1차원 배열을 이용해서 구현했을 경우 (parent[i]), 내 노드가 어떤 부모에 종속되어있는지만 확인할 수 있다.
 * 부모가 어떤 자식을 가지고 있는지 확인하려면 배열 전체를 돌아야 할 것이다.
 * 
 * 전위,중위,후위 순회가 불가하다.
 * 
 * @author  sunmin
 * @since   2021.10.04
 */
public class BinaryTreeWthArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        int[] parent = new int[n+1];

        parent[1] = 1;
        for(int i=2; i<n+1; i++) {
            parent[i] = i / 2;
        }

        System.out.println(Arrays.toString(parent));
    }
    
}
