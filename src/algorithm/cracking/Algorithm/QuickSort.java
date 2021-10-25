package algorithm.cracking.Algorithm;

import java.util.Arrays;

/**
 * 퀵정렬
 * 
 * Description : merge sort 와 동일하게 n개의 리스트를 2개씩 분할한다.
 * 퀵정렬은, 임의의 한 값을 pivot으로 지정하고 pivot 보다 작은 요소는 모두 pivot의 왼쪽으로, 큰 원소는 모두 pivot의 오른쪽으로 옮긴다.
 * 그 상태에서, 피벗을 제외한 왼쪽 리스트와 오른쪽 리스트를 다시 동일하게 반복하는 방식이다.
 * 
 * 시간복잡도 : O(nlogn)
 *  - 임의의 pivot 을 기준으로 왼쪽 오른쪽으로 부분배열로 나누므로 재귀호출의 깊이는 O(logN)
 *  - 각각의 패스에서 전체 리스트의 대부분의 레코드를 비교해야 하므로 n번
 * 
 * 공간복잡도 : O(1)
 * 
 * 퀵정렬의 장점 :
 *  - 불필요한 데이터의 이동을 줄이고, 한 번 피벗으로 결정된 원소는 추후 연산에서 제외된다.
 *  - 추가공간이 필요없다.
 * 퀵정렬의 단점 :
 *  - 정렬된 리스트에 대해서는 O(n2) 의 시간복잡도를 가진다.
 *      - 정렬된 피벗 기준으로 RIGHT로 모든 원소가 부분배열로 불균형하게 분할되고
 *      - 총 N 번의 패스가 수행되기 떄문이다.
 * 
 * 피벗을 어떤 값으로 하느냐에 따라 성능이 결정된다. median을 피벗값으로 선택하는게 좋다.
 * 
 * 
 */
public class QuickSort {
    public static void quickSort(int[] array, int left, int right) {
        if(left < right) {
            // partition 후 얻은 pivot
            int index = partition(array, left, right);
            quickSort(array, left, index - 1);
            quickSort(array, index + 1, right);
        }
    }
    public static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        while(left <= right) {
            while(array[left] < pivot) left++;
            while(array[right] > pivot) right--;

            // swap
            if(left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                left ++; 
                right --;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        // input    [2, 1, 9, 7, 6, 8]
        // output   [1, 2, 6, 7, 8, 9]
        int[] array = new int[] {2, 1, 9, 7, 6, 8};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
