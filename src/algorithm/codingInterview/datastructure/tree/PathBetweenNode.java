package algorithm.codingInterview.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class PathBetweenNode {

    // data
    // 1 -> 2 -> 5
    // 3 -> 2

    // input 1, 5
    // output true

    // input 1, 3
    // output false

    // input 3, 5
    // output true
    public static void main(String[] args) {
        Graph graph = new Graph();

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.addAjacents(n2);
        n2.addAjacents(n5);
        n2.addAjacents(n4);
        n3.addAjacents(n2);

        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);

        // 그래프 확인
        // graph.print();

        // 노드들 초기화
        initNodes(graph);

        // BFS
        // System.out.println(bfs_search(graph, n1, n5)); // true
        // System.out.println(search(graph, n1, n3)); // false
        // System.out.println(search(graph, n3, n5)); // true

        // DFS
        // System.out.println(dfs_search(graph, n1, n5)); // true
        // System.out.println(dfs_search(graph, n1, n3)); // false
        System.out.println(dfs_search(graph, n3, n5)); // true

    }
    
    public static class Node {
        int data;
        ArrayList<Node> adjacents;
        State state;
        public ArrayList<Node> getAdjacents() {
            return this.adjacents;
        }
        public Node(int data){
            this.data = data;
            this.adjacents = new ArrayList<>();
        }
        public void addAjacents(Node sibling) {
            this.adjacents.add(sibling);
        }
        public void printNodes() {
            System.out.print(this.data + " : ");
            for(Node siblings : adjacents) {
                System.out.print(siblings.data + ", ");
            }
        }
    }

    public static class Graph {
        ArrayList<Node> nodes;
        public ArrayList<Node> getNodes() {
            return this.nodes;
        }
        public Graph() {
            this.nodes = new ArrayList<>();
        }
        public void addNode(Node n){
            this.nodes.add(n);
        }
        public void print() {
            for(Node node : nodes){
                node.printNodes();
                System.out.println();
            }
        }
    }

    enum State {
        UnVisited, Visited;
    }

    public static void initNodes(Graph g) {
        for(Node n : g.getNodes()){
            n.state = State.UnVisited;
        }
    }

    public static boolean bfs_search(Graph g, Node start, Node end) {
        if(start == end) return true;
        LinkedList<Node> q = new LinkedList<>();
        
        // 탐색을 시작할 노드부터 시작한다. (루트노드)
        start.state = State.Visited;
        q.add(start);
        System.out.print(start.data + "->");

        // BFS start
        while(!q.isEmpty()) {
            Node u = q.pop();
            for(Node v : u.getAdjacents()){
                if(v == end) {
                    return true;
                } else {
                    if(v.state == State.UnVisited) { // 방문하지 않은 노드만 탐색
                        v.state = State.Visited;
                        q.add(v);
                        System.out.print(v.data + "->");
                    }
                }
            }
        }
        
        // 탐색이 끝나도 못찾았으면 false
        return false;
    }

    public static boolean dfs_search(Graph g, Node start, Node end) {
        if(start == null) {
            return false;
        }
        if(start == end) {
            return true;
        }
        start.state = State.Visited;
        for(Node u : start.getAdjacents()) {
            if(u.state == State.UnVisited) {
                if(u == end) {
                    return true;
                } else {
                    return dfs_search(g, u, end);
                }  
            }
        }
        return false;
    }
}
