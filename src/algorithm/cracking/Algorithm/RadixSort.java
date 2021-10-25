package algorithm.cracking.Algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 기수 정렬
 * 
 * 다른 정렬과는 달리, 레코드를 비교하지 않는다. 
 * 정렬할 수 있는 레코드의 타입이 한정된다. (유한한 비트로 구성되어 있는 경우에만 사용할 수 있다.)
 * 
 * Description : 각 자릿수를 순회해 나가면서 각 자리의 값에 따라 그룹을 나눈다. (첫번째 자리수 부터 높은 자리수 순서대로)
 * 자릿수만큼의 큐가 필요하다.
 * 
 * 시간복잡도 : O(kn) 여기서 k는 자릿수의 개수
 * 
 * 
 */
public class RadixSort {

    public static void radixSort(int[] array, int digit) {

        @SuppressWarnings("unchecked")
        Queue<Integer>[] queues = new Queue[10];
        for(int i=0; i<10; i++) {
            queues[i] = new LinkedList<Integer>();
        }

        int factor = 1;
        for(int d=0; d<digit; d++) { // O(d) (자릿수)

            for(int j=0; j<array.length; j++) { // O(n) (원소개수)
                LinkedList<Integer> q = (LinkedList<Integer>) queues[(array[j] / factor) % 10];
                q.add(array[j]);
            }

            // 다시 꺼내서 넣는다.
            for(int b=0,i=0; b<queues.length; b++) {
                while(!queues[b].isEmpty()) {
                    array[i++] = queues[b].remove();
                }
            }

            factor *= 10;
        }

    }

    public static void main(String[] args) {
        int[] array = new int[] {52, 87, 42, 77, 53, 47, 85, 72};
        radixSort(array, 2);
        System.out.println(Arrays.toString(array));
    }
    
}
