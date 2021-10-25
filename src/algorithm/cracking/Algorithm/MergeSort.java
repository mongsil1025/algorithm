package algorithm.cracking.Algorithm;

import java.util.Arrays;

/**
 * 병합 정렬
 * 
 * Description : 분할정복, 재귀로 구현한다.
 * array를 두 개의 부분배열로 나누어 각각 정렬한 다음, 다시 하나로 합치는 방법이다.
 * 
 * 시간복잡도 : O(nlogn)
 * - 배열의 원소의 개수가 n일때, 2개의 부분배열로 나눌 경우, 재귀호출의 깊이는 O(logN)
 * - merge() 함수로 각 부분배열 (최대n) 의 비교연산이 필요하다. O(N)
 * - + 이동횟수는 임시배열에 정렬한 값을 넣었다가, 다시 원래 배열로 넣어야 하기 때문에 2n 의 횟수가 필요하다
 * 
 * 공간복잡도 : O(n)
 * - 임시배열을 이용하므로
 * 
 * 병합정렬의 장점 :
 *  - 다른 배열에 복사한 후, 원래 배열에 이동하므로 안정적이다.
 *  - 또한, 입력 데이터가 무엇이든 간에 정렬되는 시간이 동일하다. (최악, 평균, 최선 모두 동일)
 * 병합정렬의 단점 :
 *  - 추가 공간이 필요하고, 레코드의 크기가 크다면, 이동횟수가 늘어나므로 매우 큰 시간적 낭비를 초래한다.
 *  - 이를 보완하기 위해 링크드리스트를 사용하는 방법이 있다.
 * 
 */
public class MergeSort {
    
    // input    [2, 1, 9, 7, 6, 8]
    // output   [1, 2, 6, 7, 8, 9]
    public static void mergeSort(int[] array, int[] helper, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, helper, low, mid); // left array 선 정렬
            mergeSort(array, helper, mid + 1, high); // right array 후 정렬
            // conquer
            merge(array, helper, low, mid, high);
        }        
    }

    public static  void merge(int[] array, int[] helper, int low, int pivot, int high) {
        // 먼저 conquer할 배열을 임시배열에 옮긴다.
        for(int i=low; i <= high; i++){
            helper[i] = array[i];
        }

        int leftPoint = low;
        int rightPoint = pivot + 1;

        int currPoint = leftPoint;

        while(leftPoint <= pivot && rightPoint <= high) {
            if(helper[leftPoint] <= helper[rightPoint]) {
                array[currPoint++] = helper[leftPoint];
                leftPoint++;
            } else {
                array[currPoint++] = helper[rightPoint];
                rightPoint++;
            }
        }

        // 왼쪽에 남은 애들이 있다면 (왼쪽애들이 다 큰애들이라면)
        // 남은 배열 공간에 복사해준다.
        // 오른쪽을 보지 않아도 되는 이유는, 이미 helper 배열에 오른쪽의 맨뒤들은 똑같이 자리잡고 있기 떄문이다.
        int remaining = pivot - leftPoint;
        for(int i=0; i<= remaining; i++) {
            array[currPoint + i] = helper[leftPoint + i];
        }
    }

    public static void main(String[] args) {
        // input    [2, 1, 9, 7, 6, 8]
        // output   [1, 2, 6, 7, 8, 9]
        int[] array = new int[] {2, 1, 9, 7, 6, 8};
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}
