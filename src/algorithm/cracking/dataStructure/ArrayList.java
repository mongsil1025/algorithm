package algorithm.cracking.dataStructure;

import java.util.Arrays;

/**
 * ArrayList는 기본적으로 배열로 구현되어 있으며, 배열이 가득 차는 순간, 배열의 크기를 두 배로 늘린다.
 * 크기를 두배로 늘리는 시간은 origin 배열을 복사해야 하므로 O(n)이지만, 통상적으로 발생하는 일이 아니다.
 * 
 * DEFAULT CAPACITY 를 두고, 해당 배열의 공간을 넘어가면, 2배로 늘려준다.
 * 삽입 T.C 는 O(1) 이다. (상환입력시간)
 */
public class ArrayList {
    private static final int DEFAULT_CAPACITY = 10;
    private transient int[] elementData;
    private int size;
    public ArrayList() {
        this.elementData = new int[DEFAULT_CAPACITY];
    }
    public ArrayList(int capacity) {
        this.elementData = new int[capacity];
    }
    public void add(int data) {
        if(size == elementData.length) { // If array is FULL
            this.elementData = grow(size + 1);
        }
        elementData[size] = data;
        size++;
    }

    private int[] grow(int minCapacity) {
        return Arrays.copyOf(elementData, newCapacity(minCapacity)); // 기존 값들을 복사해준다.
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 2배의 사이즈를 더해준다.
        return newCapacity;
    }

    private void print() {
        for(int item : elementData) {
            System.out.print(item + "->");
        }
    }

    public static void main(String[] args) {
        ArrayList myArrayList = new ArrayList();
        myArrayList.add(10);    
        myArrayList.add(5);
        myArrayList.print();
    }
}
