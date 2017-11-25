package graphs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UndirectedGraph {

    private List<Vertex> vertexList = new ArrayList<>();
    private List<Edge> edgeList = new ArrayList<>();
    private boolean[] connected;
    private Edge[] edgeTo;
    private int counter;

    public UndirectedGraph(int count) {
        connected = new boolean[count];
        edgeTo = new Edge[count];
    }

    public Vertex getVertex(int index) {
        if (!isExistVertex(index)) {
            Vertex e = new Vertex(index);
            vertexList.add(e);
            return e;
        }
        return vertexList.stream().filter(vertex -> vertex.getValue() == index).findFirst().get();
    }

    private boolean isExistVertex(int index) {
        return vertexList.stream().anyMatch(vertex -> vertex.getValue() == index);
    }

    public List<Edge> adjacents(Vertex vertex) {
        return edgeList.stream().filter(edge -> {
            Vertex v1 = edge.either();
            return v1.equals(vertex) || edge.other(v1).equals(vertex);
        }).collect(Collectors.toList());
    }

    public void addEdge(Edge edge) {
        if (!isExistEdge(edge)) {
            Vertex either = edge.either();
            Vertex v1 = getVertex(either.getValue());
            Vertex v2 = getVertex(edge.other(either).getValue());
            edgeList.add(new Edge(v1, v2));
        }
    }

    private boolean isExistEdge(Edge edge) {
        return edgeList.stream().anyMatch(edge1 -> edge1.equals(edge));
    }

    public void dfs(Vertex vertex) {
        counter++;
        connected[vertex.getValue()] = true;
        System.out.println(vertex.getValue());
        for (Edge edge : adjacents(vertex)) {
            Vertex to = edge.other(vertex);
            edgeTo[to.getValue()] = edge;
            if (!connected[to.getValue()]) {
                printTabulation();
                dfs(to);
            }
        }
        counter--;
    }

    private void printTabulation() {
        for (int i = 0; i < counter; i++) {
            System.out.print("  ");
        }
        System.out.print("- ");
    }
}
