package algorithm.cracking.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * LinkedList로 구현한 그래프
 * 
 * 노드의 개수를 n, 각 노드당 간선 e라고 할때, 전체 edge 의 수를 알아내려면 O(n+e)의 시간 복잡도를 가진다.
 * (u, v) 가 path 를 가지고 있는지 확인할 때, O(n) 의 시간 복잡도를 가진다. (list를 순회해야 하기 때문에)
 * 
 * + Graph 객체
 *  - hashMap으로 그래프를 표현한다.
 *  - Key 는 u, Value 는 v 의 리스트들
 *          
 * 
 */

public class GraphByList {
    
    // 0  -  3
    // |  \  |
    // 1  -  2

    // 0 : {2, 3, 1}    1 : {0, 2}
    // 3 : {0, 2}       2 : {3, 0, 1}
    public static class Graph<T> {
        Map<T, ArrayList<T>> hashMap;
        public Graph() {
            hashMap = new HashMap<>();
        }
        public void addNode(T u, T v) {
            hashMap.compute(u, (key, value) -> {
                if(value == null) {
                    ArrayList<T> list = new ArrayList<>();
                    list.add(v);
                    return list;
                } else {
                    value.add(v);
                    return value;
                }
            });
        }
        public void addNodes(T u, T[] vertexes) {
            for(T v : vertexes) {
                this.addNode(u, v);
            }
        }
        public void print() {
            System.out.println(hashMap.toString());
        }
        public boolean hasPath(T u, T v) {
            ArrayList<T> adjacents = hashMap.get(u);
            if(adjacents == null) throw new NoSuchElementException("정점이 그래프에 없습니다.");
            if(adjacents.stream().filter(x -> x.equals(v)).findAny().isPresent()) return true;
            else return false;
        }
    }

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        
        graph.addNodes(0, new Integer[] {2, 3, 1});
        graph.addNodes(1, new Integer[] {0, 2});
        graph.addNodes(2, new Integer[] {3, 0, 1});
        graph.addNodes(3, new Integer[] {0, 2});

        graph.print();

        System.out.println("(0, 1) has Path? " + graph.hasPath(0, 1));
        System.out.println("(3, 1) has Path? " + graph.hasPath(3, 1));
    }

}
